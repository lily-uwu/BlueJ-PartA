/**
 * This class contains the framework for the items in the game
 */
public class Items
{
    private String name;
    private String description;
    private int weight;
    private int score;

    /**
     * Creates and item with a name and description
     * @param name the item's name
     * @param description the item's description
     */
    public Items(String name, String description, int weight, int score)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.score = score;
    }

    /**
     * returns the item weight
     * @return weight
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * @return item name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the score the item gives
     */
    public int getScore()
    {
        return score;
    }

    /**
     * @return item description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return both the name and description together
     */
    public String getNameDescription()
    {
        return name + " - " + description + " - " + weight + "kg.";
    }
}
