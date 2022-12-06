import java.text.DecimalFormat;
import java.util.Arrays;

public class NonFoodItem extends Item {
    //create private Date variable for the materials used
    private String[] materials;

    //constructor is open for three input variables(name of the product, price of the product, materials which the item is made of)
    public NonFoodItem(String name, double price, String[] materials)
    {

        // Call the superclass constructor to
        // initialize name and price.
        super(name, price);

        // Initialize expiration.
        this.materials = materials;
    }

    //create method which overrides to string, such when we print the item, we don't get a reference, but the actual item
    @Override
    public String toString(){
        //get name, price and materials
        String name = getName();
        Double price = getPrice();
        String[] materials = getMaterials();
        //create a pattern for the printing of the price. Normally prices are visualized in two decimal format
        DecimalFormat df = new DecimalFormat("0.00");
        //create the return of the item
        return "item: "+name +" | price: "+df.format(price)+" DKK  | materials: "+ Arrays.toString(materials);
    }

    public String[] getMaterials() {
        return materials;
    }
}
