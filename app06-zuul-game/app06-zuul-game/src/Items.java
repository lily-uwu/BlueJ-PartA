/**
 * This class contains the framework for the items in the game
 */
public class Items
{
    private String name;
    private String description;

    public Items(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getNameDescription()
    {
        return name + " - " + description;
    }
}
