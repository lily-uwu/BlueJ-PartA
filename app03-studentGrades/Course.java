
/**
 * Represents a course which can be assigned to a student. This course will contain 4 modules.
 *
 * @author Lily Mccullough
 * @version 26/10/2020
 */
public class Course
{
    // The name for the course
    private String courseName;
    // The ID for the course
    private String courseID;
    // Integer for the total mark (the marks from the modules added together and divided by amount of modules)
    private int totalMark;
    // String for the final grade, this differs from the total mark as it will print a string value representing a grade from A-F
    private String finalGrade;

    /**
     * Constructor to assign intital values to fields
     */
    public Course(String courseName, String courseID)
    {
        this.courseName = courseName;
        this.courseID = courseID;
        totalMark = 0;
        finalGrade = null;
    }

    /**
     * Method to print the details of the course
     */
    public void printCourseDetails()
    {
        System.out.println("Course: " + courseID + ", " + courseName);
    }
}
