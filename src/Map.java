import java.util.ArrayList;
import java.util.Random;

public class Map {

  Room room1 = new Room("cave entrance", "There is a glooming light in the corner, must be from" +
      " where you came in.. you¨ll have to take either the way " +
      "to the right or straight down to explore further..");
  Room room2 = new Room("chance room", "here, only the lucky will persevere. A man approaches " +
      "you with a deal");
  Room room3 = new Room("room of the neglected", "The room is filled with a smell of old feet" +
      " and bad quality soap, better get out quick, yuck..");
  Room room4 = new Room("room of distractions", "Someone filled this room with puppies, look at " +
      "them go.. don't you just want to\nstay here forever?");
  Room room5 = new Room("ROOM OF WINNINGS!");
  Room room6 = new Room("hall of bling bling");
  Room room7 = new Room("underwater terrarium", "MLMLLLLL BLBLLLLBLBL mrglmrglmrglmrgl");
  Room room8 = new Room("DontGoUp place", "Welcome to this room traveler, if u go up north " +
      "here, i will kill\na puppy from the room of " +
      "distractions.. i PROMISE I WILL.. so don't do it! ");
  Room room9 = new Room("you-are-probably-lost area");

  public void makeConnections(){
    room1.setEast(room2);
    room1.setSouth(room4);
    room2.setEast(room3);
    room3.setSouth(room6);
    room4.setSouth(room7);
    room5.setSouth(room8);
    room6.setSouth(room9);
    room7.setEast(room8);
    room8.setEast(room9);

  }

  public void addItems(){
    Item item = new Item();
    Random random = new Random();
    int f = random.nextInt(9)+1;
    int g = random.nextInt(4)+1;
    int m = 0;
    do {
      switch (f) {
        case 1:
          room1.getItems().add(new Item());
          m++;
        case 2:
          room2.getItems().add(new Item());
          m++;
        case 3:
          room3.getItems().add(new Item());
          m++;
        case 4:
          room4.getItems().add(new Item());
          m++;
        case 5:
          room5.getItems().add(new Item());
          m++;
        case 6:
          room6.getItems().add(new Item());
          m++;
        case 7:
          room7.getItems().add(new Item());
          m++;
        case 8:
          room8.getItems().add(new Item());
          m++;
        case 9:
          room9.getItems().add(new Item());
          m++;
      }
    }
    while (m < g);

  }

}
