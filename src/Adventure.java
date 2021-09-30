import java.util.Scanner;

public class Adventure {

    Room currentRoom; // Rum 1-9.

    public String choice() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.print("Enter your direction, w for west, e for east, n for north and s for south: ");
        choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("go west") || choice.equalsIgnoreCase("go east") ||
                choice.equalsIgnoreCase("go south") || choice.equalsIgnoreCase("go north")) {
            return choice;
        } else
            do {
                System.out.println("Wrong choice.. Plz input w, e, s or n for directions.");
                choice = scanner.nextLine();
            }
            while ((!choice.equalsIgnoreCase("go west") && !choice.equalsIgnoreCase("go east") &&
                    !choice.equalsIgnoreCase("go south") && !choice.equalsIgnoreCase("go north")));
        return choice;
    }
    public String lookAround() {
        return currentRoom.description;
    }
    public void run() {
        // Kalde rummene noget andet senere og lave descriptions til rummene
        Room room1 = new Room("room1", "dette er rum 1");
        Room room2 = new Room("room2", "Dette er rum 2");
        Room room3 = new Room("room3", "Dette er rum 3");
        Room room4 = new Room("room4", "Dette er rum 4");
        Room room5 = new Room("room5", "Dette er rum 5");
        Room room6 = new Room("room6", "Dette er rum 6");
        Room room7 = new Room("room7", "Dette er rum 7");
        Room room8 = new Room("room8", "Dette er rum 8");
        Room room9 = new Room("room9", "Dette er rum 9");

        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room7.setNorth(room4);
        room7.setEast(room8);
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);
        room9.setNorth(room6);
        room9.setWest(room8);


    }



    public static void main(String[] args) {
        Adventure run = new Adventure();
        run.run();

    }
}

