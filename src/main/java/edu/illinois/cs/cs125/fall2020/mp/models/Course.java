package edu.illinois.cs.cs125.fall2020.mp.models;
import java.util.Objects;

/** Class to show the full description of the courses.
*
*/
public class Course extends Summary {

  private String description;

  /**
   *Empty course.
   */
  public Course() {}

  /**
   * Creates Course with description.
   * @param setDescription
   */
  public Course(final String setDescription) {
    description = setDescription;
  }

  /**
   * @return description.
   */
  public String getDescription() {
    return description;
  }

   /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof Course)) {
      return false;
    }
    Course course = (Course) o;
    return Objects.equals(description, course.description);
  }

  /**Gives hashcode.
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(description);
  }

}
