import java.util.ArrayList;

public class Inventory {
    //field variable to store the items in the inventory
    private ArrayList<Item> items = new ArrayList<Item>();

    //constructor only needed to create an object
    //@Magnus Værbak, does every class really need a constructor?
    //Because if I delete this line I am still able to create an Inventory object.
    //Is it a security issue to have a constructor when none is needed?
    public Inventory(){}

    public void addItem(Item item){
        //this method adds an item at the end of the ArrayList
        //it saves directly the object in the list
        this.items.add(item);
    }
    public void removeItem(Item item){
        //this method removes the item if it is in the list
        //if it is not in the list, nothing happens
        this.items.remove(item);
    }

    //this method calculates the current value of the inventory
    public double getInventoryValue(){
    //The size() method returns an integer equal to a number of elements present in the array list
        double sum = 0.0;
        for (int i=0; i<this.items.size(); i++){
            sum = sum + items.get(i).getPrice();
        }
        return sum;
    }

    //print what's in the inventory
    public void printInventory(){
        //The size() method returns an integer equal to a number of elements present in the array list
        for (int i=0; i<this.items.size(); i++){
            //get current item out of the items list and print it in the according method (to String)
            //directly print it here
            System.out.println(items.get(i).toString());
        }
    }

    //this method is returning all the items in the inventory.
    //It is only used to check if remove Items is working smoothly
    public ArrayList<Item> getItems(){
        return items;
    }
}
