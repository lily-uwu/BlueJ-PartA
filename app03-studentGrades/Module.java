
/**
 * Represents the modules that are assigned to a course, individual marks will be assigned to each module
 *
 * @author Lily Mccullough
 * @version 26/10/2020
 */
public class Module
{
    // String for module title
    private String moduleTitle;
    // String for module code
    private String moduleCode;
    //Integer for the module mark
    private int moduleMark;

    /**
     * Assigns initial values to a module
     */
    public Module(String moduleTitle, String moduleCode)
    {
        this.moduleTitle = moduleTitle;
        this.moduleCode = moduleCode;
        moduleMark = 0;
    }
    
    /**
     * Change the module mark
     */
    public void changeModuleMark(int changeMark)
    {
        this.moduleMark = changeMark;
    }
    
    /**
     * Print the information for this module
     */
    public void printModule()
    {
        System.out.println("Module: " + moduleCode + ", " + moduleTitle + ". Current mark: " + moduleMark);
    }
}
