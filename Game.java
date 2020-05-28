
/**
 *  This class is the main class to run the "Breakpoint Academy" text-based
 *  game. The game allows you to wander around, collect items, do small actions
 *  and more. It contains one death screen and some little easter eggs here or
 *  there. 
 * 
 * @author Joey McGuane
 * @version 2020.05.28
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private Room outsideEntry, entryway, tavernExterior, tavernInterior,backroom,
        LeveloneNorthHallway,classroomSci,classroomMath,LeveloneEastHallway,broomCloset,LeveloneWestHallway,classroomEng,classroomHist,
        LeveltwoEntryway, gymArena;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();
    }

    /**
     * Create all the rooms and link their exits together as well
     * as place items in each room that are desired to have them.
     */
    private void createRooms()
    {
        // create the rooms
        
        //Outside/exterior rooms
        outsideEntry = new Room("outside the main entrance of the academy");
        tavernExterior = new Room("outside of a local tavern, there is a sign" +
        "\n that says Moe's Tavern");
        
        //Tavern rooms, backroom is oneway trapdoor
        tavernInterior = new Room("in Moe's Tavern, you see a few patron and" +
        "\n a not-so-good-looking bartender. There is a door to the back." +
        "\n the bartender has a drink out, saying 'It is on the house.'" +
        "\n He says 'Don't go to the backroom.'");
        backroom = new Room("now in the backroom, it is dark, very dark." +
        "\n Suddenly you find a knife to your throat. You hear the" +
        "\n bartender say 'I told you' before you feel the knife glide" +
        "\n through your neck, you collapse");
        
        //Breakpoint Academy Lvl 1
        entryway = new Room("in the entrance");
        LeveloneNorthHallway = new Room("now going down a hall, you spot a"+
        "\n door on your West and a door on your East. You also spot a" +
        "\n stairway going up");
        LeveloneEastHallway = new Room("now going down a hall, you"+
        "\n only see lockers and a door far down there");
        LeveloneWestHallway = new Room("now going down a hall, you see two" +
        "\n doors, one at the end and one going north");
        
        //North Hall Level 1
        classroomSci = new Room("in a science classroom, you see beakers" +
        "\n and test tubes around");
        classroomMath = new Room("in a math classroom, there are fractions," +
        "\n decimals, even calculus written on the boards");
        
        //East Hall Level 1
        broomCloset = new Room ("in a broom closet, there is only toilet" +
        "\n paper and another door");
        
        //West Hall Level 1
        classroomEng = new Room ("in a nice and simple classroom, having" +
        "\n many books and writing utensils. It must be an English classroom");
        classroomHist = new Room ("in a classroom with many maps, history pamphlets" + 
        "\n laminated and tapped on the wall");
        
        //Breakpoint Academy Lvl 2
        LeveltwoEntryway = new Room( "on the second floor." +
        "\n In front of you was a set of gym doors as well" +
        "\n as two halls to go to the other side, as well as" +
        "\n the stairs behind you");
        
        //Gym
        gymArena = new Room("in a mix between a gym and an" +
        "\n arena. There are many students in the middle of it." +
        "\n They were surrounding white tables with many Nervo Inc." +
        "\n Break Belts™. These transformation devices allow for students" +
        "\n and registered basic soldiers to dawn Breakpoint Nano-Energy" +
        "\n Armor. They are pretty basic");
        
        // initialise room exits
        outsideEntry.setExit("north", entryway);
        outsideEntry.setExit("east", tavernExterior);
        
        tavernExterior.setExit("west", outsideEntry);
        tavernExterior.setExit("north", tavernInterior);
        
        tavernInterior.setExit("south", tavernExterior);
        tavernInterior.setExit("north", backroom);
        tavernInterior.addItem(new Item("Beer", "A pint of fresh beer", 1));
        
        entryway.setExit("south",outsideEntry);
        entryway.setExit("north", LeveloneNorthHallway);
        entryway.setExit("east", LeveloneEastHallway);
        entryway.setExit("west", LeveloneWestHallway);
        
        LeveloneNorthHallway.setExit("north", LeveltwoEntryway);
        LeveloneNorthHallway.setExit("west", classroomSci);
        LeveloneNorthHallway.setExit("east", classroomMath);
        LeveloneNorthHallway.setExit("south", entryway);
        
        classroomSci.setExit("east", LeveloneNorthHallway);
        classroomSci.addItem(new Item("Key", "a small key that has an E on it", 1));
        
        classroomMath.setExit("west", LeveloneNorthHallway);
        
        //LeveloneEastHallway.setExit("east", broomCloset);
        
        
       LeveloneEastHallway.setExit("west", entryway);
        
        broomCloset.setExit("east", broomCloset);
        broomCloset.setExit("west", LeveloneEastHallway);
        
        LeveloneWestHallway.setExit("north", classroomEng);
        LeveloneWestHallway.setExit("west", classroomHist);
        LeveloneWestHallway.setExit("east", entryway);
        
        classroomEng.setExit("south",LeveloneWestHallway);
        
        classroomHist.setExit("east",LeveloneWestHallway);
        
        LeveltwoEntryway.setExit("north", LeveloneNorthHallway);
        LeveltwoEntryway.setExit("south", gymArena);
        
        gymArena.setExit("north",LeveltwoEntryway);
        gymArena.addItem(new Item("BreakBelt", "A silver and bulky device." + 
        "\n It looks to have a circular lightbulb-like piece in the center." +
        "\n On the belt buckle, there seems to be a piece sticking out," +
        "\n a slot within the piece, waiting for the power source.", 3));
        gymArena.addItem(new Item("PointCore", "A small, cylindrical object." +
        "\n It has a glowing blue energy within, on the case it says" +
        "\n 'Defending Soldier', one of the three basic Point Core types." +
        "\n It looks like it could fit in a Break Belt easily.", 1));

        currentRoom = outsideEntry;  // start game outside
    }

    /**
     *  Main play routine. Loops until end of play.
     *  Also relays the death screen, but does not end until
     *  "quit" is put, but also doesn't let you leave.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            RoomCheck();
            playerDeath();
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**
     * Gives a literal death screen if the player health is too low.
     */
    
    private void playerDeath()
    {
        if (player.getHealth() <= 0){
            System.out.println("You have died, please type quit to end game");
        }
    }
    
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Breakpoint Academy!");
        System.out.println("Here you will be able to explore the wonders of");
        System.out.println("the Break Belt System and train to" +
        "\n become a new Breakpoint soldier.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println("Your command words are:");
        parser.showCommands();
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

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case LOOK:
                if (command.hasSecondWord()){
                    lookObject(command.getSecondWord());
                }
                else{
                    letsLook();
                }
                break;
                
            case DAB:
                dotheDab();
                break;
                
            case QUIT:
                wantToQuit = quit(command);
                break;
            
            case PICK:
                pickUp(command.getSecondWord());
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
        System.out.println("You arrive. You are alone. You wander");
        System.out.println("around at the academy.");
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
        if(!command.hasSecondWord()) {
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
     * Allows for the player to pick up an item that's in the room.
     * They store the item in their inventory. This also prevents
     * players from gaining items outside the room and when there are no
     * items or the specified item is not there or is taken, it gives
     * the text below.
     */
    
    private void pickUp(String item)
    {
        if (item == null){
            System.out.println("You try to pick up something that doesn't" +
            "\n exist, you look like a dunce.");
        }
        else {
            for (Item object : currentRoom.getItems()){
                if (object.getName().equals(item)){
                    player.addItem(currentRoom.removeItem(item));
                    System.out.println("You got a " + item + ".");
                    return;
                }
            }
            System.out.println("You try to pick up something that doesn't" +
            "\n exist, you look like a dunce.");
        }
    }
    
    /**
     * Uses the "look" command when in conjunction with an item
     * name as a second object gives the item's description.
     * If "look room" is typed, it simply gives the description
     * of the room. This is merely a precaution if the player
     * believes they must put room to check around the room.
     */
    
    private void lookObject(String object)
    {
        if (object.equals("room")){
            System.out.println(currentRoom.getLongDescription());
            return;
        }
        for (Item item : currentRoom.getItems()){
            if (item.getName().equals(object)){
                System.out.println(item.getDescription());
                return;
            }
        }
        for (Item item : player.getInventory()){
            if (item.getName().equals(object)){
                System.out.println(item.getDescription() + " in your inventory.");
                return;
            }
        }
    }
    
    /**
     * Gives the description of the room.
     */
    
    private void letsLook()
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    
    /**
     * A simple text response, mainly for memes.
     */
    
    private void dotheDab()
    {
        System.out.println("You dabbed, aren't you disappointing.");
    }
    
    /**
     * Checks the current room for certain instances and items.
     * If the player goes into the backroom at Moe's, he dies.
     * If the player has the "Key" item in their inventory,
     * they gain access to the locked broom closet room.
     */
    
    private void RoomCheck()
    {
        if (currentRoom == backroom){
            player.healthDecrease(100);
        }
        if (currentRoom == LeveloneEastHallway){
            for (Item item : player.getInventory()){
                if (item.getName().equals("Key")){
                    LeveloneEastHallway.setExit("east", broomCloset);
                    System.out.println("You used the key to unlock" +
                    "\n the broom closet.");
                    
                }
            }
        }
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
