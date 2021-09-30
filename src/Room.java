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
  public void setNorth(Room room) {
    this.north = room;
  }
  public void setSouth(Room room) {
    this.south = room;
  }
  public void setWest(Room room) {
    this.west = room;
  }
  public void setEast(Room room) {
    this.east = room;
  }
  // hvis man printer et rum med resulterer det i stackoverflow
   /*public String toString() {
    return "Name: " + name + "\nDescription: " + description + "\nNorth: " + north + ", South: " + south + ", " +
            "West: " + west + ", East: " + east;
            }
    */
  }




