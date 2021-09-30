import java.util.Scanner;

public class Adventure {

  Room currentRoom; // Rum 1-9.

  public String choice(){
    Scanner scanner = new Scanner(System.in);
    String choice;
    System.out.println("Make your choice\n________________________ \nDirections: go north, go south, go west or go east to travel in the desired direction.\nAsk for help: help\nLook around: look");
    choice = scanner.nextLine();
    if (choice.equalsIgnoreCase("go west") || choice.equalsIgnoreCase("go east") || choice.equalsIgnoreCase("go south") || choice.equalsIgnoreCase("go north")) {
      return choice;
    }else if(choice.equalsIgnoreCase("exit")) {
      System.out.println("Exiting game");
      exitGame();
    }
    else if(choice.equalsIgnoreCase("help")){
      System.out.print("\nSummoning a helping hand...");
      help();
    }
    else if (choice.equalsIgnoreCase("look")){
      System.out.println("You're looking around in the room");
      look();
    }
      do {
        System.out.println("Please enter one of the valid options");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("exit")) {
          System.out.println("Exiting game");
          exitGame();
        } else if (choice.equalsIgnoreCase("help")) {
          System.out.print("\nSummoning a helping hand...");
          help();
        } else if (choice.equalsIgnoreCase("look")){
          System.out.println("You're looking around in the room");
          look();
        }
      }
      while ((!choice.equalsIgnoreCase("go west") && !choice.equalsIgnoreCase("go east") && !choice.equalsIgnoreCase("go south") && !choice.equalsIgnoreCase("go north")));
      return choice;
  }
  public Room getCurrentRoom(){
    return this.currentRoom;
  }
  public void setCurrentRoom(Room room){
  this.currentRoom = room;
  }
  public String toString(){
    return this.currentRoom + "";
  }
  void look(){
    System.out.println(currentRoom.description);
  }
  void help(){
    System.out.println("\n\n( ಠ ͜ʖ ಠ ) Hello outcast it is I  --  Merlin, the great wizard. You've asked for advice on your journey and i shall provide you with your options.\n\n( ಠ ͜ʖ ಠ )⊃══⛧⌒｡ ~ALAKAZAM~");
    System.out.println("________________________\nDirections \nTo go north: \"go north\" \nTo go south: \"go south\" \nTo go west: \"go west\" \nTo go east: \"go east\"");
    System.out.println("________________________\nTo look around: \"Look\"");
    System.out.println("________________________\nTo exit the game: \"Exit\"\n________________________");
  }
  void exitGame(){
    System.exit(0);
  }
  public void run() {
    // Kalde rummene noget andet senere og lave descriptions.
    Room room1 = new Room("room1", "dette er rum 1");
    Room room2 = new Room("room2", "Dette er rum 2");
    Room room3 = new Room("room3", "Dette er rum 3");
    Room room4 = new Room("room4", "Dette er rum 4");
    Room room5 = new Room("room5", "Dette er rum 5");
    Room room6 = new Room("room6", "Dette er rum 6");
    Room room7 = new Room("room7", "Dette er rum 7");
    Room room8 = new Room("room8", "Dette er rum 8");
    Room room9 = new Room("room9", "Dette er rum 9");

    room1.setEast(room2);
    room1.setSouth(room4);
    room2.setWest(room1);
    room2.setEast(room3);
    room3.setWest(room2);
    room3.setSouth(room6);
    room4.setNorth(room1);
    room4.setSouth(room7);
    room5.setSouth(room8);
    room6.setNorth(room3);
    room6.setSouth(room9);
    room7.setNorth(room4);
    room7.setEast(room8);
    room8.setWest(room7);
    room8.setNorth(room5);
    room8.setEast(room9);
    room9.setNorth(room6);
    room9.setWest(room8);

    setCurrentRoom(room1);


    boolean gameIsRunning = true;

  }

  public void move() {
    String direction = choice();

    if (direction.equalsIgnoreCase("go north")) {
      if (currentRoom.getNorth() != null) {
        setCurrentRoom(currentRoom.getNorth());
        System.out.println("Going north!");
        System.out.println(currentRoom.description);
      }
      else {
        System.out.println("Can't go that way");
      }
    } else if (direction.equalsIgnoreCase("go south")) {
      if (currentRoom.getSouth() != null) {
        setCurrentRoom(currentRoom.getSouth());
        System.out.println("Going south!");
        System.out.println(currentRoom.description);
      }
      else {
        System.out.println("Can't go that way");
      }

    } else if (direction.equalsIgnoreCase("go west")) {
      if (currentRoom.getWest() != null) {
        setCurrentRoom(currentRoom.getWest());
        System.out.println("Going west!");
        System.out.println(currentRoom.description);
      } else {
        System.out.println("Can't go that way");
      }
    } else if (direction.equalsIgnoreCase("go east")) {
      if (currentRoom.getEast() != null) {
        setCurrentRoom(currentRoom.getEast());
        System.out.println("Going east!");
        System.out.println(currentRoom.description);
      } else {
        System.out.println("Can't go that way");
      }
    }
  }

  public static void main(String[] args) {
    Adventure run = new Adventure();
    run.run();
    run.move();
  }
}

