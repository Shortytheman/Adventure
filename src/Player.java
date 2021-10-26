import java.util.ArrayList;

public class Player {
    private int stepCounter;
    private final int MAX_STEPS = 30;
    private Room currentRoom;
    private String playerName;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public String getCurrentRoomDescription() {
        return this.currentRoom.getDescription();
    }

    public ArrayList<Item> getCurrentRoomItems() {
       return getCurrentRoom().getItems();

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

    public void incrementStepCounter(){
        stepCounter++;
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

    public Item findItem(String itemName) {
        Item item;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName)
                    || inventory.get(i).toString().equalsIgnoreCase(itemName)) {
                System.out.println("findItem: kunne godt finde item");
                item = inventory.get(i);
                return item;
            }
        }
        System.out.println("findItem: den returner null");
        return null;
    }
    public void takeItem(Item item) {
        if (item != null) {
            inventory.add(item);
            getCurrentRoomItems().remove(item);

            System.out.println("den her kører");
        }
        else {
            System.out.println("der er ikke blevet samlet noget op");
        }
    }
   /* if (getCurrentRoom().getName().equalsIgnoreCase("chance room")) {
      RoomActivity activity = new RoomActivity();
      activity.diceGame();
      }
      */
    }

