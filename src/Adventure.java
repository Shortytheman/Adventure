import java.util.Scanner;

public class Adventure {

    private boolean gameIsRunning = true;
    private String choice;

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

    public void run(Player player, Map gameMap, Adventure adventure) {
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
                player.move(player,gameMap,adventure);
            }
        }
    }

    public static void main(String[] args) {
        Adventure adventure = new Adventure();
        Player player = new Player();
        Map gameMap = new Map();
        adventure.run(player,gameMap,adventure);
    }
}

