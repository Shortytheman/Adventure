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
public void roomDescriptions(){
  Room room1 = new Room("Gloomy room","A thick cloud of gloomy ashes covers the room..\nyou look around and the room clears up with the brease you brought..");
}
}
