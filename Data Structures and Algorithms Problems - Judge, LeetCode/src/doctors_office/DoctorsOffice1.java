package doctors_office;

import java.util.*;

public class DoctorsOffice1 {
  private static ArrayList<String> people = new ArrayList<>();
  private static Map<String, Integer> numberOfPeopleByNames = new HashMap<>();

  private static StringBuilder output = new StringBuilder();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      String[] command = scanner.nextLine().split(" ");
      switch (command[0]) {
        case "Append":
          appendPerson(command[1]);
          break;
        case "Serve":
          servePeople(Integer.parseInt(command[1]));
          break;
        case "Find":
          findPerson(command[1]);
          break;
        case "Insert":
          insertPerson(command);
          break;
        default:
          System.out.println(output);
          return;
      }
    }
  }

  private static void appendPerson(String name) {
    people.add(name);

    if (!numberOfPeopleByNames.containsKey(name)) {
      numberOfPeopleByNames.put(name, 0);
    }
    numberOfPeopleByNames.put(name, numberOfPeopleByNames.get(name) + 1);

    output.append("OK\n");
  }

  private static void servePeople(int size) {
    if (people.size() < size) {
      output.append("Error\n");
      return;
    }

    ArrayList<String> removedPeople = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      String person = people.remove(0);
      removedPeople.add(person);

      numberOfPeopleByNames.put(person, numberOfPeopleByNames.get(person) - 1);
      if (numberOfPeopleByNames.get(person) < 1) {
        numberOfPeopleByNames.remove(person);
      }
    }

    output.append(String.join(" ", removedPeople));
    output.append("\n");
  }

  private static void findPerson(String name) {
    if (numberOfPeopleByNames.containsKey(name)) {
      output.append(String.format("%d\n", numberOfPeopleByNames.get(name)));
    } else {
      output.append("0\n");
    }
  }

  private static void insertPerson(String[] command) {
    int index = Integer.parseInt(command[1]);
    if (index > people.size()) {
      output.append("Error\n");
      return;
    }

    String name = command[2];
    people.add(index, name);

    if (!numberOfPeopleByNames.containsKey(name)) {
      numberOfPeopleByNames.put(name, 0);
    }
    numberOfPeopleByNames.put(name, numberOfPeopleByNames.get(name) + 1);

    output.append("OK\n");
  }
}
