import java.util.Scanner;

public class Adventure {
    Player player;
    Map gameMap;

    public Adventure() {
        player = new Player();
        gameMap = new Map();
    }

    private boolean gameIsRunning = true;
    private String input;

    public Boolean getGameIsRunning() {
        return this.gameIsRunning;
    }

    public void setGameIsRunning(Boolean gameIsRunning) {
        this.gameIsRunning = gameIsRunning;
    }

    void look() {
        System.out.println("You're looking around in the room...");
        getCurrentRoomDescription();
    }

    void help() {
        System.out.println("\n\n( ಠ ͜ʖ ಠ ) Hello outcast it is I  --  Merlin, the great wizard. " +
                "You've asked for advice " + "on your journey -- and so, i shall provide!." +
                "\n\n( ಠ ͜ʖ ಠ )⊃══⛧⌒｡ ~ALAKAZAM~");
        System.out.println("________________________\nDirections \nTo go north: \"go north\" \nTo go south: " +
                "\"go south\" \nTo go west: \"go west\" \nTo go east: \"go east\"");
        System.out.println("________________________\nTo look around: \"Look\"");
        System.out.println("________________________\nTo exit the game: \"Exit\"\n________________________");
        System.out.println("To check your inventory: \"Inv\"\n________________________");
        System.out.println("Make your choice to proceed, " + player.getPlayerName() + "!");
    }

    void exitGame() {
        setGameIsRunning(false);
    }

    public void run() {
        gameMap.makeConnections();
        gameMap.addItems();
        player.setCurrentRoom(gameMap.room1);

        System.out.println("Welcome young traveler, to the cave of the unforeseen.. If you dare enter, " +
                "sign the waiver of \"prolly ok\"\n");
        System.out.print("""
                |The waiver of prolly ok                                            |
                |bla bla, something about having being trapped forever jada jada..  |
                |bla bla.. giving away your soul to the kingdom of mages jada jada..|
                |SIGN HERE:\s """);
        Scanner scanner = new Scanner(System.in);
        player.setPlayerName(scanner.nextLine());

        gameMap.room5.setDescription("You did it " + player.getPlayerName() + ".. when no one believed in you" +
                ", not even yourself, so how'd u get out? like\n" +
                "really please tell me, i need to know for realz man.. congratz");

        gameMap.room6.setDescription("The room is full of gold and glitters," +
                " but everytime your eyes gaze upon the treasures\n" +
                "your butt starts to itch.. better keep moving before " +
                "you make too much of a mess in your behind mr. " + player.getPlayerName() + "!");

        gameMap.room9.setDescription("ey " + player.getPlayerName() + ", you are probably lost, like so many of us... " +
                "better get moving.");

        System.out.println("\nMuahaha, you now belong to the cave.. Find your way out and your soul shall be saved.." +
                "\nI will grant you.. hmm.." +
                "100 steps in my cave before exhaustion gets the best of you. - Waiiit..\"looking at the waiver\".. " +
                "\nyour name is " + player.getPlayerName() + "?!.. for such " +
                "a puny name i shall ony provide you with 30 steps.. best of luck, you'll need it!");

        System.out.println("\n - Luckily your journey has been blessed by Merlin the great wizard and he wants you " +
                "to succeed\n" + "he has bestowed upon you the gift of choice, " +
                "and therefore you have the following choices: ");
        System.out.println("________________________\nDirections \nTo go north: \"go north\" \nTo go south: " +
                "\"go south\" \nTo go west: \"go west\" \nTo go east: \"go east\"");
        System.out.println("________________________\nTo look around: \"Look\"");
        System.out.println("________________________\nTo summon help: \"Help\"");
        System.out.println("________________________\nTo exit the game: \"Exit\"\n________________________");
        System.out.println("Best make haste, " + player.getPlayerName() + ", you don't have much time!");

        while (getGameIsRunning()) {
            if (player.getCurrentRoom() == gameMap.room5) {
                System.out.println("You win, game over!");
                setGameIsRunning(false);
            } else if (player.getStepCounter() == player.getMAX_STEPS()) {
                System.out.println("You died of exhaustion");
                setGameIsRunning(false);
            } else if (player.getHealth() < 1) {
                System.out.println("You suddenly die of an unknown cause" +
                        ", although it was most likely a banana overdose.");
                setGameIsRunning(false);
            }
            else {
                choice();
            }
        }
    }

    public void choice() {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Exiting game");
            exitGame();
        } else if (input.equalsIgnoreCase("help")) {
            System.out.print("\nSummoning a helping hand...");
            help();
        } else if (input.equalsIgnoreCase("look")) {
            look();
        } else if (input.equalsIgnoreCase("inventory")
                || input.equalsIgnoreCase("inv")) {
            printInventory();
        } else if (input.equalsIgnoreCase("health")) {
            player.checkHealth();
        }
        else if (input.contains("equip ")) {
            if(player.findItem(input.substring(6)) != null
                && player.findItem(input.substring(6)) instanceof Weapon) {
                player.equipWeapon((Weapon)player.findItem(input.substring(6)));
                System.out.println("You have equipped " + input.substring(6));
            }
            else if (player.findItem(input.substring(6)) != null
                    && !(player.findItem(input.substring(6)) instanceof Weapon)) {
                System.out.println("You can't equip that");
            }
        }
        else if (input.contains("eat ")) {
            if (player.getCurrentRoom().findItem(input.substring(4)) != null
                    && player.getCurrentRoom().findItem(input.substring(4)) instanceof Consumable) {
                System.out.println(player.getHealth());
                player.eatConsumable((Food) player.getCurrentRoom().findItem(input.substring(4)));
                player.getCurrentRoom().getItems().remove(player.getCurrentRoom().findItem(input.substring(4)));
                // player.eatConsumable((Consumable) player.findItem(input.substring(4)));
                System.out.println("You consumed " + input.substring(4));
                System.out.println(player.getHealth());
            }
            // Den går ned i den sidste else, i stedet for den anden sidste, hvis man prøver at spise et våben fra inventory
            else if (player.findItem(input.substring(4)) != null
                    && player.findItem(input.substring(4)) instanceof Consumable) {
                System.out.println(player.getHealth());
                player.eatConsumable((Consumable) player.findItem((input.substring(4))));
                player.getInventory().remove(player.findItem(input.substring(4)));
                System.out.println("You ate " + input.substring(4));
                System.out.println(player.getHealth());
            } else if (player.getCurrentRoom().findItem(input.substring(4)) != null
                    && player.getCurrentRoom().findItem(input.substring(4)) instanceof Consumable != true
                        || player.findItem(input.substring(4)) != null &&
                    player.findItem(input.substring(4)) instanceof Consumable != true) {
                System.out.println("You can't eat " + input.substring(4) + ".");
            } else {
                System.out.println("You don't have a " + input.substring(4) + " in your inventory.");
            }

        } else if (input.equalsIgnoreCase("dig")
                && player.findItem("shovel") != null
                && player.getCurrentRoom() == gameMap.room7) {
            player.setCurrentRoom(gameMap.secretRoom);
            System.out.println("You have entered the " + player.getCurrentRoom().getName());
            getCurrentRoomDescription();
            // Bruger trim() så den ikke crasher
        } else if (input.contains("drop")) {
            if (player.findItem(input.substring(4).trim()) != null) {
                player.dropItem(player.findItem(input.substring(4).trim()));
                System.out.println("You dropped a " + input.substring(4).trim());
            } else {
                System.out.println("There is no such thing as a " + input.substring(5) + " in your inventory.");
            }
            // Vigtigt med mellemrum efter "take", da den ellers crasher. Har gjort det på en anden måde oppe i "drop".
        } else if (input.contains("take ")) {
            if (player.getCurrentRoom().findItem(input.substring(5)) != null) {
                player.takeItem(player.getCurrentRoom().findItem(input.substring(5)));
                System.out.println("You picked up a " + input.substring(5));
            } else {
                System.out.println("There is no such thing as a " + input.substring(5) + " in the room.");
            }
        }
        else if (input.contains("equip ")) {
            if (player.getCurrentRoom().findItem(input.substring(6)) != null
                && player.getCurrentRoom().findItem(input.substring(6)) instanceof Weapon) {
                player.takeItem(player.getCurrentRoom().findItem(input.substring(5)));
                System.out.println("You equipped the" + input.substring(5));
            } else {
                System.out.println("There is no such thing as a " + input.substring(5) + " in the room.");
            }
        } else if (input.contains("shoot ")){
            if (player.getCurrentRoom().findItem(input.substring(6)) instanceof RangedWeapon
                && player.getCurrentRoom().findEnemy(input.substring(6)) != null)
             {
                ((RangedWeapon) player.getCurrentRoom().findItem(input.substring(6))).durability--;
                 player.getCurrentRoom().findEnemy(input.substring(6)).getHit((((RangedWeapon) player.getCurrentRoom().findItem(input.substring(6))).getDamage()));
                 System.out.println(((RangedWeapon) player.getCurrentRoom().findItem(input.substring(6))).durability);
            }
            System.out.println(player.getCurrentRoom().findEnemy(input.substring(6)).getName() + " now has: " + player.getCurrentRoom().findEnemy(input.substring(6)).getHealth() + " left");
            if (player.getCurrentRoom().findEnemy(input.substring(6)).getHealth() <= 0){
                System.out.println("Hurray, you have killed " + player.getCurrentRoom().findEnemy(input.substring(6)).getName());
            }
            else
                System.out.println("You can't shoot that here");
        }
            else if (!input.equalsIgnoreCase("look") && !input.equalsIgnoreCase("exit")
                && !input.equalsIgnoreCase("help") && !input.equalsIgnoreCase("go east")
                && !input.equalsIgnoreCase("go north") &&
                !input.equalsIgnoreCase("go west") && !input.equalsIgnoreCase("go south")) {
            System.out.println("Sorry i don't understand the input.. try again!");
        } else {
            move(input);
            checkStepCounter();
        }
    }

    public void move(String direction) {

        if (direction.equalsIgnoreCase("go north") && player.getCurrentRoom().getNorth() != null) {
            player.setCurrentRoom(player.getCurrentRoom().getNorth());
            System.out.println("Going north!");
            System.out.println("You have entered the " + player.getCurrentRoom().getName());
            getCurrentRoomDescription();
            player.incrementStepCounter();

        } else if (direction.equalsIgnoreCase("go south") && player.getCurrentRoom().getSouth() != null) {
            player.setCurrentRoom(player.getCurrentRoom().getSouth());
            System.out.println("Going south!");
            System.out.println("You have entered the " + player.getCurrentRoom().getName());
            getCurrentRoomDescription();
            player.incrementStepCounter();


        } else if (direction.equalsIgnoreCase("go west") && player.getCurrentRoom().getWest() != null) {
            player.setCurrentRoom(player.getCurrentRoom().getWest());
            System.out.println("Going west!");
            System.out.println("You have entered the " + player.getCurrentRoom().getName());
            getCurrentRoomDescription();
            player.incrementStepCounter();


        } else if (direction.equalsIgnoreCase("go east") && player.getCurrentRoom().getEast() != null) {
            player.setCurrentRoom(player.getCurrentRoom().getEast());
            System.out.println("Going east!");
            System.out.println("You have entered the " + player.getCurrentRoom().getName());
            getCurrentRoomDescription();
            player.incrementStepCounter();

        } else {
            if (!direction.equalsIgnoreCase("exit"))
                System.out.println("Can't go that way");
        }
    }

    public void checkStepCounter() {
        if (player.getStepCounter() == 10 || player.getStepCounter() == 15 || player.getStepCounter() == 25)
            if (player.getCurrentRoom() != gameMap.room5) {
                System.out.println("You have walked " + player.getStepCounter() + " steps and are getting exhausted.");
                System.out.println("You have " + (player.getMAX_STEPS() - player.getStepCounter()) + " steps left.");
            }
    }

    public void printInventory() {
        int itemNumber = 1;
        if (player.getInventory().size() != 0)
            for (Item s : player.getInventory()) {
                System.out.println(itemNumber + ". " + s);
                itemNumber++;
            }
        else {
            System.out.println("There is nothing in your inventory.");
        }
    }

    public void getCurrentRoomDescription() {
        if (player.getCurrentRoomItems().size() == 0) {
            System.out.println(player.getCurrentRoomDescription());
            System.out.println("There's nothing of interest in the room");
        } else {
            System.out.print(player.getCurrentRoomDescription() + "\nLooking around the room you see ");
            for (int i = 0; i < player.getCurrentRoomItems().size(); i++)
                if (1 == player.getCurrentRoomItems().size())
                    System.out.println(player.getCurrentRoomItems().get(i).getFullName() + ".");
                else if (i + 1 == player.getCurrentRoomItems().size()) {
                    System.out.println("and " + player.getCurrentRoomItems().get(i).getFullName() + ".");
                } else {
                    System.out.print(player.getCurrentRoomItems().get(i).getFullName() + ", ");

                }
            for (int i = 0; i < player.getCurrentRoom().getEnemies().size(); i++)
                System.out.println("You also see a " + player.getCurrentRoom().getEnemies().get(i).getFullName());
        }
    }

    public static void main(String[] args) {
        Adventure adventure = new Adventure();
        adventure.run();

    }
}

