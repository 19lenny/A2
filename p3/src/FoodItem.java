import java.text.DecimalFormat;
import java.util.Calendar;
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

    @Override
    public boolean isExpired() {

        //compare today to the expiration date.
        //if the expiration date > today, all good, return will be -1, so we have to convert this to boolean,
        //it is chosen to be -1, since the method is called isExpired. It's not expired --> false
        //if the expiration date = today (incl. hours, minutes and seconds), status critical, the return will be 0:
        //the possibility of this is very small. In this case we would return true,
        //since in the next second this would be the result either way
        //if the expiration date < today, the product is expired, return will be -1, this has to be translated to boolean
        //source: https://mkyong.com/java/how-to-compare-dates-in-java/

        //the current date is:
        Date today = Calendar.getInstance().getTime();

        int res = today.compareTo(expires);
        if (res<0){
            return false;
        }
        else{
            return true;
        }
    }
}
