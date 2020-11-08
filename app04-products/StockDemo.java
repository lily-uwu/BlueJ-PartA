/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo()
    {
        manager = new StockManager();
        manager.addProduct(new Product(100, "Fishhh"));
        manager.addProduct(new Product(101, "Burgers"));
        manager.addProduct(new Product(102, "Fishcakes"));
        manager.addProduct(new Product(103, "Bubble Tea"));
        manager.addProduct(new Product(104, "Bread"));
        manager.addProduct(new Product(105, "Bakewells"));
        manager.addProduct(new Product(106, "Oraaange"));
        manager.addProduct(new Product(107, "Milk"));
        manager.addProduct(new Product(108, "Panccakes"));
        manager.addProduct(new Product(109, "Milkshake"));
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void demo()
    {
        System.out.println("");
        // Prints the list of products and their details
        System.out.println("manager.printStockList();");
        System.out.println("");
        manager.printStockList();
        System.out.println("");
        // Accepting delivery of various quantities to multiple products
        System.out.println("manager.acceptDelivery(100, 5)");
        System.out.println("manager.acceptDelivery(101, 3)");
        System.out.println("manager.acceptDelivery(102, 34)");
        System.out.println("manager.acceptDelivery(103, 65)");
        System.out.println("manager.acceptDelivery(104, 75)");
        System.out.println("manager.acceptDelivery(105, 190)");
        System.out.println("manager.acceptDelivery(106, 9)");
        System.out.println("manager.acceptDelivery(107, 10)");
        System.out.println("manager.acceptDelivery(108, 53)");
        System.out.println("manager.acceptDelivery(109, 154)");
        System.out.println("");
        manager.acceptDelivery(100, 5);
        manager.acceptDelivery(101, 3);
        manager.acceptDelivery(102, 34);
        manager.acceptDelivery(103, 65);
        manager.acceptDelivery(104, 75);
        manager.acceptDelivery(105, 190);
        manager.acceptDelivery(106, 9);
        manager.acceptDelivery(107, 10);
        manager.acceptDelivery(108, 53);
        manager.acceptDelivery(109, 154);
        System.out.println("");
        // Print method to prove delivery 
        System.out.println("manager.printStockList();");
        System.out.println("");
        manager.printStockList();
        System.out.println("");
        // Sells various quantities of some products
        System.out.println("manager.sellProduct(100, 10)");
        System.out.println("manager.sellProduct(101, 2)");
        System.out.println("manager.sellProduct(102, 34)");
        System.out.println("manager.sellProduct(103, 66)");
        System.out.println("manager.sellProduct(104, 56)");
        System.out.println("manager.sellProduct(105, 145)");
        System.out.println("manager.sellProduct(106, 8)");
        System.out.println("manager.sellProduct(107, 25)");
        System.out.println("manager.sellProduct(108, 46)");
        System.out.println("manager.sellProduct(109, 79)");
        System.out.println("");
        manager.sellProduct(100, 10);
        manager.sellProduct(101, 2);
        manager.sellProduct(102, 34);
        manager.sellProduct(103, 66);
        manager.sellProduct(104, 56);
        manager.sellProduct(105, 145);
        manager.sellProduct(106, 8);
        manager.sellProduct(107, 25);
        manager.sellProduct(108, 46);
        manager.sellProduct(109, 79);
        System.out.println("");
        // Print method to prove sale of products
        System.out.println("manager.printStockList();");
        System.out.println("");
        manager.printStockList();
        System.out.println("");
        // Rename a few products
        System.out.println("manager.renameProduct(100, 'Fish');");
        System.out.println("manager.renameProduct(106, 'Oranges');");
        System.out.println("manager.renameProduct(108, 'Pancakes');");
        manager.renameProduct(100, "Fish");
        manager.renameProduct(106, "Oranges");
        manager.renameProduct(108, "Pancakes");
        System.out.println("");
        // Print method to prove name changes
        System.out.println("manager.printStockList();");
        System.out.println("");
        manager.printStockList();
        System.out.println("");
        // Remove a product based on ID
        System.out.println("manager.removeProduct(109);");
        System.out.println("");
        manager.removeProduct(109);
        // Print method to prove removal of product
        System.out.println("manager.printStockList();");
        System.out.println("");
        manager.printStockList();
        System.out.println("");
        // Printing a list of products low on stock
        System.out.println("manager.checkStockLevels();");
        System.out.println("");
        manager.checkStockLevels();
        System.out.println("");
        // Printing products based on a part of their name
        System.out.println("manager.printPartialProductName('B');");
        System.out.println("");
        manager.printPartialProductName("B");
        System.out.println("");
    }
    
    /**
     * Returns the stock manager
     */
    public StockManager getManager()
    {
        return manager;
    }
}
