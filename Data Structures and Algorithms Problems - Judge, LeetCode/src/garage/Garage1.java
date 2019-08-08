package garage;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Garage1 {
  private static StringTokenizer stringTokenizer;

  static class Unit implements Comparable {
    String name, type;
    int attack;

    Unit(String name, String type, int attack) {
      this.name = name;
      this.type = type;
      this.attack = attack;
    }

    @Override
    public String toString() {
      return String.format("%s[%s](%s)", name, type, attack);
    }


    @Override
    public int compareTo(Object o) {
      Unit unit = (Unit) o;
      int attackCompare = Integer.compare(this.attack, unit.attack);
      if (attackCompare != 0) {
        return -attackCompare;
      }
      return this.name.compareTo(unit.name);
    }
  }

  private static HashMap<String, Unit> unitsMap = new HashMap<>();
  private static HashMap<String, TreeSet<Unit>> unitsOrderedByType = new HashMap<>();
  private static TreeSet<Unit> unitsOrdered = new TreeSet<>();

  private static StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    //fakeInput();
    Scanner in = new Scanner(System.in);

    while (true) {
      String nextLine = in.nextLine();
      String[] command = nextLine.split(" ");

      switch (command[0]) {
        case "add":
          addUnit(command);
          break;
        case "remove":
          removeUnit(command);
          break;
        case "find":
          findUnit(command);
          break;
        case "power":
          powerUnit(command);
          break;
        case "end":
          System.out.println(result);
          return;
      }
    }
  }

  private static void addUnit(String[] arguments) {
    if (unitsMap.containsKey(arguments[1])) {
      result.append(String.format("FAIL: %s already exists!\n", arguments[1]));
    } else {
      Unit newUnit = new Unit(arguments[1], arguments[2], Integer.parseInt(arguments[3]));
      unitsMap.put(arguments[1], newUnit);
      if (!unitsOrderedByType.containsKey(arguments[2])) {
        unitsOrderedByType.put(arguments[2], new TreeSet<>());
      }
      TreeSet<Unit> orderedUnitsBucket = unitsOrderedByType.get(arguments[2]);
      orderedUnitsBucket.add(newUnit);
      unitsOrdered.add(newUnit);
      result.append(String.format("SUCCESS: %s added!\n", arguments[1]));
    }
  }

  private static void removeUnit(String[] arguments) {
    if (!unitsMap.containsKey(arguments[1])) {
      result.append(String.format("FAIL: %s could not be found!\n", arguments[1]));
    } else {
      Unit unit = unitsMap.get(arguments[1]);
      unitsMap.remove(arguments[1]);
      unitsOrderedByType.get(unit.type).remove(unit);
      unitsOrdered.remove(unit);
      result.append(String.format("SUCCESS: %s removed!\n", arguments[1]));
    }
  }

  private static void findUnit(String[] arguments) {
    result.append("RESULT: ");
    if (unitsOrderedByType.containsKey(arguments[1])) {
      result.append(unitsOrderedByType.get(arguments[1]).stream()
              .limit(10)
              .map(x -> x.toString())
              .collect(Collectors.joining(", ")));
    }
    result.append("\n");
  }

  private static void powerUnit(String[] arguments) {
    result.append("RESULT: ");
    result.append(unitsOrdered.stream()
            .limit(Integer.parseInt(arguments[1]))
            .map(x -> x.toString())
            .collect(Collectors.joining(", ")));

    result.append("\n");
  }
}

