
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Lily Mccullough
 * @version 25/11/2020
 */
public class StockApp
{
    // Use to get user input
    private InputReader input;
    private StockManager manager;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        manager = new StockManager();
    }

    /**
     * Method to run the program, after run the user can use the program completely
     */
    public void run()
    {
        printHeading();
        getMenuChoice();
    }
    
    /**
     * Contains the options a user may choose and calls the methods for whatever action they have chosen.
     */
    public void getMenuChoice()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = input.getInput();
            finished = true;
        }
    }
    
    private void addProduct()
    {
        // Prompt to inform the user what they need to input
        System.out.println("Input the product ID: ");
        // Get an input from the user and assign to variable
        String inputID = input.getInput();
        // Prompt to inform the user what they need to input
        System.out.println("Input the product name: ");
        String inputName = input.getInput();
        System.out.println("");
        // Convert the String input to an integer
        int convertID = Integer.parseInt(inputID);
        // Add the product
        manager.addProduct(new Product(convertID, inputName));
        printMenuChoices;
    }
    
    
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Student Name");
        System.out.println("******************************");
    }
}
