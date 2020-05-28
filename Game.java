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
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        // create the rooms
        
        //Outside/exterior rooms
        outsideEntry = new Room("outside the main entrance of the academy");
        tavernExterior = new Room("outside of a local tavern, there is a sign" +
        " that says Moe's Tavern");
        
        //Tavern rooms
        tavernInterior = new Room("in Moe's Tavern, you see a few patron and" +
        " a not-so-good-looking bartender. There is a door to the back");
        backroom = new Room("now in the backroom, it is dark, very dark." +
        " Suddenly you find a knife to your throat");
        
        //Breakpoint Academy Lvl 1
        entryway = new Room("in the entrance");
        LeveloneNorthHallway = new Room("now going down a hall, you spot a"+
        " door on your West and a door on your East. You also spot a" +
        " stairway going up");
        LeveloneEastHallway = new Room("now going down a hall, you"+
        " only see lockers and a door far down there");
        LeveloneWestHallway = new Room("now going down a hall, you see two" +
        " doors, one at the end and one going north");
        
        //North Hall Level 1
        classroomSci = new Room("in a science classroom, you see beakers" +
        " and test tubes around");
        classroomMath = new Room("in a math classroom, there are fractions," +
        " decimals, even calculus written on the boards");
        
        //East Hall Level 1
        broomCloset = new Room ("in a broom closet, there is only toilet" +
        " paper and another door");
        
        //West Hall Level 1
        classroomEng = new Room ("in a nice and simple classroom, having" +
        " many books and writing utensils. It must be an English classroom");
        classroomHist = new Room ("in a classroom with many maps, history pamphlets" + 
        " laminated and tapped on the wall");
        
        //Breakpoint Academy Lvl 2
        LeveltwoEntryway = new Room( "on the second floor." +
        " In front of you was a set of gym doors as well" +
        " as two halls to go to the other side, as well as" +
        " the stairs behind you");
        
        //Gym
        gymArena = new Room("in a mix between a gym and an" +
        " arena. There are many students in the middle of it." +
        " They were surrounding white tables with many Nervo Inc." +
        " Break Belts™. These transformation devices allow for students" +
        "and registered basic soldiers to dawn Breakpoint Nano-Energy" +
        " Armor. They are pretty basic");
        
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
        

        currentRoom = outsideEntry;  // start game outside
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
        while (! finished) {
            RoomCheck();
            playerDeath();
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

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
        System.out.println("the Break Belt System and train to become a new soldier.");
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
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
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

    private void pickUp(String item)
    {
        if (item == null){
            System.out.println("You try to pick up something that doesn't" +
            " exist, you look like a dunce.");
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
            " exist, you look like a dunce.");
        }
    }
    
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
    
    private void letsLook()
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    private void dotheDab()
    {
        System.out.println("You dabbed, aren't you disappointing.");
    }
    
    private void RoomCheck()
    {
        if (currentRoom == backroom){
            player.healthDecrease(100);
        }
        if (currentRoom == LeveloneEastHallway){
            for (Item item : player.getInventory()){
                if (item.getName().equals("Key")){
                    LeveloneEastHallway.setExit("east", broomCloset);
                    System.out.println("You used the key to unlock the broom closet.");
                    
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
