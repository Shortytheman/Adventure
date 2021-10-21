public class Player {
  private int stepCounter;
  private final int MAX_STEPS = 30;
  private Map map = new Map();
  String direction;
  private Room currentRoom;
  private String playerName;

  public Room getCurrentRoom() {
    return this.currentRoom;
  }

  public void setCurrentRoom(Room room) {
    this.currentRoom = room;
  }

  public String toString() {
    return this.currentRoom + "";
  }

  public int getStepCounter() {
    return this.stepCounter;
  }

  public void setStepCounter(int stepCounter) {
    this.stepCounter = stepCounter;
  }

  public int getMAX_STEPS() {
    return this.MAX_STEPS;
  }
  public String getPlayerName() {
    return this.playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public void checkStepCounter() {
    if (getStepCounter() == 10 || getStepCounter() == 15 || getStepCounter() == 25)
      if (getCurrentRoom() != map.room5) {
        System.out.println("You have walked " + getStepCounter() + " steps and are getting exhausted.");
        System.out.println("You have " + (getMAX_STEPS() - getStepCounter()) + " steps left.");
      }
  }

  public void move(Player player, Map gameMap, Adventure adventure) {
    Parser parser = new Parser();
    direction = parser.choice(player, gameMap);

    if (direction.equalsIgnoreCase("go north") && getCurrentRoom().getNorth() != null) {
      setCurrentRoom(getCurrentRoom().getNorth());
      System.out.println("Going north!");
      System.out.println("You have entered the " + getCurrentRoom().getName());
      System.out.println(getCurrentRoom().getDescription());
      stepCounter++;
      checkStepCounter();
    } else if (direction.equalsIgnoreCase("go south") && getCurrentRoom().getSouth() != null) {
      setCurrentRoom(getCurrentRoom().getSouth());
      System.out.println("Going south!");
      System.out.println("You have entered the " + getCurrentRoom().getName());
      System.out.println(getCurrentRoom().getDescription());
      stepCounter++;
      checkStepCounter();

    } else if (direction.equalsIgnoreCase("go west") && getCurrentRoom().getWest() != null) {
      setCurrentRoom(getCurrentRoom().getWest());
      System.out.println("Going west!");
      System.out.println("You have entered the " + getCurrentRoom().getName());
      System.out.println(getCurrentRoom().getDescription());
      stepCounter++;
      checkStepCounter();

    } else if (direction.equalsIgnoreCase("go east") && getCurrentRoom().getEast() != null) {
      setCurrentRoom(getCurrentRoom().getEast());
      System.out.println("Going east!");
      System.out.println("You have entered the " + getCurrentRoom().getName());
      System.out.println(getCurrentRoom().getDescription());
      stepCounter++;
      checkStepCounter();
    } else {
      if (!direction.equalsIgnoreCase("exit"))
        System.out.println("Can't go that way");
    }
    if (player.getCurrentRoom().getName().equalsIgnoreCase("chance room")) {
      RoomActivity activity = new RoomActivity();
      activity.diceGame(player,gameMap,adventure);
    }

  }
}