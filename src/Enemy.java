import java.util.ArrayList;
import java.util.Random;

public class Enemy {
  private String name;
  private String prefix;
  private String suffix;
  private int health;
  private int damage;

  public Enemy(String name, int damage, int health) {
    this.health = health;
    this.name = name;
    this.damage = damage;
    this.prefix = enemyPrefix();
    this.suffix = enemySuffix();
  }

  public Enemy() {
    this.name = enemyName();
    this.prefix = enemyPrefix();
    this.suffix = enemySuffix();
  }

  public int getHealth() {
    return this.health;
  }
  public void getHit(int damage) {
    this.health = (health - damage);
  }

  public String getName(){
    return this.name;
  }
  public String getFullName() {
    return this.prefix + " " + this.name + " " + this.suffix;
  }

  public String enemyName() {
    ArrayList<String> strings = new ArrayList<>();
    strings.add("pig");
    strings.add("gargoyle");
    strings.add("bat");
    strings.add("old man");
    Random rand = new Random();
    int random = rand.nextInt(strings.size());
    return strings.get(random);
  }

  public String enemyPrefix() {
    ArrayList<String> strings = new ArrayList<>();
    strings.add("dangrous");
    strings.add("angry");
    strings.add("damn good looking");
    strings.add("worn out");
    strings.add("giddi'up looking");
    Random rand = new Random();
    int random = rand.nextInt(strings.size());
    return strings.get(random);
  }

  public String enemySuffix() {
    ArrayList<String> strings = new ArrayList<>();
    strings.add("with some dust on it");
    strings.add("that has seen better days");
    strings.add("that looks good to me");
    strings.add("i wonder what i can use this for");
    strings.add("what a strange thing to find");
    Random rand = new Random();
    int random = rand.nextInt(strings.size());
    return strings.get(random);
  }

}
