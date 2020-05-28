import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private ArrayList<Item> inventory;
    
    public Player()
    {
        inventory = new ArrayList();
    }
    
    public void addItem(Item newItem)
    {
        inventory.add(newItem);
    }
}
