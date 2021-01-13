import java.util.ArrayList;

/**
 * This class represents the player and contains the players inventory
 */
public class Player
{
    private int energy;
    private Items item;
    private ArrayList<Items> playerInventory;

    /**
     * Creates a player with energy and an inventory
     * @param energy player's energy - reduced by moving room to room
     */
    public Player(int energy)
    {
        this.energy = energy;
        playerInventory = new ArrayList<Items>();
    }

    /**
     * @return player's current energy
     */
    public int getEnergy()
    {
        return energy;
    }

    /**
     * adds an item to the player's inventory.
     * @param item the item that will be added
     */
    public void addItemToInv(Items item)
    {
        playerInventory.add(item);
    }

    /**
     * removes an item from the player's inventory.
     * @param item the item that will be removed
     */
    public void removeItemFromInv(Items item)
    {
        playerInventory.remove(item);
    }

    /**
     * Prints all of the items in the players inventory
     */
    public void printInv()
    {
        for(Items item : playerInventory)
        {
            System.out.println(item.getNameDescription());
        }
    }

    public boolean hasItem(String itemName)
    {
        boolean output = false;

        for(int i = 0; i < playerInventory.size(); i++)
        {
            if(playerInventory.get(i).getName().equals(itemName))
            {
                output = true;
            }
        }
        return output;
    }
}
