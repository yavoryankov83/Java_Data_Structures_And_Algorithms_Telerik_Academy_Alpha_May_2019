package gotta_catch_em_all;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder builder = new StringBuilder();

    List<Pokemon> list = new ArrayList<>();
    Map<String, Set<Pokemon>> byKeyTypeSorted = new HashMap<>();

    String line;
    String type;
    while (!"end".equals(line = reader.readLine())) {
      stringTokenizer = new StringTokenizer(line, " ", false);
      String command = stringTokenizer.nextToken();

      switch (command) {
        case "add":
          String name = stringTokenizer.nextToken();
          type = stringTokenizer.nextToken();
          int power = Integer.parseInt(stringTokenizer.nextToken());
          int position = Integer.parseInt(stringTokenizer.nextToken());

          builder.append(String.format("Added pokemon %s to position %d%n", name, position));

          Pokemon pokemon = new Pokemon(name, power);

          list.add(--position, pokemon);
          if (!byKeyTypeSorted.containsKey(type)) {
            byKeyTypeSorted.put(type, new TreeSet<>());
          }
          byKeyTypeSorted.get(type).add(pokemon);
          break;

        case "find":
          type = stringTokenizer.nextToken();
          builder.append(String.format("Type %s: ", type));

          if (byKeyTypeSorted.containsKey(type)) {
            Set<Pokemon> pokemonsByTypeToFind = byKeyTypeSorted.get(type);

            int limit = 0;
            for (Pokemon currentPokemon : pokemonsByTypeToFind) {
              builder.append(currentPokemon).append("; ");
              limit++;
              if (limit == 5) {
                break;
              }
            }
            if (builder.charAt(builder.length() - 2) == ';') {
              builder.setLength(builder.length() - 2);
            }
          }
          builder.append(System.lineSeparator());
          break;

        case "ranklist":
          int startPosition = Integer.parseInt(stringTokenizer.nextToken()) - 1;
          int endPosition = Integer.parseInt(stringTokenizer.nextToken()) - 1;

          for (int i = startPosition; i <= endPosition; i++) {
            builder.append(String.format("%d. %s; ", i + 1, list.get(i)));

          }
          if (builder.charAt(builder.length() - 2) == ';') {
            builder.setLength(builder.length() - 2);
          }
          builder.append(System.lineSeparator());
          break;
      }
    }
    System.out.println(builder);
  }

  static class Pokemon implements Comparable<Pokemon> {
    private String name;
    private int power;

    Pokemon(String name, int power) {
      this.name = name;
      this.power = power;
    }

    @Override
    public int compareTo(Pokemon pokemon) {
      if (name.compareTo(pokemon.name) == 0) {
        return pokemon.power - power;
      }
      return name.compareTo(pokemon.name);
    }

    @Override
    public String toString() {
      return String.format("%s(%d)", name, power);
    }
  }
}
