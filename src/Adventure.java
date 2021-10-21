import java.util.Scanner;

public class Adventure {

    private boolean gameIsRunning = true;
    private String choice;
    private Map gameMap = new Map();

    public int diceThrow() {
        double g = 1 + (Math.random() * 6);
        return (int) g;
    }

    public Boolean getGameIsRunning() {
        return this.gameIsRunning;
    }

    public void setGameIsRunning(Boolean gameIsRunning) {
        this.gameIsRunning = gameIsRunning;
    }

    void look(Player player) {
        System.out.println(player.getCurrentRoom().getDescription());
    }

    void help(Player player) {
        System.out.println("\n\n( ಠ ͜ʖ ಠ ) Hello outcast it is I  --  Merlin, the great wizard. " +
                "You've asked for advice " + "on your journey and i shall provide you with your options." +
                "\n\n( ಠ ͜ʖ ಠ )⊃══⛧⌒｡ ~ALAKAZAM~");
        System.out.println("________________________\nDirections \nTo go north: \"go north\" \nTo go south: " +
                "\"go south\" \nTo go west: \"go west\" \nTo go east: \"go east\"");
        System.out.println("________________________\nTo look around: \"Look\"");
        System.out.println("________________________\nTo exit the game: \"Exit\"\n________________________");
        System.out.println("Make your choice to proceed, " + player.getPlayerName() + "!");
    }

    void exitGame() {
        setGameIsRunning(false);
    }

    public void run(Player player) {
        gameMap.makeConnections();
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
            } else {
                player.move(player);
            }
        }
    }

    public void roomActivity(Player player) {
        int result = 0;
        String roll;
        if (!choice.equalsIgnoreCase("go north") && !choice.equalsIgnoreCase("go south")) {
            if (player.getCurrentRoom().getName().equalsIgnoreCase("chance room")) {
                System.out.println("You have one chance at a reward, best of luck to you traveler. Write \"roll\"" +
                        " to roll the dice and i will reveal your reward");
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
                        System.out.println("Right in the middle, you have received the right to yell" +
                                " \"Martin & Niklas rulez\"");
                        break;
                    case 4:
                        System.out.println("Topend, you get a handshake from a real life leprechaun." +
                                " You feel strangely refreshed");
                        player.setStepCounter(0);
                        break;
                    case 5:
                        System.out.println("Good roll traveler, you receive a kiss from a faerie.");
                        break;
                    case 6:
                        System.out.println("You hit the jackpot, will now be teleported to a random location");
                        double teleportResult = 1 + (Math.random() * 7);
                        System.out.println("( ಠ ͜ʖ ಠ )⊃══⛧⌒｡ ~ALAKAZAM~");
                        if ((int) teleportResult == 1) {
                            player.setCurrentRoom(gameMap.room1);
                            System.out.println("You were teleported to the " + player.getCurrentRoom().getName());
                            System.out.println(player.getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 2) {
                            player.setCurrentRoom(gameMap.room3);
                            System.out.println("You were teleported to the " + player.getCurrentRoom().getName());
                            System.out.println(player.getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 3) {
                            player.setCurrentRoom(gameMap.room4);
                            System.out.println("You were teleported to the " + player.getCurrentRoom().getName());
                            System.out.println(player.getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 4) {
                            player.setCurrentRoom(gameMap.room6);
                            System.out.println("You were teleported to the " + player.getCurrentRoom().getName());
                            System.out.println(player.getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 5) {
                            player.setCurrentRoom(gameMap.room7);
                            System.out.println("You were teleported to the " + player.getCurrentRoom().getName());
                            System.out.println(player.getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 6) {
                            player.setCurrentRoom(gameMap.room8);
                            System.out.println("You were teleported to the " + player.getCurrentRoom().getName());
                            System.out.println(player.getCurrentRoom().getDescription());
                        }
                        if ((int) teleportResult == 7) {
                            player.setCurrentRoom(gameMap.room9);
                            System.out.println("You were teleported to the " + player.getCurrentRoom().getName());
                            System.out.println(player.getCurrentRoom().getDescription());
                        }

                }
            }
        }
    }

    public static void main(String[] args) {
        Adventure run = new Adventure();
        Player player = new Player();
        run.run(player);
    }
}

