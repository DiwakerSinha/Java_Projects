package edu.illinois.cs.cs125.fall2020.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.illinois.cs.cs125.fall2020.mp.R;
import edu.illinois.cs.cs125.fall2020.mp.application.CourseableApplication;
import edu.illinois.cs.cs125.fall2020.mp.databinding.ActivityCourseBinding;
import edu.illinois.cs.cs125.fall2020.mp.models.Course;
import edu.illinois.cs.cs125.fall2020.mp.models.Rating;
import edu.illinois.cs.cs125.fall2020.mp.models.Summary;
import edu.illinois.cs.cs125.fall2020.mp.network.Client;
/**
 * Creates a new activity when a course title is clicked.
 */
public class CourseActivity extends AppCompatActivity
        implements Client.CourseClientCallbacks, RatingBar.OnRatingBarChangeListener {

  // Binding to the layout in activity_main.xml
  private ActivityCourseBinding binding;
  private static final String TAG = CourseActivity.class.getSimpleName();
  private Summary summary = new Summary();
    /**
     * The method logs that a new activity has been created and does work.
     * @param savedInstanceState saved state.
     */
  protected void onCreate(final @Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "Course Activity Started");
    Intent intent = getIntent();
    binding = DataBindingUtil.setContentView(this, R.layout.activity_course);

    String serialized = intent.getStringExtra("COURSE");
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    try {
      summary = mapper.readValue(serialized, Summary.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    CourseableApplication application = (CourseableApplication) getApplication();
    application.getCourseClient().getCourse(summary, this);
    application.getCourseClient().getRating(summary, application.getClientID(), this);
    binding.rating.setOnRatingBarChangeListener(this);
  }
   /**
   * course callback for summary and course.
   * @param sum summary.
   * @param course course.
   */
  @Override
  public void courseResponse(final Summary sum, final Course course) {
    binding.tv.setText(course.getDescription());
  }

  /**
   * to show stored rating.
   * @param sum s.
   * @param rat r.
   */
  public void yourRating(final Summary sum, final Rating rat) {
    binding.rating.setRating((float) rat.getRating());
  }

  /**
   * rating changed final.
   * @param ratingB rb.
   * @param rating r.
   * @param fromUser fU.
   */
  public void onRatingChanged(
          final RatingBar ratingB,
          final float rating,
          final boolean fromUser) {
    CourseableApplication app = (CourseableApplication) getApplication();
    Rating rat = new Rating(app.getClientID(), (double) rating);
    app.getCourseClient().postRating(summary, rat, this);
  }
}
