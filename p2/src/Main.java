import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //fill up the inventory
        int amountOfItems = 21;
        Inventory inventory = fillUpInventory(amountOfItems);

        //calculating the inventory worth and print it out in a customer friendly format
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Total value of the inventory is: "+df.format(inventory.getInventoryValue())+" DKK");
        System.out.println("\n");

        //printing out the inventory
        inventory.printInventory();

    }

    //this method fills up the inventory
    public static Inventory fillUpInventory(int amountOfItems){
        //divided by two because in the for loop we always fill the inventory with 2 items
        //roudn to next int
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

    public static FoodItem createFoodItem(){
        Random r = new Random();

        //create a random name from predefined possibilities
        String[] foodNames = new String[]{"Cola", "Sprite", "Fries", "Edamame", "Sushi",
                "SpringRolls", "Pizza", "Broccoli", "Carrots", "Tomatoes", "Coliflower"  };
        String name = foodNames[r.nextInt(foodNames.length)];


        double price = 0.1 + (10 - 0.1) * r.nextDouble();

        //create a random Date for the expiration Date
        Calendar randomCal = Calendar.getInstance();
        randomCal.set(r.nextInt(2026-2022) + 2022, r.nextInt(11), r.nextInt(30));

        //Convert Calendar to Date
        Date randomDate = randomCal.getTime();

        //create the FoodItem with the generated values and return it
        FoodItem foodItem = new FoodItem(name, price, randomDate);
        return foodItem;

    }

    public static NonFoodItem createNonFoodItem(){
        //take a random non food item
        String[] nonFoodNames = new String[]{"Couch", "Door", "Car", "Lamp", "Oven",
                "Pan", "Watterbottle", "Spoon", "Floor", "Chair", "Bed"  };
        Random r = new Random();
        String name = nonFoodNames[r.nextInt(nonFoodNames.length)];

        //create a random price between 0.1 and 100
        double price = 0.1 + (100 - 0.1) * r.nextDouble();

        //create a pseudy randomization for the amount on the category of materials
        String[] materials = new String[]{"wood", "steel", "cotton", "clay", "glass", "plastic", "paper" };
        int numberOfMaterials = r.nextInt(materials.length-1) + 1;
        String[] materialUsed = new String[numberOfMaterials];
        for (int j= 0; j<numberOfMaterials; j++){
            materialUsed[j] = materials[j];
        }

        //create the NonFoodItem with the generated values and return it
        NonFoodItem nonFoodItem = new NonFoodItem(name, price, materialUsed);
        return nonFoodItem;
    }


}