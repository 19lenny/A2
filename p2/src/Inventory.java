import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<Item>();

    public Inventory() {
        //do I need this one
        //TODO: check in the end
    }

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
    public double getInventoryValue(){
    //The size() method returns an integer equal to a number of elements present in the array list
        double sum = 0.0;
        for (int i=0; i<this.items.size(); i++){
            sum = sum + items.get(i).getPrice();
        }
        return sum;
    }

    public void printInventory(){
        //The size() method returns an integer equal to a number of elements present in the array list
        for (int i=0; i<this.items.size(); i++){
            //get current item out of the items list and print it in the according method (to String)
            System.out.println(items.get(i).toString());
        }
    }
}
