import java.util.ArrayList;

public class Room {
  private Room north = null;
  private Room south = null;
  private Room west = null;
  private Room east = null;
  private ArrayList<Item> items = new ArrayList<>();
  private ArrayList<Enemy> enemies = new ArrayList<>();
  private String name;
  private String description;

  public Room(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Room(String name) {
    this.name = name;
  }

  public Room() {
  }

  public void setNorth(Room room) {
    this.north = room;
    this.north.south = this;
  }

  public void setSouth(Room room) {
    this.south = room;
    this.south.north = this;
  }

  public void setWest(Room room) {
    this.west = room;
    this.west.east = this;
  }

  public void setEast(Room room) {
    this.east = room;
    this.east.west = this;
  }

  public Room getNorth() {
    return north;
  }

  public Room getSouth() {
    return south;
  }

  public Room getWest() {
    return west;
  }

  public Room getEast() {
    return east;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ArrayList<Item> getItems() {
    return this.items;
  }
  public Item findItem(String itemName) {
    Item item;
    for (int i = 0; i < items.size(); i++) {
      if (items.get(i).getName().equalsIgnoreCase(itemName)
          ^ items.get(i).toString().equalsIgnoreCase(itemName)) {
        System.out.println("Room findItem: kunne godt finde item");
        item = items.get(i);
        return item;
      }
    }
    return null;
  }

  public ArrayList<Enemy> getEnemies() {
    return this.enemies;
  }
  public Enemy findEnemy(String enemyName) {
    Enemy enemy;
    for (int i = 0; i < enemies.size(); i++) {
      if (enemies.get(i).getName().equalsIgnoreCase(enemyName)
          ^ enemies.get(i).toString().equalsIgnoreCase(enemyName)) {
        System.out.println("Room findEnemy: kunne godt finde enemy");
        enemy = enemies.get(i);
        return enemy;
      }
    }
    return null;
  }

        }







