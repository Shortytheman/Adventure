
import java.util.*;

public class Item {
  String name;
  String prefix;
  String suffix;

 // Item(String name, String prefix, String suffix){

  public Item(String name) {
    this.name = name;
    this.prefix = itemPrefix();
    this.suffix = itemSuffix();

  }

  Item(){
    this.name = itemNames();
    this.prefix = itemPrefix();
    this.suffix = itemSuffix();
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
    itemPrefix.add("giddi'up looking");
    Random rand = new Random();
    int random = rand.nextInt(itemPrefix.size());
    return itemPrefix.get(random);
  }

  public String itemSuffix(){
    ArrayList<String > itemSuffix = new ArrayList<>();
    itemSuffix.add("with some dust on it");
    itemSuffix.add("that has seen better days");
    itemSuffix.add("that looks good to me");
    itemSuffix.add("i wonder what i can use this for");
    itemSuffix.add("what a strange thing to find");
    Random rand = new Random();
    int random = rand.nextInt(itemSuffix.size());
    return itemSuffix.get(random);
  }
  public String getName() {
    return this.name;
  }

  public String printFullName(){
    return prefix + " " + name + " " + suffix;
  }

  public String toString() {
    return prefix + " " + name;
  }

  }

