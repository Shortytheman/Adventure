import java.util.Scanner;

public class Adventure {

  Room currentRoom; // Rum 1-9.

  public String choice(){
    Scanner scanner = new Scanner(System.in);
    String choice;
    System.out.print("Enter your direction, w for west, e for east, n for north and s for south: ");
    choice = scanner.nextLine();

    if (choice.equalsIgnoreCase("w") || choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("n")) {
      return choice;
    } else
      do {
        System.out.println("Wrong choice.. Plz input w, e, s or n for directions.");
        choice = scanner.nextLine();
      }
      while ((!choice.equalsIgnoreCase("w") && !choice.equalsIgnoreCase("e") && !choice.equalsIgnoreCase("s") && !choice.equalsIgnoreCase("n")));
      return choice;
  }

    public static void main (String[] args) {
    Adventure run = new Adventure();
    run.choice();
    }
  }

