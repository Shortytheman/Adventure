import java.util.Scanner;
/*
public class RoomActivity {

  public void diceGame() {
    int result = 0;
    String roll;

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
            adventure.exitGame();
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
            System.out.println("You hit the jackpot and will now be teleported to a random location");
            double teleportResult = 1 + (Math.random() * 7);
            System.out.println("( ಠ ͜ʖ ಠ )⊃══⛧⌒｡ ~ALAKAZAM~");
            switch ((int) teleportResult) {
              case 1 -> {
                player.setCurrentRoom(gameMap.room1);
                System.out.println("You were teleported to the " + player.getCurrentRoom().getName());
                System.out.println(player.getCurrentRoom().getDescription());
              }
            }
            switch ((int) teleportResult) {
              case 2 -> {
                player.setCurrentRoom(gameMap.room3);
                System.out.println("You were teleported to the " + player.getCurrentRoom().getName());
                System.out.println(player.getCurrentRoom().getDescription());
              }
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

  public int diceThrow() {
    double g = 1 + (Math.random() * 6);
    return (int) g;
  }

}

 */
