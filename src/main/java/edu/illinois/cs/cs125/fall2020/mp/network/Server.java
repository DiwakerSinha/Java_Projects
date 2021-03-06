package edu.illinois.cs.cs125.fall2020.mp.network;

import androidx.annotation.NonNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import edu.illinois.cs.cs125.fall2020.mp.application.CourseableApplication;
import edu.illinois.cs.cs125.fall2020.mp.models.Rating;
import edu.illinois.cs.cs125.fall2020.mp.models.Summary;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Development course API server.
 *
 * <p>Normally you would run this server on another machine, which the client would connect to over
 * the internet. For the sake of development, we're running the server right alongside the app on
 * the same device. However, all communication between the course API client and course API server
 * is still done using the HTTP protocol. Meaning that eventually it would be straightforward to
 * move this server to another machine where it could provide data for all course API clients.
 *
 * <p>You will need to add functionality to the server for MP1 and MP2.
 */

public final class Server extends Dispatcher {
  private final int four = 4;
  @SuppressWarnings({"unused", "RedundantSuppression"})
  private static final String TAG = Server.class.getSimpleName();

  private final Map<String, String> summaries = new HashMap<>();

  private MockResponse getSummary(@NonNull final String path) {
    String[] parts = path.split("/");
    if (parts.length != 2) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST);
    }

    String summary = summaries.get(parts[0] + "_" + parts[1]);
    if (summary == null) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
    }
    return new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(summary);
  }

  @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
  private final Map<Summary, String> courses = new HashMap<>();



  private MockResponse getCourse(@NonNull final String path) {
    String[] parts = path.split("/");
    if (parts.length != four) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST);
    }
    Summary summary = new Summary(parts[0], parts[1], parts[2], parts[3], "");
    String course = courses.get(summary);
    if (course == null) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
    }
    return new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(course);
  }

  private final Map<Summary, Map<String, Rating>> ratings = new HashMap<>();
  private String id = "";
  private Rating rating = new Rating();

  private MockResponse getRating(@NonNull final String path, @NonNull final RecordedRequest request)
      throws JsonProcessingException {

    ObjectMapper map = new ObjectMapper();
    String[] parts = path.split("/");

    if (!path.contains("?")) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST);
    }

    final int last = parts.length - 1;
    id = parts[last].substring(parts[last].indexOf("=") + 1);

    final int uid = 36;

    if (last < four) {
      parts[3] = parts[3].substring(0, parts[3].indexOf("?"));
    }

    Summary summary = new Summary();
    boolean check = false;

    for (Summary s : courses.keySet()) {
      if (s.getYear().equals(parts[0])
          && s.getSemester().equals(parts[1])
          && s.getDepartment().equals(parts[2])
          && s.getNumber().equals(parts[3])) {
        check = true;
        summary = s;
        break;
      }
    }

    if (request.getMethod().equals("GET")) {
      Map<String, Rating> r = ratings.getOrDefault(summary, new HashMap<>());
      if (r.get(id) == null) {
        r.put(id, new Rating(id, Rating.NOT_RATED));
      }
      ratings.put(summary, r);
      if (id.length() != uid) {
        return new MockResponse().setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST);
      } else if (!check) {
        return new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
      }

      rating = ratings.get(summary).get(id);
      return new MockResponse()
              .setResponseCode(HttpURLConnection.HTTP_OK)
              .setBody(map.writeValueAsString(rating));
    } else if (request.getMethod().equals("POST")) {
      return postRating(path, request);
    }
    return new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_IMPLEMENTED);
  }

  private MockResponse postRating(@NonNull final String path, @NonNull final RecordedRequest request) {
    String[] parts = path.split("/");
    if (parts.length != four) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST);
    }
    String[] temp = path.split("[?]client=");
    if (temp.length != 2) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST);
    }
    String[] ar = parts[four - 1].split("[?]client=");
    Summary summary = new Summary(parts[0], parts[1], parts[2], ar[0], null);
    String post = request.getBody().readUtf8();
    Rating rati = new Rating(ar[1], Rating.NOT_RATED);
    try {
      rati = mapper.readValue(post, Rating.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    Map<String, Rating> inner = new HashMap<>();
    inner.put(ar[1], rati);
    Map<String, Rating> tempInner = new HashMap<>();
    tempInner = ratings.getOrDefault(summary, inner);
    tempInner.put(ar[1], rati);
    ratings.put(summary, tempInner);
    String course = courses.get(summary);
    if (course == null) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
    }
    return new MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_MOVED_TEMP)
            .setHeader("Location", "/rating/" + path);
  }
  @NonNull
  @Override
  public MockResponse dispatch(@NonNull final RecordedRequest request) {
    try {
      String path = request.getPath();
      if (path == null || request.getMethod() == null) {
        return new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
      } else if (path.equals("/") && request.getMethod().equalsIgnoreCase("HEAD")) {
        return new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK);
      } else if (path.startsWith("/summary/")) {
        return getSummary(path.replaceFirst("/summary/", ""));
      } else if (path.startsWith("/course/")) {
        return getCourse(path.replaceFirst("/course/", ""));
      } else if (path.startsWith("/rating/")) {
        return getRating(path.replaceFirst("/rating/", ""), request);
      }
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
    } catch (Exception e) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR);
    }
  }

  private static boolean started = false;

  /**
   * Start the server if has not already been started.
   *
   * <p>We start the server in a new thread so that it operates separately from and does not
   * interfere with the rest of the app.
   */
  public static void start() {
    if (!started) {
      new Thread(Server::new).start();
      started = true;
    }
  }

  private final ObjectMapper mapper = new ObjectMapper();

  private Server() {
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    loadSummary("2020", "fall");
    loadCourses("2020", "fall");

    try {
      MockWebServer server = new MockWebServer();
      server.setDispatcher(this);
      server.start(CourseableApplication.SERVER_PORT);

      String baseUrl = server.url("").toString();
      if (!CourseableApplication.SERVER_URL.equals(baseUrl)) {
        throw new IllegalStateException("Bad server URL: " + baseUrl);
      }
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  @SuppressWarnings("SameParameterValue")
  private void loadSummary(@NonNull final String year, @NonNull final String semester) {
    String filename = "/" + year + "_" + semester + "_summary.json";
    String json =
        new Scanner(Server.class.getResourceAsStream(filename), "UTF-8").useDelimiter("\\A").next();
    summaries.put(year + "_" + semester, json);
  }

  @SuppressWarnings("SameParameterValue")
  private void loadCourses(@NonNull final String year, @NonNull final String semester) {
    String filename = "/" + year + "_" + semester + ".json";
    String json =
        new Scanner(Server.class.getResourceAsStream(filename), "UTF-8").useDelimiter("\\A").next();
    try {
      JsonNode nodes = mapper.readTree(json);
      for (Iterator<JsonNode> it = nodes.elements(); it.hasNext(); ) {
        JsonNode node = it.next();
        Summary course = mapper.readValue(node.toString(), Summary.class);
        courses.put(course, node.toPrettyString());
      }
    } catch (JsonProcessingException e) {
      throw new IllegalStateException(e);
    }
  }
}
