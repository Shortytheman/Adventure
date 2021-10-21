import java.util.Scanner;

public class Parser {
    String choice;

    public String choice(Player player, Map gameMap, Adventure adventure) {
        Scanner scanner = new Scanner(System.in);

        do {
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("exit")) {
                System.out.println("Exiting game");
                adventure.exitGame();
            } else if (choice.equalsIgnoreCase("help")) {
                System.out.print("\nSummoning a helping hand...");
                adventure.help(player);
            } else if (choice.equalsIgnoreCase("look")) {
                System.out.println("You're looking around in the room");
                adventure.look(player);
            } else if (!choice.equalsIgnoreCase("look") && !choice.equalsIgnoreCase("exit")
                    && !choice.equalsIgnoreCase("help") && !choice.equalsIgnoreCase("go east")
                    && !choice.equalsIgnoreCase("go north") &&
                    !choice.equalsIgnoreCase("go west") && !choice.equalsIgnoreCase("go south")) {
                System.out.println("Sorry i don't understand the input.. try again!");
            }
        }
        while ((!choice.equalsIgnoreCase("go west") && !choice.equalsIgnoreCase("go east")
                && !choice.equalsIgnoreCase("go south") && !choice.equalsIgnoreCase("go north")
                && !choice.equalsIgnoreCase("exit")));


        return choice;
    }
}