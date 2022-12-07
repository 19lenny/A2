abstract class Item implements I_Expireable {

    /*to answer the question in step 7:

    "Abstract classes cannot be instantiated, i.e., it is not possible to make objects from abstract classes.
    Abstract classes should be extended by other non-abstract classes (by inheritance). A typical example is a number of
    subclasses that all contain a set of identical methods and/or fields. These can be placed in the abstract superclass."
     */

    //field variables for name and price
    private String name;
    private double price;

    //constructor for name and price
    //since this class is now abstract it cannot be initialized over this constructor.
    //This is what we wanted
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //getter for the field variables
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //we override with this method the method in the interface.
    //either we have to do it here, or in every class that extends in the item class
    //for design choices it is better to do it here
    //we have the possibility in the subordinate classes to override this method again
    @Override
    public boolean isExpired() {
        //first choice is to throw an error when this method is called, because not all Items have the expiration date
        throw new UnsupportedOperationException("Item does not support this operation.");
    }
}
