import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //create food Items and test the food items class
        foodItemsMethod();
        System.out.println("\n \n");
        //create non-food Items and test the non-food items class
        nonFoodItemsMethod();
    }
    //this method tests the foodItems class
    public static void foodItemsMethod(){
        //create a list of food Items, which will be filled in the next loop
        FoodItem[] foodItem = new FoodItem[10];
        //preparation for the food Items list, these are the names which are used for the foodItem list
        String[] foodNames = new String[]{"Cola", "Sprite", "Fries", "Edamame", "Sushi",
                "SpringRolls", "Pizza", "Broccoli", "Carrots", "Tomatoes", "Coliflower"  };
        //for loop in the length of the foodItem list, this for loop fills up the foodItem list
        for (int i = 0; i<foodItem.length; i++){
            //create a random object to create a random price between 0.1 and 10
            Random r = new Random();
            double price = 0.1 + (10 - 0.1) * r.nextDouble();

            //create a random Date for the expiration Date
            Calendar randomCal = Calendar.getInstance();
            randomCal.set(r.nextInt(2026-2022) + 2022, r.nextInt(11), r.nextInt(30));

            //Convert Calendar to Date
            Date randomDate = new Date();
            randomDate = randomCal.getTime();

            //create the FoodItem with the generated values
            FoodItem current = new FoodItem(foodNames[i], price, randomDate);
            //add the FoodItem to the list
            foodItem[i] = current;
        }
        //print out the food item list --> testing to String method
        for (int i = 0; i<foodItem.length; i++){
            System.out.println(foodItem[i].toString());
            //this is a test comment
        }
    }

    //this method tests the nonFoodItems class
    public static void nonFoodItemsMethod(){
        //create a list of non-food Items, which will be filled in the next loop
        NonFoodItem[] nonFoodItem = new NonFoodItem[10];

        //preparation for the non-food Items list, these are the names which are used for the foodItem list
        String[] nonFoodNames = new String[]{"Couch", "Door", "Car", "Lamp", "Oven",
                "Pan", "Watterbottle", "Spoon", "Floor", "Chair", "Bed"  };

        //for loop in the length of the nonFoodItem list, this for loop fills up the foodItem list
        for (int i = 0; i<nonFoodItem.length; i++){
            //create a random object to create a random price between 0.1 and 100
            Random r = new Random();
            double price = 0.1 + (100 - 0.1) * r.nextDouble();

            //create a pseudy randomization for the amount on the category of materials
            String[] materials = new String[]{"wood", "steel", "cotton", "clay", "glass", "plastic", "paper" };
            int numberOfMaterials = r.nextInt(materials.length-1) + 1;
            String[] materialUsed = new String[numberOfMaterials];
            //copy from the materials list to our material used list, the number which is copied is random
            System.arraycopy(materials, 0, materialUsed, 0, numberOfMaterials);

            //create the NonFoodItem with the generated values
            NonFoodItem current = new NonFoodItem(nonFoodNames[i], price, materialUsed);
            //add the NonFoodItem to the list
            nonFoodItem[i] = current;
        }
        //print out the non-food item list, test the toString method
        for (int i = 0; i< nonFoodItem.length; i++){
            System.out.println(nonFoodItem[i].toString());
            }

    }
}