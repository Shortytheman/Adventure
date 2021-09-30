import java.util.Scanner;

public class Adventure {

  Room currentRoom; // Rum 1-9.

  public String choice(){
    Scanner scanner = new Scanner(System.in);
    String choice;
    System.out.println("Make your choice\n________________________ \nDirections: go north, go south, go west and go east to travel in the desired direction.\nAsk for help: help\nTo look around: look");
    choice = scanner.nextLine();
    if (choice.equalsIgnoreCase("w") || choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("n")) {
      return choice;
    }else if(choice.equalsIgnoreCase("exit")) {
      exitGame();
    }
    else if(choice.equalsIgnoreCase("help")){
      help();
    }
    else if (choice.equalsIgnoreCase("look")){
      look(currentRoom);
    }
      do {
        System.out.println("Please enter one of the valid options");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("exit")) {
          exitGame();
        } else if (choice.equalsIgnoreCase("help")) {
          help();
        }
      }
      while ((!choice.equalsIgnoreCase("w") && !choice.equalsIgnoreCase("e") && !choice.equalsIgnoreCase("s") && !choice.equalsIgnoreCase("n")));
      return choice;
  }
  void look(Room room){
    this.currentRoom = room;
    System.out.println();
  }
  void help(){
    System.out.println("\n\n( ಠ ͜ʖ ಠ ) Hello outcast it is i Merlin, the great wizard. You've asked for advice on your journey and i shall provide you with your options.\n\n( ಠ ͜ʖ ಠ )⊃══⛧⌒｡ ~ALAKAZAM~");
    System.out.println("________________________\nDirections \nTo go north: \"go north\" \nTo go south: \"go south\" \nTo go west: \"go west\" \nTo go east: \"go east\"");
    System.out.println("________________________\nTo look around: \"Look\"");
    System.out.println("________________________\nTo exit the game: \"Exit\"\n________________________");
  }
  void exitGame(){
    System.exit(0);
  }

    public static void main (String[] args) {
    Adventure run = new Adventure();
      System.out.println(run.choice());
    }
  }

