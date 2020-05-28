
/**
 * This class is for items. Here is where the items are registered via
 * name, description, and weight.
 *
 * @author Joey McGuane
 * @version 2020.05.28
 */
public class Item
{
    private String name;
    private String description;
    private int weight;
    
    
    /**
     * Creates the item with multiple parts: the name, the description, and
     * the weight.
     */
    
    public Item (String nameOf, String descriptionOf, int weightOf)
    {
        name = nameOf;
        description = descriptionOf;
        weight = weightOf;
        
    }
    
    /**
     * Gives an item a name.
     */
    
    public void nameItem(String newName)
    {
        name = newName;
    }
    
    /**
     * Returns the name of an item.
     */
    
     public String getName() {
        return name;
    }
    
    /**
     * Returns the description of an item.
     */
    
    public String getDescription() {
        return description;
    }
    
    /**
     * Returns the weight of an item.
     */
    
    public int getWeight() {
        return weight;
    }
}
    
