import java.text.DecimalFormat;
import java.util.Date;

public class FoodItem extends Item {
    //create private Date variable for the expiration Date
    private Date expires;

    //constructor is open for three input variables(name of the product, price of the product, expiration date of the product)
    public FoodItem(String name, double price, Date expiration)
    {

        // Call the superclass constructor to
        // initialize name and price.
        super(name, price);

        // Initialize expiration.
        this.expires = expiration;
    }

    //create method which overrides to string, such when we print the item, we don't get a reference, but the actual item
    @Override
    public String toString(){
        //get name, price and expiration date
        String name = getName();
        Double price = getPrice();
        Date expiration = getExpires();
        //create a pattern for the printing of the price. Normally prices are visualized in two decimal format
        DecimalFormat df = new DecimalFormat("0.00");
        //create the return of the item
        return "item: "+name +" | price: "+df.format(price)+" DKK  | expiration date: "+expiration;
    }

    public Date getExpires() {
        return expires;
    }
}
