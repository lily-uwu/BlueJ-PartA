import java.util.ArrayList;

/**
 * This class represents the player and contains the players inventory
 */
public class Player
{
    private int energy;
    private Items item;
    private ArrayList<Items> playerInv;

    /**
     * Creates a player with energy and an inventory
     * @param energy player's energy - reduced by moving room to room
     */
    public Player(int energy)
    {
        this.energy = energy;
        playerInv = new ArrayList<Items>();
    }

    /**
     * @return player's current energy
     */
    public int getEnergy()
    {
        return energy;
    }

    /**
     * Prints all of the items in the players inventory
     */
    public void printInv()
    {
        for(Items item : playerInv)
        {
            System.out.println(item.getNameDescription());
        }
    }
}
