import java.util.Date;
/**
 * Assigns ticket types.
 *
 * @author Lily Mccullough
 * @version 12/10/2020
 */
public class Ticket
{
    //
    private String destination;
    //
    private Date getDateTime;
    //
    private int cost;    
    /**
    * Constructor to assign values for ticket destination, price and current date/time.
    */
    public Ticket(String destination, int cost)
    {
        // initialise instance variables
        this.destination = destination;
        this.cost = cost;
        getDateTime = new Date();
    }
    /**
    * Prints the Ticket
    */
    public void printTicket()
    {
        System.out.println("Destination: " + destination);
        System.out.println("Cost: " + cost + " pence." );
        System.out.println("Date and Time: " + getDateTime);
    }
}
