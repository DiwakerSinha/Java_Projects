package edu.illinois.cs.cs125.fall2020.mp.models;


/**
 * Rating class.
 */
public class Rating {
  /**
   * Rating indicating that the course has not been created.
   */
  public static final double NOT_RATED = -1.0;
  private String id;
  private double rating;

  /**
   * Constructor.
   * @param setID setter.
   * @param setRating setter.
   */
  public Rating(final String setID, final double setRating) {
    id = setID;
    rating = setRating;
  }

  /**
   * Empty json.
   */
  public Rating() { }

  /**
   * method to return id.
   * @return id;
   */
  public String getId() {
    return id;
  }
  /**
   * method to return rating.
   * @return rating;
   */
  public double getRating() {
    return rating;
  }

}
