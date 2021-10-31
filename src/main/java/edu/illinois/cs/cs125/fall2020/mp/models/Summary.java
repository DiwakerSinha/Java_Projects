package edu.illinois.cs.cs125.fall2020.mp.models;

import androidx.annotation.NonNull;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Model holding the course summary information shown in the course list.
 *
 * <p>You will need to complete this model for MP0.
 */
@SuppressWarnings("checkstyle:RegexpSingleline")
public class Summary implements SortedListAdapter.ViewModel {
  private String year;

  /**
   * Default empty class.
   */
  public Summary() {
  }

  /**
   * Get the year for this Summary.
   *
   * @return the year for this Summary
   */
  public final String getYear() {
    return year;
  }

  private String semester;

  /**
   * Get the semester for this Summary.
   *
   * @return the semester for this Summary
   */
  public final String getSemester() {
    return semester;
  }

  private String department;

  /**
   * Get the department for this Summary.
   *
   * @return the department for this Summary
   */
  public final String getDepartment() {
    return department;
  }

  private String number;

  /**
   * Get the number for this Summary.
   *
   * @return the number for this Summary
   */
  public final String getNumber() {
    return number;
  }

  private String title;

  /**
   * Get the title for this Summary.
   *
   * @return the title for this Summary
   */
  public final String getTitle() {
    return title;
  }

  /** Merges parameters to form req String.
   * @return A merged string.
   */
  public String merged() {
    return department + " " + number + ": " + title;
  }
  /**
   * Create a Summary with the provided fields.
   *
   * @param setYear       the year for this Summary
   * @param setSemester   the semester for this Summary
   * @param setDepartment the department for this Summary
   * @param setNumber     the number for this Summary
   * @param setTitle      the title for this Summary
   */
  public Summary(
      final String setYear,
      final String setSemester,
      final String setDepartment,
      final String setNumber,
      final String setTitle) {
    year = setYear;
    semester = setSemester;
    department = setDepartment;
    number = setNumber;
    title = setTitle;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof Summary)) {
      return false;
    }
    Summary course = (Summary) o;
    return Objects.equals(year, course.year)
        && Objects.equals(semester, course.semester)
        && Objects.equals(department, course.department)
        && Objects.equals(number, course.number);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(year, semester, department, number);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public <T> boolean isSameModelAs(@NonNull final T model) {
    return equals(model);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public <T> boolean isContentTheSameAs(@NonNull final T model) {
    return equals(model);
  }

  /** Compares the two courseModels and return 0 if the two courseModels are equal,
   * -1 if courseModel1 comes before courseModel2,
   * and 1 if courseModel2 comes before courseModel1.
   */
  public static final Comparator<Summary> COMPARATOR;
  static {
    COMPARATOR = (courseModel1, courseModel2) -> {

      String course1 = courseModel1.department + courseModel1.number + courseModel1.title;
      String course2 = courseModel2.department + courseModel2.number + courseModel2.title;

      if (course1.compareTo(course2) > 0) {
        return 1;
      } else if ((course1).compareTo(course2) < 0) {
        return -1;
      } else {
        return 0;
      }
    };
  }

  /** The function accepts a list of Summary objects and a text and searches for the text in the objects.
   *
   * @param courses takes the list of Summary objects
   * @param text accepts the String to be searched for
   * @return Returns the courses according to the search using text.
   */
  public static List<Summary> filter(@NonNull final List<Summary> courses, @NonNull final String text) {
    ArrayList<Summary> toReturn = new ArrayList<>();
    for (int i = 0; i < courses.size(); i++) {
      if ((courses.get(i).merged()).toLowerCase().contains(text.toLowerCase())) {
        toReturn.add(courses.get(i));
      } else if (courses.get(i).merged().contains(text)) {
        toReturn.add(courses.get(i));
      } else if ((courses.get(i).merged()).toLowerCase().contains(text.toLowerCase())) {
        toReturn.add(courses.get(i));
      }
    }
    return toReturn;
  }
}
