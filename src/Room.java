public class Room {
  Room north = null;
  Room south = null;
  Room west = null;
  Room east = null;

  String name;
  String description;

  public Room(String name, String description){
    this.name = name;
    this.description = description;
  }

}
