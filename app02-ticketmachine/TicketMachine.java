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
    * Return the price of a ticket.
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
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
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
        if(balance >= cost) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + cost + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + cost;
            // Reduce the balance by the price.
            balance = balance - cost;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (cost - balance) + " more cents.");
                    
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
