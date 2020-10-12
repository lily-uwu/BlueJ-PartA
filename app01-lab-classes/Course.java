
/**
 * This class assigns values related to the course a student may be on. In this case we include the course title and course ID.
 *
 * @author (Lily Mccullough)
 * @version (07/10/2020)
 */
public class Course
{
    // the course ID
    private String courseID;
    // the course name
    private String courseName;

  /**
   * Assigns a course ID and course name.
  */
    public Course(String getCourseID, String getCourseName)
    {
        courseID = getCourseID;
        courseName = getCourseName;
    }
  /**
   * Prints the course ID and name.
  */
  public void printCourse()
   {
       System.out.println("Course: " + courseID + ", " + courseName);
   }
}
 

