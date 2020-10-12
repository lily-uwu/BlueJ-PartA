
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author (Lily Mccullough)
 * @version (07/10/2020)
 */
public class Student
{
    // the student's name
    private String name;
    // the student ID
    private String id;
    // the students given credits
    private int credits;
    // students class
    private Course course;

    /**
     * Create a new student with a given name and ID number.
    */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    /**
     * Return the full name of this student.
    */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this student.
    */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Return the student ID of this student.
    */
    public String getStudentID()
    {
        return id;
    }

    /**
     * Add credits to student.
    */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    /**
     * Return student's credits.
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
    */
    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
    }
    
    /**
     * Add the course to the student
    */
    public void assignStudentCourse(Course course)
    {
       this.course = course;
    }
    
    /**
     * print the student id, full name, credits and course to the terminal
    */
    public void print()
    {
        System.out.println(name + ", student ID: " + id + ", credits: " + credits + ", course: ");
        course.printCourse();        
    }
}
