import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //fill up the inventory
        int amountOfItems = 10;
        Inventory inventory = fillUpInventory(amountOfItems);



        //calculating the inventory worth and print it out in a customer friendly format
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Total value of the inventory is: "+df.format(inventory.getInventoryValue())+" DKK");
        System.out.println("\n");

        //printing out the inventory
        inventory.printInventory();

        //make space
        System.out.println("\n\n");
        //throw out all the food, which is expired
        inventory.removeExpiredFoods();
        //check if all food which is expired was thrown out
        inventory.printInventory();
    }

    //this method fills up the inventory
    public static Inventory fillUpInventory(int amountOfItems){
        //divided by two because in the for loop we always fill the inventory with 2 items
        //round to next int
        amountOfItems = Math.round(amountOfItems/ 2);
        //creating a new inventory
        Inventory inventory = new Inventory();

        //filling up the inventory
        for (int i = 0; i<amountOfItems; i++){
            //a food item is added to the inventory
            inventory.addItem(createFoodItem());
            //a non-food item is added to the inventory
            inventory.addItem(createNonFoodItem());
        }
        return inventory;
    }

    //this method removes a certain amount of items from the inventory
    public static void removeItems(Inventory inventory, int numberOfItems){
        //find out how many items should be removed
        if (numberOfItems<inventory.getItems().size()){
            for (int i = 0; i<numberOfItems; i++){
                //from the whole inventory remove the item on index i
                inventory.removeItem(inventory.getItems().get(0));
            }
        }
        else{
            int size = inventory.getItems().size();
            for (int i = 0; i<size; i++){
                //from the whole inventory remove the item on index i
                inventory.removeItem(inventory.getItems().get(0));
            }

        }

    }

    //with every call a random food item is created
    public static FoodItem createFoodItem(){
        Random r = new Random();

        //create a random name from predefined possibilities
        String[] foodNames = new String[]{"Cola", "Sprite", "Fries", "Edamame", "Sushi",
                "SpringRolls", "Pizza", "Broccoli", "Carrots", "Tomatoes", "Cauliflower"  };
        String name = foodNames[r.nextInt(foodNames.length)];


        double price = 0.1 + (10 - 0.1) * r.nextDouble();

        //create a random Date for the expiration Date
        Calendar randomCal = Calendar.getInstance();
        randomCal.set(r.nextInt(2026-2019) + 2019, r.nextInt(11), r.nextInt(30));

        //Convert Calendar to Date
        Date randomDate = randomCal.getTime();

        //create the FoodItem with the generated values and return it
        return new FoodItem(name, price, randomDate);

    }

    //with every call a random nonfood item is created
    public static NonFoodItem createNonFoodItem(){
        //take a random non-food item
        String[] nonFoodNames = new String[]{"Couch", "Door", "Car", "Lamp", "Oven",
                "Pan", "Watter bottle", "Spoon", "Floor", "Chair", "Bed"  };
        Random r = new Random();
        String name = nonFoodNames[r.nextInt(nonFoodNames.length)];

        //create a random price between 0.1 and 100
        double price = 0.1 + (100 - 0.1) * r.nextDouble();

        //create a pseudy randomization for the amount on the category of materials
        String[] materials = new String[]{"wood", "steel", "cotton", "clay", "glass", "plastic", "paper" };
        int numberOfMaterials = r.nextInt(materials.length-1) + 1;
        ArrayList<String> materialUsed = new ArrayList<>();
        for (int i=0; i<numberOfMaterials; i++){
            materialUsed.add(materials[i]);
        }

        //create the NonFoodItem with the generated values and return it
        return new NonFoodItem(name, price, materialUsed);
    }


}