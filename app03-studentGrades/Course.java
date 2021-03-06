
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
    public String finalGrade;
    
    // To call the Module constructor and assign it to four fields for the four modules (probably stupid way of doing this)
    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;

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
     * Assign 4 modules to  a course
     */
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
     * Method to calculate the final grade by adding the total and dividing my amount of modules
     */
    public void calculateFinalGrade(Module module1, Module module2, Module module3, Module module4)
    {
        totalMark = ((module1.moduleMark + module2.moduleMark + module3.moduleMark + module4.moduleMark) / 4);
    }
    
    /**
     * If statement to figure out which grading bracket the student should be in
     */
    public String getFinalGrade()
    {
        if(totalMark >= 0 && totalMark <= 39)
            {finalGrade = "F";}
        if(totalMark >= 40 && totalMark <= 49)
            {finalGrade = "D";}
        if(totalMark >= 50 && totalMark <= 59)
            {finalGrade = "C";}
        if(totalMark >= 60 && totalMark <= 69)
            {finalGrade = "B";}
        if(totalMark >= 70 && totalMark <= 100)
            {finalGrade = "A";}
            
        return finalGrade;
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
