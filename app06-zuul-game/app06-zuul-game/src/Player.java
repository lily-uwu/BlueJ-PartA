import java.util.ArrayList;

/**
 * This class represents the player and contains the players inventory
 */
public class Player
{
    private int energy;
    private Items item;
    private ArrayList<Items> playerInv;

    public Player(int energy)
    {
        this.energy = energy;
        playerInv = new ArrayList<Items>();
    }

    public int getEnergy()
    {
        return energy;
    }

    public void printInv()
    {
        for(Items item : playerInv)
        {
            System.out.println(item.getNameDescription());
        }
    }
}
