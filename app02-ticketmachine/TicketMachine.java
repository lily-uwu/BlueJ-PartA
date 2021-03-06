/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Lily Mccullough
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int cost;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //
    private Ticket ticket;
    // The chosen ticket
    private Ticket chosenTicket;
    
    // Assigning ticket constants for the 3 pre-set destinations
    public static final Ticket AYLESBURY_TICKET = new Ticket("Aylesbury", 220);
    public static final Ticket AMERSHAM_TICKET = new Ticket("Amersham", 300);
    public static final Ticket HIGHWYCOMBE_TICKET = new Ticket("High Wycombe", 330);

    /**
    * Create a machine that issues tickets.
    */
    public TicketMachine()
    {
        balance = 0;
        total = 0;
        chosenTicket = null;
    }

    /**
    * Return the price of chosen ticket.
    */
    public int getCost()
    {
        return chosenTicket.cost;
    }

    /**
    * Return The amount of money already inserted for the
    * next ticket.
    */
    public int getBalance()
    {
        return balance;
    }
    
    /**
    * Allows the user to insert a 10 pence coin.
    */
    public void insert10Coin()
    {
        balance = balance + 10;
        System.out.println("You have inserted 10 pence. The current balance is: " + balance);
    }
    
    /**
    * Allows the user to insert a 20 pence coin.
    */
        public void insert20Coin()
    {
        balance = balance + 20;
        System.out.println("You have inserted 20 pence. The current balance is: " + balance);
    }
    
    /**
    * Allows the user to insert a 100 pence coin.
    */
        public void insert100Coin()
    {
        balance = balance + 100;
        System.out.println("You have inserted 100 pence. The current balance is: " + balance);
    }
    
    /**
    * Allows the user to insert a 200 pence coin.
    */
        public void insert200Coin()
    {
        balance = balance + 200;
        System.out.println("You have inserted 200 pence. The current balance is: " + balance);
    }
    
    /**
    * Allows the user to choose the Aylesbury Ticket
    */
    public void chooseAylesburyTicket()
    {
        chosenTicket = AYLESBURY_TICKET;
    }
    
    /**
    * Allows the user to choose the Amersham Ticket
    */
    public void chooseAmershamTicket()
    {
        chosenTicket = AMERSHAM_TICKET;
    }
    
    /**
    * Allows the user to choose the High Wycombe Ticket
    */
    public void chooseHighwycombeTicket()
    {
        chosenTicket = HIGHWYCOMBE_TICKET;
    }
    
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= chosenTicket.cost) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# " + chosenTicket.destination + " Ticket");
            System.out.println("# " + chosenTicket.cost + " pence.");
            System.out.println("# " + chosenTicket.getDateTime);
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + chosenTicket.cost;
            // Reduce the balance by the price.
            balance = balance - chosenTicket.cost;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (chosenTicket.cost - balance) + " more pence.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
