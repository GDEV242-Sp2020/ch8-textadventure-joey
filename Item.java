
/**
 * Write a description of class Item here.
 *Tom O'Rourke
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    private String name;
    private String description;
    private int weight;
    
    public Item (String nameOf, String descriptionOf, int weightOf)
    {
        name = nameOf;
        description = descriptionOf;
        weight = weightOf;
        
    }
    
    public void nameItem(String newName)
    {
        name = newName;
    }
    
     public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getWeight() {
        return weight;
    }
}
    
