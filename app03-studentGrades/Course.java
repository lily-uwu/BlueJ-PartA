
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
    
    // To call the Module constructor and assign it to four fields for the four modules (probably stupid way of doing this)
    public Module module1;
    public Module module2;
    public Module module3;
    public Module module4;

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

    public void assignModules(Module module1, Module module2, Module module3, Module module4)
    {
        this.module1 = module1;
        this.module2 = module2;
        this.module3 = module3;
        this.module4 = module4;
    }
    
    /**
     * Change the module marks
    */
    public void changeModuleMark(int changeMark1, int changeMark2, int changeMark3, int changeMark4)
    {
        module1.moduleMark = changeMark1;
        module2.moduleMark = changeMark2;
        module3.moduleMark = changeMark3;
        module4.moduleMark = changeMark4;
    }
    
    /**
     * Method to print the details of the course, including modules
     */
    public void printCourseDetails()
    {
        System.out.println("Course: " + courseID + ", " + courseName);
        System.out.println("Course Modules: ");
        module1.printModule();
        module2.printModule();
        module3.printModule();
        module4.printModule();
    }
}
