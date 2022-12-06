abstract class Item implements I_Expireable {

    /*to answer the question in step 7:

    "Abstract classes cannot be instantiated, i.e., it is not possible to make objects from abstract classes.
    Abstract classes should be extended by other non-abstract classes (by inheritance). A typical example is a number of
    subclasses that all contain a set of identical methods and/or fields. These can be placed in the abstract superclass."
     */
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean isExpired() {
        throw new UnsupportedOperationException("Item does not support this operation.");
    }
}
