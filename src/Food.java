import java.util.ArrayList;
import java.util.Random;

public class Food extends Consumable{


    public Food(String name, int healthValue) {
        this.name = name;
        this.healthValue = healthValue;
    }
    public Food() {}

    public String itemNames(){
        ArrayList<String> itemNames = new ArrayList<>();
        itemNames.add("lamp");
        itemNames.add("shoe");
        itemNames.add("key");
        itemNames.add("sag 'o tatos");
        Random rand = new Random();
        int random = rand.nextInt(itemNames.size());
        return itemNames.get(random);
    }

}

