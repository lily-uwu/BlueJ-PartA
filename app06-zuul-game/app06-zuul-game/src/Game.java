/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * modified by Lily Mccullough
 * 
 * Modified and extended by Derek and Andrei
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private Items key;
    private Room frontExit, ropeExit, hallway1, hallway2, gallery, computerRoom, supplyRoom, managerOffice, keyRoom, shop, safeRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        createPlayer();
        createItems();
        createRooms();
        play();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * method to initialise the player
     */
    private void createPlayer()
    {
        player = new Player(20, 70);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        // create the rooms
        frontExit = new Room("at the front exit");
        ropeExit = new Room("at the rope exit");
        hallway1 = new Room("in an empty hallway");
        hallway2 = new Room("in an empty hallway");
        gallery = new Room("in the gallery");
        computerRoom = new Room("in the computer room");
        supplyRoom = new Room("in the supply room");
        managerOffice = new Room("in the manager's office");
        keyRoom = new Room("in the key room.");
        shop = new Room("in the shop.");
        safeRoom = new Room("in a safe room. There are so many valuables here!");

        // initialise room exits
        frontExit.setExit("south", ropeExit);

        ropeExit.setExit("north", frontExit);
        ropeExit.setExit("south", gallery);
        ropeExit.setExit("east", hallway1);

        gallery.setExit("south", shop);
        gallery.setExit("east", hallway2);
        gallery.setExit("north", ropeExit);

        shop.setExit("north", gallery);
        shop.setExit("east", safeRoom);

        safeRoom.setExit("west", shop);

        hallway1.setExit("west", ropeExit);
        hallway1.setExit("east", computerRoom);

        hallway2.setExit("west", gallery);
        hallway2.setExit("east", managerOffice);

        managerOffice.setExit("west", hallway2);
        managerOffice.setExit("north", computerRoom);
        managerOffice.setExit("east", keyRoom);

        computerRoom.setExit("west", hallway1);
        computerRoom.setExit("north", supplyRoom);
        computerRoom.setExit("south", managerOffice);

        supplyRoom.setExit("south", computerRoom);

        keyRoom.setExit("west", managerOffice);

        currentRoom = ropeExit;  // start game outside

        keyRoom.addItemToRoom(key);
    }

    /**
     * Initialises game items
     */
    private void createItems()
    {
        key = new Items("Key", "This key must open a door somewhere...", 1);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord)
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            case ESCAPE:
                wantToQuit = escape(command);

            case GET:
                getItem(command);
                break;

            case DROP:
                dropItem(command);
                break;

            case INVENTORY:
                getInventory();
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You have sneaked into the ");
        System.out.println("store of valuable things!");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /**
     * command to let player get an item in a room
     * @param command
     */
    private void getItem(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("Get what?");
            return;
        }

        String itemString = command.getSecondWord();

        if(command.hasSecondWord() && currentRoom.hasItem(itemString))
        {
            player.addItemToInv(currentRoom.getItem(itemString));
            currentRoom.removeItemFromRoom(currentRoom.getItem(itemString));
            System.out.println("You have picked up " + itemString + ".");
        }
        else
        {
            System.out.println("Item not found...");
        }
    }

    /**
     * command to let player drop an item from their inventory
     * @param command
     */
    private void dropItem(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("Drop what?");
            return;
        }

        String itemString = command.getSecondWord();

        if(command.hasSecondWord() && player.hasItem(itemString))
        {
            currentRoom.addItemToRoom(player.getItem(itemString));
            player.removeItemFromInv(player.getItem(itemString));
            System.out.println("You have dropped " + itemString + ".");
        }
        else
        {
            System.out.println("Item not found...");
        }
    }

    /**
     * command to let the player escape and finish the game
     */
    private boolean escape(Command command)
    {
        if(player.hasItem("Key") && currentRoom == frontExit)
        {
            return true;
        }
        else
        {
            System.out.println("no");
            return false;
        }
    }

    /**
     * command to print the inventory of the player
     */
    private void getInventory()
    {
        player.printInv();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
