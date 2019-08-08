package inventory_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class InventoryManager {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder builder = new StringBuilder();

    Map<String, Item> itemByName = new HashMap<>();
    Set<Item> sortedItems = new TreeSet<>();
    Map<String, Set<Item>> itemsByType = new HashMap<>();

    String line;
    while (!"end".equals(line = reader.readLine())) {
      stringTokenizer = new StringTokenizer(line, " ", false);
      String command;
      String currentLine = stringTokenizer.nextToken();
      int count = stringTokenizer.countTokens();

      if ("add".equals(currentLine)) {
        command = "add";
      } else if ("filter".equals(currentLine) && count == 3) {
        command = "filter by type";
      } else if ("filter".equals(currentLine) && count == 6) {
        command = "filter by price from to";
      } else {
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        String toOrFor = stringTokenizer.nextToken();
        if (toOrFor.equals("from")) {
          command = "filter by price from";
        } else {
          command = "filter by price to";
        }
      }

      String type;
      double minPrice;
      double maxPrice;

      switch (command) {
        case "add":
          String name = stringTokenizer.nextToken();
          if (itemByName.containsKey(name)) {
            builder.append(String.format("Error: Item %s already exists%n", name));
            break;
          }

          double price = Double.parseDouble(stringTokenizer.nextToken());
          type = stringTokenizer.nextToken();
          Item item = new Item(name, price, type);

          itemByName.put(name, item);
          sortedItems.add(item);
          if (!itemsByType.containsKey(type)) {
            itemsByType.put(type, new TreeSet<>());
          }
          itemsByType.get(type).add(item);

          builder.append(String.format("Ok: Item %s added successfully%n", name));
          break;

        case "filter by type":
          stringTokenizer.nextToken();
          stringTokenizer.nextToken();
          type = stringTokenizer.nextToken();

          if (!itemsByType.containsKey(type)) {
            builder.append(String.format("Error: Type %s does not exists%n", type));
            break;
          }
          builder.append("Ok: ");
          itemsByType.get(type)
                  .stream()
                  .limit(10)
                  .forEach(item1 -> builder.append(item1).append(", "));
          builder.setLength(builder.length() - 2);
          builder.append(System.lineSeparator());
          break;

        case "filter by price from to":
          stringTokenizer.nextToken();
          stringTokenizer.nextToken();
          stringTokenizer.nextToken();
          minPrice = Double.parseDouble(stringTokenizer.nextToken());
          stringTokenizer.nextToken();
          maxPrice = Double.parseDouble(stringTokenizer.nextToken());

          builder.append("Ok: ");

          sortedItems
                  .stream()
                  .filter(item1 -> item1.price < maxPrice && item1.price > minPrice)
                  .limit(10)
                  .forEach(item1 -> builder.append(item1).append(", "));
          if (builder.charAt(builder.length() - 2) == ',') {
            builder.setLength(builder.length() - 2);
          }
          builder.append(System.lineSeparator());
          break;

        case "filter by price from":
          minPrice = Double.parseDouble(stringTokenizer.nextToken());
          builder.append("Ok: ");

          sortedItems
                  .stream()
                  .filter(item1 -> item1.price > minPrice)
                  .limit(10)
                  .forEach(item1 -> builder.append(item1).append(", "));
          if (builder.charAt(builder.length() - 2) == ',') {
            builder.setLength(builder.length() - 2);
          }
          builder.append(System.lineSeparator());
          break;

        case "filter by price to":
          maxPrice = Double.parseDouble(stringTokenizer.nextToken());
          builder.append("Ok: ");

          sortedItems
                  .stream()
                  .filter(item1 -> item1.price < maxPrice)
                  .limit(10)
                  .forEach(item1 -> builder.append(item1).append(", "));
          if (builder.charAt(builder.length() - 2) == ',') {
            builder.setLength(builder.length() - 2);
          }
          builder.append(System.lineSeparator());
          break;
      }
    }
    System.out.println(builder);
  }

  static class Item implements Comparable<Item> {
    private String name;
    private double price;
    private String type;

    Item(String name, double price, String type) {
      this.name = name;
      this.price = price;
      this.type = type;
    }

    @Override
    public int compareTo(Item item) {
      int result = Double.compare(price, item.price);

      if (result != 0) {
        return result;
      }

      result = name.compareTo(item.name);
      if (result != 0) {
        return result;
      }

      result = type.compareTo(item.type);
      return result;
    }

    @Override
    public String toString() {
      String pattern = "#####.#####";
      DecimalFormat decimalFormat = new DecimalFormat(pattern);
      String formattedPrice = decimalFormat.format(price);
      return String.format("%s(%s)", name, formattedPrice);
    }
  }
}
