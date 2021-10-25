
import java.util.*;

public class Item {
  ArrayList <Item> items = new ArrayList<>();
    private String longName;
    private String shortName;

    public Item(String shortName, String longName) {
        this.shortName = shortName;
        this. longName = longName;


    }
    public String getShortName() {
        return this.shortName;
    }
    public String getLongName() {
        return this.longName;
    }

  Item(String items, String prefix, String suffix){

  }

  Item(){
  }

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

  public String itemPrefix(){
    ArrayList<String > itemPrefix = new ArrayList<>();
    itemPrefix.add("dirty old");
    itemPrefix.add("shiny");
    itemPrefix.add("damn good looking");
    itemPrefix.add("worn out");
    itemPrefix.add("some giddi'up looking");
    Random rand = new Random();
    int random = rand.nextInt(itemPrefix.size());
    return itemPrefix.get(random);
  }

  public String itemSuffix(){
    ArrayList<String > itemSuffix = new ArrayList<>();
    itemSuffix.add("with some dust on it..");
    itemSuffix.add("that has seen better days");
    itemSuffix.add("that looks good to me");
    itemSuffix.add("i wonder what i can use this for");
    itemSuffix.add("what a strange thing to find");
    Random rand = new Random();
    int random = rand.nextInt(itemSuffix.size());
    return itemSuffix.get(random);
  }

  public Item makeAnItem(){
    return new Item(itemNames(), itemPrefix(), itemSuffix());
  }

}
