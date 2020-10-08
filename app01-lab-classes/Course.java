
/**
 * Write a description of class Course here.
 *
 * @author (Lily Mccullough)
 * @version (07/10/2020)
 */
public class Course
{
    // the students course ID
    public static String courseID = "G401";
    // the students course name
    public static String courseName = "Games Development";

  /**
   * Assigns a course ID and course name
  */
    public Course()
    {
        courseID = "G401";
        courseName = "Games Development";
    }
  /**
   * Returns the course ID and name
  */
  public String getCourse()
   {
       return courseID + " " + courseName;
   }
}
 

