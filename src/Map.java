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
  Room room5 = new Room("room5", "room5");
  Room room6 = new Room("hall of bling bling");
  Room room7 = new Room("underwater terrarium", "MLMLLLLL BLBLLLLBLBL mrglmrglmrglmrgl\nWhile getting" +
          " your ears destroyed by weirds sounds, you notice something resembling a cross drawn on the ground.");
  Room room8 = new Room("DontGoUp place", "Welcome to this room traveler, if u go up north " +
      "here, i will kill\na puppy from the room of " +
      "distractions.. i PROMISE I WILL.. so don't do it! ");
  Room room9 = new Room("you-are-probably-lost area");
  Room room10 = new Room("room10", "room10");
  Room room11 = new Room("room11", "room11");
  Room room12 = new Room("room12", "room11");
  Room room13 = new Room("ROOM OF WINNINGS!");
  Room room14 = new Room("room14", "room11");
  Room room15 = new Room("room15", "room11");
  Room room16 = new Room("room16", "room11");
  Room room17 = new Room("room17", "room11");
  Room room18 = new Room("room18", "room11");
  Room room19 = new Room("room19", "room11");
  Room room20 = new Room("room20", "room11");
  Room room21 = new Room("room21", "room11");
  Room room22 = new Room("room22", "room11");
  Room room23 = new Room("room23", "room11");
  Room room24 = new Room("room24", "room11");
  Room room25 = new Room("room25", "room11");
  Room secretRoom = new Room("Pit of despair", "There is no way out");


  public void makeConnections(){
    room1.setEast(room2);
    room1.setSouth(room6);
    room2.setEast(room3);
    room2.setSouth(room7);
    room3.setEast(room4);
    room3.setSouth(room8);
    room4.setEast(room5);
    room4.setSouth(room9);
    room5.setSouth(room10);
    room6.setEast(room7);
    room6.setSouth(room11);
    room7.setEast(room8);
    room7.setSouth(room12);
    room8.setEast(room9);
    room8.setSouth(room13);
    room9.setEast(room10);
    room9.setSouth(room14);
    room10.setSouth(room15);
    room11.setEast(room12);
    room11.setSouth(room16);
    room12.setSouth(room17);
    room13.setSouth(room18);
    room14.setEast(room15);
    room14.setSouth(room19);
    room15.setSouth(room20);
    room16.setEast(room17);
    room16.setSouth(room21);
    room17.setEast(room18);
    room17.setSouth(room22);
    room18.setEast(room19);
    room18.setSouth(room23);
    room19.setEast(room20);
    room19.setSouth(room24);
    room20.setSouth(room25);
    room21.setEast(room22);
    room22.setEast(room23);
    room23.setEast(room24);
    room24.setEast(room25);


    room4.getItems().add(new Thing("shovel"));
    room1.getItems().add(new Food("Moldy bread", -10));
    room1.getItems().add(new MeleeWeapon("Greataxe", 50));
    secretRoom.getItems().add((new MeleeWeapon()));
    room2.getItems().add(new Food(-200, "a suspicious looking",
                                  "banana", "that looks completely safe"));

  }

  public void addItems(){
    Random random = new Random();
    int f = random.nextInt(9)+1;
    int g = random.nextInt(4)+1;
    int m = 0;
    do {
      switch (f) {
       // case 1:
         // room1.getItems().add(new Item());

         // m++;
        case 2:
          room2.getItems().add(new Thing());
          room2.getItems().add(new Food());
          m++;
        case 3:
          room3.getItems().add(new Thing());
          m++;
        case 4:
          room4.getItems().add(new Thing());
          m++;
        case 5:
          room5.getItems().add(new Thing());
          m++;
        case 6:
          room6.getItems().add(new Thing());
          m++;
        case 7:
          room7.getItems().add(new Thing());
          m++;
        case 8:
          room8.getItems().add(new Thing());
          m++;
        case 9:
          room9.getItems().add(new Thing());
          m++;
      }
    }
    while (m < g);

  }

}
