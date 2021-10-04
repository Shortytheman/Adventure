public class Room {
  private Room north = null;
  private Room south = null;
  private Room west = null;
  private Room east = null;

  String name;
  String description;

  public Room(String name, String description) {
    this.name = name;
    this.description = description;
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
  public Room getNorth(){
    return north;
  }
  public Room getSouth(){
    return south;
  }
  public Room getWest(){
    return west;
  }
  public Room getEast(){
    return east;
  }

}