import java.text.DecimalFormat;
import java.util.ArrayList;

public class NonFoodItem extends Item {
    //create private Date variable for the materials used
    private ArrayList<String> materials = new ArrayList<String>();

    //constructor is open for three input variables(name of the product, price of the product, materials which the item is made of)
    public NonFoodItem(String name, double price, ArrayList<String> materials)
    {

        // Call the superclass constructor to
        // initialize name and price.
        super(name, price);

        // Initialize materials.
        this.materials = materials;
    }

    //create method which overrides to string, such when we print the item, we don't get a reference, but the actual item
    @Override
    public String toString(){
        //get name, price and materials
        String name = getName();
        Double price = getPrice();
        //since materials is now an ArrayList, we cannot just state "toString".
        //This is a solution which converts the list to a string
        ArrayList<String> materials = getMaterials();
        String listString = String.join(", ", materials);
        //create a pattern for the printing of the price. Normally prices are visualized in two decimal format
        DecimalFormat df = new DecimalFormat("0.00");
        //create the return of the item
        return "item: "+name +" | price: "+df.format(price)+" DKK  | materials: "+ listString;
    }

    public ArrayList<String> getMaterials() {
        return materials;
    }
}
