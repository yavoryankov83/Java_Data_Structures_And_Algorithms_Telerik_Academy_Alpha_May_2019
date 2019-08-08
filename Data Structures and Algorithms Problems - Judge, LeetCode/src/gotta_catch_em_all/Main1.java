package gotta_catch_em_all;

import java.util.*;
import java.util.stream.Collectors;

public class Main1 {
  static class Player implements Comparable<Player> {
    String name;
    String type;
    int age;

    Player(String name, String type, int age) {
      this.name = name;
      this.type = type;
      this.age = age;
    }

    @Override
    public String toString() {
      return String.format("%s(%d)", this.name, this.age);
    }

    @Override
    public int compareTo(Player p) {
      int result = this.name.compareTo(p.name);
      if (result == 0) {
        result = Integer.compare(p.age, this.age);
      }
      return result;
    }
  }

  private static ArrayList<Player> players = new ArrayList<>();
  private static HashMap<String, TreeSet<Player>> playersByType = new HashMap<>();

  private static StringBuilder result = new StringBuilder();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      String[] command = scanner.nextLine().split(" ");
      switch (command[0]) {
        case "add":
          addPlayer(command);
          break;
        case "find":
          findPlayer(command);
          break;
        case "ranklist":
          rankList(command);
          break;
        default:
          System.out.println(result);
          return;
      }
    }
  }

  private static void addPlayer(String[] command) {
    Player p = new Player(command[1], command[2], Integer.parseInt(command[3]));
    int position = Integer.parseInt(command[4]);

    players.add(position - 1, p);

    if (!playersByType.containsKey(command[2])) {
      playersByType.put(command[2], new TreeSet<>());
    }

    playersByType.get(command[2]).add(p);

    result.append(
            String.format("Added player %s to position %d\n",
                    command[1],
                    Integer.parseInt(command[4])));
  }

  private static void findPlayer(String[] command) {
    result.append(String.format("Type %s: ", command[1]));

    if (playersByType.containsKey(command[1])) {
      List<String> resultPlayers = playersByType.get(command[1]).stream()
              .limit(5)
              .map(Player::toString)
              .collect(Collectors.toList());

      result.append(String.join("; ", resultPlayers));
    }

    result.append("\n");
  }

  private static void rankList(String[] command) {
    int start = Integer.parseInt(command[1]) - 1;
    int end = Integer.parseInt(command[2]) - 1;

    List<String> rankedPlayers = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      rankedPlayers.add(String.format("%d. %s", i + 1, players.get(i)));
    }

    result.append(String.join("; ", rankedPlayers));
    result.append("\n");
  }
}
