import java.util.Arrays;

public class Adventure {

  int[][] rooms = {{1,2,3},{4,5,6},{7,8,9}};
  public String goNorth;
  public String goSouth;
  public String goEast;
  public String goWest;

  public void Rooms() {
    for(int i=0; i<rooms.length; i++) {
      for(int j=0; j<rooms[0].length; j++) {
        System.out.print(rooms[i][j] + " ");
      }
      System.out.println();
      }
    }
    
    public static void main (String[] args) {
      Adventure gg = new Adventure();
      gg.Rooms();
    }
  }

