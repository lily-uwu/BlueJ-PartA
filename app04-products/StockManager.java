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
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }
}
