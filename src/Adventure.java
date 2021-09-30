import java.util.Objects;
import java.util.Scanner;

public class Adventure {

  Room currentRoom; // Rum 1-9.

  public String choice(){
    Scanner scanner = new Scanner(System.in);
    String choice;
    do {
    System.out.println("Wrong choice.. Plz input w, e, s or n for directions.");
    choice = scanner.nextLine();
}
while (!Objects.equals(choice, "w") || !Objects.equals(choice, "e") || !Objects.equals(choice, "s") || !Objects.equals(choice, "n"));
    return choice;
  }

    public static void main (String[] args) {
    Adventure gg = new Adventure();
    gg.choice();
    }
  }

