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
                System.out.println("Product with ID " + inputID + "could not be found in the stock list");
            }
        }
    }
    
}
