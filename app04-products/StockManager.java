import java.util.ArrayList;

/**
 * Simulates a stock management system where a user can add new products to their stock list
 * and make changes to these products such as quantity, name etc.
 * 
 * @author Lily Mccullough
 * @version 03/11/2020
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
     * Add a product to the stock list
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Remove a product object from the stock list based on ID.
     */
    public void removeProduct(int inputID)
    {
        for(Product product : stock)
        {
            if(product.id == inputID)
            {
                stock.remove(product);
                break;
            }
            
            if(product.id != inputID)
            {
                System.out.println("Product with ID " + inputID + " could not be found in the stock list.");
            }
        }
    }
    
    /**
     * Simulates accepting a delivery for a particular product of a given amount based on ID
     */
    public void acceptDelivery(int inputID, int deliveryAmount)
    {
        for(Product product : stock)
        {
            if(product.id == inputID)
            {
                product.quantity = product.quantity + deliveryAmount;
            }
            
            if(product.id != inputID)
            {
                System.out.println("Product with ID " + inputID + " could not be found in the stock list.");
            }
        }
    }
    
    /**
     * Simulates the sale of a product of a particular product of a given amount based on ID
     */
    public void sellProduct(int inputID, int sellAmount)
    {
        for(Product product : stock)
        {
            if(product.id == inputID)
            {
                if(product.quantity - sellAmount < 0)
                {
                    System.out.println("You are trying to sell more products than are left in stock.");
                }
                
                if(product.quantity - sellAmount > 0)
                {
                    product.quantity = product.quantity - sellAmount;
                }
            }
            
            if(product.id != inputID)
            {
                System.out.println("Product with ID " + inputID + " could not be found in the stock list.");
            }
        }
    }
    
    /**
     * Rename a product in the stock list based on ID.
     */
    public void renameProduct(int inputID, String replacementName)
    {
        for(Product product : stock)
        {
            if(product.id == inputID)
            {
                product.name = replacementName;
            }
            
            if(product.id != inputID)
            {
                System.out.println("Product with ID " + inputID + " could not be found int he stock list.");
            }
        }
    }
    
    /**
     * Find a product in the stock list and print that product's details
     */
    public void findProduct(int inputID)
    {
        if(product.id == inputID)
        {
            System.out.println("ID" + " | " + "Product" + " | " + "Quantity");
            System.out.println("------------------------");
            System.out.println(product.toString());
        }
        
        if(product.id != inputID)
        {
            System.out.println("Product with ID " + inputID + " could not be found in the stock list.");
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
        System.out.println("ID" + " | " + "Product Name" + " | " + "Quantity");
        System.out.println("------------------------");
        
        for(Product product : stock)
        {
            System.out.println(product.toString());
        }
    }
}
