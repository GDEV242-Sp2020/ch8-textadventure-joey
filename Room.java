import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "Breakpoint Academy" text-based
 *  game.
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * This also allows for a room to contain multiple items, which are put
 * in the Game class under each room registered.
 * 
 * @author Joey McGuane
 * @version 2016.05.28
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }
    
    
    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room as well as if any items are
     * in the room
     */
    public String getLongDescription()
    {
        return "You are " + description + 
        ".\n" + itemString() + "\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Creates an items in the room section, displaying any item in the room.
     * This is returned to the getLongDescription method from "itemString()".
     */
    
    public String itemString()
    {
        String returnString = "Items in the room:";
        for (Item item : items){
            returnString += " " + item.getName();
        }
        return returnString;
    }
    
    /**
     * Adds an item to a particular room, used in the Game class.
     */
    
    public void addItem(Item anyItem)
    {
        if (anyItem == null){
            
        }
        else{
            items.add(anyItem);
        }
        
    }
    
    /**
     * Allows for an item to be removed from a room and placed in the
     * inventory.
     */
    
    public Item removeItem(String itemtoRemove)
    {
        Iterator<Item> i = items.iterator();
        while (i.hasNext()){
            Item tempItem = i.next();
            if (tempItem.getName().equals(itemtoRemove)){
                i.remove();
                return tempItem;
            }
        }
        return null;
    }
    
    /**
     * Gives the array list of items in the room.
     */
    
    public ArrayList<Item> getItems()
    {
        return items;
    }
    
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

