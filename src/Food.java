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
        itemNames.add("bread");
        itemNames.add("apple");
        itemNames.add("banana");
        itemNames.add("porkchop");
        Random rand = new Random();
        int random = rand.nextInt(itemNames.size());
        return itemNames.get(random);
    }
    public String itemPrefix(){
        ArrayList<String > itemPrefix = new ArrayList<>();
        itemPrefix.add("a moldy");
        itemPrefix.add("a half-rotten");
        itemPrefix.add("a damn good looking");
        itemPrefix.add("an overcooked");
        itemPrefix.add("a dry");
        Random rand = new Random();
        int random = rand.nextInt(itemPrefix.size());
        return itemPrefix.get(random);
    }
    public String itemSuffix(){
        ArrayList<String > itemSuffix = new ArrayList<>();
        itemSuffix.add("with some dust on it");
        itemSuffix.add("that has seen better days");
        itemSuffix.add("that looks good to me");
        itemSuffix.add(". I wonder what i can use this for");
        itemSuffix.add(". What a strange thing to find");
        Random rand = new Random();
        int random = rand.nextInt(itemSuffix.size());
        return itemSuffix.get(random);
    }

}

