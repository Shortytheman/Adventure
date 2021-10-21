public class Player {
    private Room currentRoom; // Rum 1-9.
    private int stepCounter;
    private final int MAX_STEPS = 30;
    private Map gameMap = new Map();

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
    public void move() {
        Parser parser = new Parser();

        String direction = parser.choice();

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
    }
    public void checkStepCounter() {
        if (getStepCounter() == 10 || getStepCounter() == 15 || getStepCounter() == 25)
            if (getCurrentRoom() != gameMap.room5) {
                System.out.println("You have walked " + getStepCounter() + " steps and are getting exhausted.");
                System.out.println("You have " + (getMAX_STEPS() - getStepCounter()) + " steps left.");
            }
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
}
