public class Item {

    //two field variables for the name and the price
    private String name;
    private double price;

    //constructor is taking name and price
    //problem: now one can create an Item object without specifying the object type
    //solution in part 3 when the item class is made abstract
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


}
