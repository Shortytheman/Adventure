import java.util.ArrayList;

public class Player {
    private int stepCounter;
    private final int MAX_STEPS = 30;
    private Room currentRoom;
    private String playerName;
    private int health = 100;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Weapon currentWeapon;

    public Room getCurrentRoom() {
        return this.currentRoom;
    }
    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {
            this.health = health;
            if (getHealth() > 100) {
                this.health = 100;
        }
    }
    public ArrayList<Item> getInventory() {
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

    public void incrementStepCounter() {
        stepCounter++;
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
    public void setCurrentWeapon(Weapon weapon) {
        this.currentWeapon = weapon;
    }
    public void attack(Enemy enemy) {
        enemy.getHit(getCurrentWeapon().getDamage());

    }
    public void getHit(int damage) {
        setHealth(getHealth() - damage);
    }

    public Item findItem(String itemName) {
        Item item;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName)
                    || inventory.get(i).toString().equalsIgnoreCase(itemName)) {
                item = inventory.get(i);
                return item;
            }
        }
        return null;
    }

    public void takeItem(Item item) {
        if (item != null) {
            inventory.add(item);
            getCurrentRoomItems().remove(item);
        }

    }
    public void equipWeapon(Weapon weapon) {
        if (weapon != null) {
            if(currentWeapon != null){
                inventory.add(currentWeapon);
            }
            setCurrentWeapon(weapon);
            getCurrentRoomItems().remove(weapon);
            inventory.remove(weapon);
        }
    }
    public void dropItem(Item item) {
        if (item != null) {
            getCurrentRoomItems().add(item);
            inventory.remove(item);
        }

    }
    public void eatConsumable(Consumable consumable) {
        setHealth(getHealth() + consumable.getHealthValue());
    }
    public String checkHealth() {
        String status = "";
        if (getHealth() > 74) {
            status = "You are in great health and ready to fight!";
        } else if (getHealth() <= 74 && getHealth() > 50) {
            status = "You are slightly wounded but can still fight.";
        } else if (getHealth() <= 50 && getHealth() > 25) {
            status = "You are in poor shape and should probably eat something";
        } else if (getHealth() <= 25) {
            status = "You are severely wounded and need to avoid fighting if you can";
        }
        return status;
    }
    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }
    }

