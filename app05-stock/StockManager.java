import java.util.ArrayList;

/**
 * Simulates a stock management system where a user can add new products to their stock list
 * and make changes to these products such as quantity, name etc.
 * 
 * @author Lily Mccullough
 * @version 25/11/2020
 */
public class StockManager
{
    // Creates an array to contain products
    private ArrayList<Product> stock;
    private Product product;

    /**
     * Initialise the stock manager
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }
    
    /**
     * Get the current size of the stock list (how many products are in the stock list)
     */
    public int getStockSize()
    {
        return stock.size();
    }
    
    /**
     * Tests whether the ID entered already exists in the stock array
     */
    public boolean idChecker(int inputID)
    {
        boolean bool = false;
        for(Product product : stock)
        {
            int testID = product.getID();
            if(testID != inputID)
            {
                bool = false;
            }
            if(testID == inputID)
            {
                bool = true;
                break;
            }
        }
        return bool;
    }
    
    /**
     * Tests if the input name is empty, if so it returns an error message.
     */
    public boolean nameChecker(String inputName)
    {
        boolean testName = true;
        if(inputName.isEmpty() == true)
        {
            testName = true;
        }
        if(inputName.isEmpty() == false)
        {
            testName = false;
        }
        return testName;
    }
    
    /**
     * Add a product to the stock list
     */
    public void addProduct(Product item)
    {
        boolean checkID = idChecker(item.id);
        boolean checkName = nameChecker(item.name);
        if(checkID == false && checkName == false)
        {
            System.out.println("Product with ID: " + item.id + " name: " + item.name + " has been added!");
            stock.add(item);
        }
        if(checkID == true)
        {
            System.out.println("Product with ID: " + item.id + " has already been found. Product has not been added.");
        }
        if(checkName == true)
        {
            System.out.println("You have entered an empty name. Please re-enter");
        }
    }
    
    /**
     * Remove a product object from the stock list based on ID.
     */
    public void removeProduct(int inputID)
    {
        boolean checkID = idChecker(inputID);
        if(checkID == true)
        {
            for(Product product : stock)
            {
                if(product.id == inputID)
                {
                    System.out.println("Product with ID: " + inputID + " has been removed from the stock list.");
                    stock.remove(product);
                    break;
                }
            }
        }
        if(checkID == false)
        {
            System.out.println("Product with ID: " + inputID + " could not be found.");
        }
    }
    
    /**
     * Checks the stock list and prints out products that are currently low on stock (input amount)
     */
    public void checkStockLevels(int inputValue)
    {
        if(inputValue > 0)
        {
            for(Product product : stock)
            {
                if(product.quantity <= inputValue)
                {
                    System.out.println("You are running low on ID: " + product.id + ", " + product.name + ". There are currently " + product.quantity + " remaning.");
                    product.toString();
                    System.out.println("");
                }
            }
        }
        if(inputValue <= 0)
        {
            System.out.println("You have entered an invalid number. Please enter a number above zero");
        }
    }
    
    /**
     * Simulates accepting a delivery for a particular product of a given amount based on ID
     */
    public void acceptDelivery(int inputID, int deliveryAmount)
    {
        boolean testID = idChecker(inputID);
        if(testID = true && deliveryAmount > 0)
        {
            for(Product product : stock)
            {
                if(product.id == inputID)
                {
                    System.out.println(deliveryAmount + " of product ID: " + inputID + " have been added.");
                    product.quantity = product.quantity + deliveryAmount;
                    break;
                }
            }
        }
        if(testID = false)
        {
            System.out.println("Product with ID: " + inputID + " could not be found.");
        }
        if(deliveryAmount <= 0)
        {
            System.out.println("You have entered an invalid amount to deliver. Please enter a positive number");
        }
    }
    
    /**
     * Simulates the sale of a product of a particular product of a given amount based on ID
     */
    public void sellProduct(int inputID, int sellAmount)
    {
        boolean testID = idChecker(inputID);
        if(testID = true && sellAmount > 0)
        {
            for(Product product : stock)
            {
                if(product.id == inputID)
                {
                    if(product.quantity - sellAmount < 0)
                    {
                        System.out.println("You are trying to sell more " + product.name + " than are left in stock. There are " + product.quantity + " remaining.");
                    }
                    if(product.quantity - sellAmount > 0)
                    {
                        System.out.println(sellAmount + " of product ID: " + inputID + " have been sold.");
                        product.quantity = product.quantity - sellAmount;
                    }
                    break;
                }
            }
        }
        if(testID = false)
        {
           System.out.println("Product with ID: " + inputID + " could not be found."); 
        }
        if(sellAmount < 0)
        {
            System.out.println("Please enter a valid amount to sell.");
        }
    }
    
    /**
     * Restock products that are low, user inputs the inputValue which is the bar for what is considered low in stock
     * they then inputs an increaseValue which sets the low stock item's quantities to this value
     */
    public void restockLowProduct(int inputValue, int increaseValue)
    {
        if(inputValue > 0 && increaseValue > 0)
        {
            for(Product product : stock)
            {
                if(product.quantity < inputValue)
                {
                    System.out.println("Product with ID: " + product.id + " has been restocked to " + increaseValue + ".");
                    product.quantity = increaseValue;
                }
            }
        }
        if(inputValue <= 0)
        {
            System.out.println("You have entered an invalid number. Please enter a number above zero.");
        }
        if(increaseValue <= 0)
        {
            System.out.println("You have enterned an invalid increase amount. Please enter a number above zero.");
        }
    }
    
    /**
     * Find a product or multiple products in the stock list based on 
     * a part of their name
     */
    public void printPartialProductName(String inputName)
    {
        System.out.println("Products with names matching '" + inputName + "'.");
        
        for(Product product : stock)
        {
            if(product.name.contains(inputName))
            {
                System.out.println(product.toString());
            }
        }
    }
    
    /**
     * Print the stock list
     */
    public void printStockList()
    {
        System.out.println("       Lily's stock list       ");
        System.out.println("ID" + " | " + "Product Name" + " | " + "Quantity");
        System.out.println("------------------------");
        
        for(Product product : stock)
        {
            System.out.println(product.toString());
        }
    }
}
