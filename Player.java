import java.util.ArrayList;
/**
 * This class is for the player. The player is essentially an entity that
 * moves around the place, your controller. Here there is an inventory and a
 * health system
 *
 * @author Joey McGuane
 * @version 2020.05.28
 */
public class Player
{
    private ArrayList<Item> inventory;
    private int hP;
    
    /**
     * Registers an inventory with an array to hold items and houses the
     * base amount of health points.
     */
    public Player()
    {
        inventory = new ArrayList();
        hP = 100;
    }
    
    /**
     * Allows for items to be added into the inventory.
     */
    
    public void addItem(Item newItem)
    {
        inventory.add(newItem);
    }
    
    /**
     * Creates the inventory.
     */
    
     public ArrayList<Item> getInventory()
    {
        return inventory;
    }
    
    /**
     * Allows for health to decrease.
     */
    
    public void healthDecrease(int hP)
    {
        this.hP -= hP;
    }
    
    /**
     * Returns the current amount of health points.
     */
    
    public int getHealth()
    {
        return hP;
    }
}
