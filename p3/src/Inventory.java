import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<Item>();

    //basically no constructor needed
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

    //this method check every product in the inventory and deletes the ones that are overdue
    public void removeExpiredFoods(){
        for (int i = 0; i<items.size(); i++){
            //if I don't get an error, I know that it is a food item and can straight go to processing in the try phase
            //to remove the isExpired has to be true, if not the loop should continue
            try {
                if (items.get(i).isExpired()){
                    removeItem(items.get(i));
                }
                //if it is not expired, nothing should happen
                //continue keyword is unnecessary but there by purpose
                //the user know the clause is empty by purpose
                else{continue;}
            }
            //if it is an UnsupportedOperationException it is handled here
            catch (UnsupportedOperationException myException){
                //continue;
            }
        }
    }

    //this method is returning all the items in the inventory.
    //It is only used to check if remove Items is working smoothly
    public ArrayList<Item> getItems(){
        return items;
    }
}
