import java.util.ArrayList;

/**
 * This class represents the player and contains the players inventory
 */
public class Player
{
    private int energy;
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
}
