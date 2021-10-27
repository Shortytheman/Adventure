import java.util.ArrayList;
import java.util.Random;

public class Consumable extends Item{

  private int health;

  public Consumable(String name, int health){
    this.name = name;
    this.prefix = itemPrefix();
    this.suffix = itemSuffix();
    this.health = health;
  }

  public Consumable(int health){
    this.name = itemNames();
    this.prefix = itemPrefix();
    this.suffix = itemSuffix();
  }

  public String itemNames(){
    ArrayList<String> itemNames = new ArrayList<>();
    itemNames.add("wine");
    itemNames.add("beer");
    itemNames.add("beaver juice");
    itemNames.add("bread");
    itemNames.add("porkchop");
    itemNames.add("mucky water");
    Random rand = new Random();
    int random = rand.nextInt(itemNames.size());
    return itemNames.get(random);
  }

}
