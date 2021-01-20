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
    private Items key, largeSack, energyDrink, keycard, painting, toolbag, jewel, phone, computer, coat;
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
        System.out.println("Your final score was: " + player.getScore() + ", thank you for playing.  Good bye.");
    }

    /**
     * method to initialise the player
     */
    private void createPlayer()
    {
        player = new Player(40, 70);
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
        keyRoom.addItemToRoom(largeSack);
        keyRoom.addItemToRoom(energyDrink);
        keyRoom.addItemToRoom(keycard);
        keyRoom.addItemToRoom(painting);
        keyRoom.addItemToRoom(toolbag);
        keyRoom.addItemToRoom(jewel);
        keyRoom.addItemToRoom(phone);
        keyRoom.addItemToRoom(computer);
        keyRoom.addItemToRoom(coat);
    }

    /**
     * Initialises game items
     */
    private void createItems()
    {
        key = new Items("Key", "This key must open a door somewhere...", 1, 5);
        largeSack = new Items("Sack", "A large sack that could hold a lot.", 0, 0);
        energyDrink = new Items("Drink", "An energy drink! Time to get that juice!", 2, 0);
        keycard = new Items("Keycard", "This keycard must give me access to somewhere...", 1, 5);
        painting = new Items("Painting", "A painting of a famous face.", 30, 300);
        toolbag = new Items("Toolbag", "A bag of tools.", 20,15);
        jewel = new Items("Jewel", "A large expensive jewel!", 25, 500);
        phone = new Items("Phone", "A smartphone.", 1, 65);
        computer = new Items("Computer", "Just a computer...", 25, 100);
        coat = new Items("Coat", "An expensive, fancy coat.", 3, 10);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("You are a thief who has broken into an expensive shop!");
        System.out.println("Find as many valuable items as you can and escape!");
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
                break;

            case GET:
                getItem(command);
                break;

            case DROP:
                dropItem(command);
                break;

            case INVENTORY:
                getInventory();
                break;

            case LOOK:
                lookCommand();
                break;

            case USE:
                useItem(command);
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
     * allows the user to use certain items
     * @param command
     */
    private void useItem(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("Use what?");
            return;
        }

        String itemString = command.getSecondWord();

        if(command.hasSecondWord() && player.hasItem(itemString))
        {
            if(itemString.equalsIgnoreCase("Drink"))
            {
                player.removeItemFromInv(player.getItem(itemString));
                player.setEnergy(50);
            }
            if(itemString.equalsIgnoreCase("Sack"))
            {
                player.removeItemFromInv(player.getItem(itemString));
                player.setMaxWeight(30);
            }
            else
            {
                System.out.println("This item is unusable...");
            }
        }
        else
        {
            System.out.println("You don't have this item...");
        }
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
            player.setEnergy(-1);
            System.out.println("Energy: " + player.getEnergy());
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
        }
        else
        {
            System.out.println("Item not found...");
        }
    }

    /**
     * command for player to look around active room for items
     */
    private void lookCommand()
    {
        currentRoom.lookAround();
    }

    /**
     * command to let the player escape and finish the game
     */
    private boolean escape(Command command)
    {
        boolean output = false;

        // is the player's room the front exit
        if(currentRoom == frontExit)
        {
            // if player is under energy threshold for escape
            if(player.getEnergy() < 20)
            {
                System.out.println("You don't have enough energy to run away!");
                output = false;
            }
            // if player meets energy threshold for escape
            if(player.getEnergy() >= 20)
            {
                System.out.println("You ran away before the police could catch you!");
                output = true;
            }

        }
        // is the player's room the rope exit
        if(currentRoom == ropeExit)
        {
            // if the player could meet the max weight and minimum energy threshold, they escape
            if(player.getCurrentWeight() <= player.getMaxWeight() && player.getEnergy() >= 10)
            {
                System.out.println("You were able to climb the rope and escape stealthily!");
                output = true;
            }
            // player doesn't meet energy threshold
            if(player.getCurrentWeight() <= player.getMaxWeight() && player.getEnergy() < 10)
            {
                System.out.println("You need at least 10 energy to climb this rope...");
                output = false;
            }
            // player doesn't meet max weight
            if(player.getCurrentWeight() > player.getMaxWeight() && player.getEnergy() >= 10)
            {
                System.out.println("You are carrying too much to climb this rope...");
                output = false;
            }
            // player doesn't meet energy or max weight threshold
            if(player.getCurrentWeight() > player.getMaxWeight() && player.getEnergy() < 10)
            {
                System.out.println("You are carrying too much and don't have enough energy to climb this rope...");
                output = false;
            }
        }
        // if player isn't at an exit
        else
        {
            System.out.println("You need to get to an exit...");
            output = false;
        }
        return output;
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
