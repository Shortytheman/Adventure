import java.util.Scanner;

public class Adventure {

    private Room currentRoom; // Rum 1-9.
    private String playerName;
    private boolean gameIsRunning = true;
    private String choice;
    private int stepCounter;
    private final int MAX_STEPS = 30;

    Room room1 = new Room("cave entrance", "There is a glooming light in the corner, must be from where you came in.. you¨ll have to take either the way " +
            "to the right or straight down to explore further..");
    Room room2 = new Room("chance room", "here, only the lucky will persevere. A man approaches you with a deal");
    Room room3 = new Room("room3", "Dette er rum 3");
    Room room4 = new Room("room4", "Dette er rum 4");
    Room room5 = new Room("room5", "Dette er rum 5");
    Room room6 = new Room("room6", "Dette er rum 6");
    Room room7 = new Room("room7", "Dette er rum 7");
    Room room8 = new Room("room8", "Dette er rum 8");
    Room room9 = new Room("room9", "Dette er rum 9");

    public String choice() {
        Scanner scanner = new Scanner(System.in);

        do {
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("exit")) {
                System.out.println("Exiting game");
                exitGame();
            } else if (choice.equalsIgnoreCase("help")) {
                System.out.print("\nSummoning a helping hand...");
                help();
            } else if (choice.equalsIgnoreCase("look")) {
                System.out.println("You're looking around in the room");
                look();
            } else if (!choice.equalsIgnoreCase("look") && !choice.equalsIgnoreCase("exit")
                    && !choice.equalsIgnoreCase("help") && !choice.equalsIgnoreCase("go east")
                    && !choice.equalsIgnoreCase("go north") && !choice.equalsIgnoreCase("go west") && !choice.equalsIgnoreCase("go south")) {
                System.out.println("Sorry i don't understand the input.. try again!");
            }
        }
        while ((!choice.equalsIgnoreCase("go west") && !choice.equalsIgnoreCase("go east")
            && !choice.equalsIgnoreCase("go south") && !choice.equalsIgnoreCase("go north") &&
                !choice.equalsIgnoreCase("exit")));

        return choice;
    }

    public int diceThrow() {
        double g = 1 + (Math.random() * 6);
        return (int) g;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
    public Boolean getGameIsRunning() {
        return this.gameIsRunning;
    }
    public void setGameIsRunning(Boolean gameIsRunning) {
        this.gameIsRunning = gameIsRunning;
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

    public String toString() {
        return this.currentRoom + "";
    }

    void look() {
        System.out.println(getCurrentRoom().getDescription());
    }

    void help() {
        System.out.println("\n\n( ಠ ͜ʖ ಠ ) Hello outcast it is I  --  Merlin, the great wizard. You've asked for advice " +
            "on your journey and i shall provide you with your options.\n\n( ಠ ͜ʖ ಠ )⊃══⛧⌒｡ ~ALAKAZAM~");
        System.out.println("________________________\nDirections \nTo go north: \"go north\" \nTo go south: \"go south\" \nTo go west: \"go west\" \nTo go east: \"go east\"");
        System.out.println("________________________\nTo look around: \"Look\"");
        System.out.println("________________________\nTo exit the game: \"Exit\"\n________________________");
        System.out.println("Make your choice to proceed, " + getPlayerName()+"!");
    }

    void exitGame() {
        setGameIsRunning(false);
    }

    public void run() {

        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setEast(room3);
        room3.setSouth(room6);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setSouth(room9);
        room7.setEast(room8);
        room8.setEast(room9);

        setCurrentRoom(room1);

        System.out.println("Velkommen til, Skriv din navn");
        Scanner scanner = new Scanner(System.in);
        setPlayerName(scanner.nextLine());
        System.out.println("skoven har btug for en helt, godt du er her " + getPlayerName() +
                ", vi har brug for din hjælp.");
        System.out.println("Skriv kort de ting man kan");

        while (getGameIsRunning()) {
            move();
            if (getStepCounter() == getMAX_STEPS()) {
                System.out.println("You died of exhaustion");
                setGameIsRunning(false);
            }
            if (getCurrentRoom() == room5) {
                System.out.println("You win, game over!");
                setGameIsRunning(false);
            }
        }
    }
    public void move() {

        String direction = choice();

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
            if (!choice.equalsIgnoreCase("exit")) {
                System.out.println("Can't go that way");
            }
        }
        roomActivity();
    }
    public void checkStepCounter() {
        if (getStepCounter() == 10 || getStepCounter() == 15 || getStepCounter() == 25)
            if(getCurrentRoom() != room5) {
                System.out.println("You have walked " + getStepCounter() + " steps and are getting exhausted.");
                System.out.println("You have " + (getMAX_STEPS() - getStepCounter()) + " steps left." );
            }
    }

    public void roomActivity() {
        int result = 0;
        String roll;
        if (!choice.equalsIgnoreCase("go north") && !choice.equalsIgnoreCase("go south")) {
            if (getCurrentRoom().getName().equalsIgnoreCase("chance room")) {
                System.out.println("You have one chance at a reward, best of luck to you traveler. Write \"roll\" to roll the dice and i will reveal your reward");
                Scanner scanner = new Scanner(System.in);

                do {
                    roll = scanner.nextLine();
                    if (roll.equalsIgnoreCase("roll")) {
                        result = diceThrow();
                    } else
                        System.out.println("Wrong input, try again.");
                }
                while (!roll.equalsIgnoreCase("roll"));

                System.out.println("you rolled: " + result);
                switch (result) {
                    case 1:
                        System.out.println("You've managed to lose the entire game on a dice throw... u ded");
                        setGameIsRunning(false);
                        break;
                    case 2:
                        System.out.println("What a shame! no reward for such an abysmal result");
                        break;
                    case 3:
                        System.out.println("Right in the middle, you have received the right to yell \"Martin & Niklas rulez\"");
                        break;
                    case 4:
                        System.out.println("Topend, you get a handshake from a real life leprechaun." +
                                " You feel strangely refreshed");
                        setStepCounter(0);
                        break;
                    case 5:
                        System.out.println("Good roll traveler, you receive a kiss from a faerie.");
                        break;
                    case 6:
                        System.out.println("You hit the jackpot, will now be teleported to a random location");
                        double teleportResult = 1 + (Math.random() * 7);
                        System.out.println("( ಠ ͜ʖ ಠ )⊃══⛧⌒｡ ~ALAKAZAM~");
                        if ((int) teleportResult == 1) {
                            setCurrentRoom(room1);
                            System.out.println("You were teleported to the " + getCurrentRoom().getName());
                            System.out.println(getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 2) {
                            setCurrentRoom(room3);
                            System.out.println("You were teleported to the " + getCurrentRoom().getName());
                            System.out.println(getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 3) {
                            setCurrentRoom(room4);
                            System.out.println("You were teleported to the " + getCurrentRoom().getName());
                            System.out.println(getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 4) {
                            setCurrentRoom(room6);
                            System.out.println("You were teleported to the " + getCurrentRoom().getName());
                            System.out.println(getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 5) {
                            setCurrentRoom(room7);
                            System.out.println("You were teleported to the " + getCurrentRoom().getName());
                            System.out.println(getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 6) {
                            setCurrentRoom(room8);
                            System.out.println("You were teleported to the " + getCurrentRoom().getName());
                            System.out.println(getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 7) {
                            setCurrentRoom(room9);
                            System.out.println("You were teleported to the " + getCurrentRoom().getName());
                            System.out.println(getCurrentRoom().getDescription());
                        }

                        }
                }
            }
        }

    public static void main(String[] args) {
        Adventure run = new Adventure();
        run.run();

    }
}

