import java.util.*;
public abstract class Item {
  String name;
  String prefix;
  String suffix;

  public String getName() {
    return this.name;
  }
  public String getFullName(){
    return prefix + " " + name + " " + suffix;
  }
  public String toString() {
    return prefix + " " + name;
  }
  }

