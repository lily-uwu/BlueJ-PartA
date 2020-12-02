/**
 * Class for products which acts as a template for each, they can then be added to the stock list and manipulated.
 * 
 * @author Lily Mccullough
 * @version 03/11/2020
 */
public class Product
{
    // Variable to store the ID of the product
    public int id;
    // Variable to store the name of the product
    public String name;
    // Variable to store the quantity of the product.
    public int quantity;

    /**
     * Constructor to assign initial values, where id and name are inputed, quantity is defaulted to zero
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * Returns the products ID
     */
    public int getID()
    {
        return id;
    }

    /**
     * Returns the products name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the current quantity of the product
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Returns the ID, name and quantity of the product but all as a single string
     */
    public String toString()
    {
        return id + ": " +  name + " , Amount: " + quantity;
    }
}
