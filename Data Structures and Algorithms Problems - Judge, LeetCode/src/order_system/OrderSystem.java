package order_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class OrderSystem {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Wish> listOfWishes = new ArrayList<>();
    Map<String, List<Wish>> mapOfWishesByKeyChildName = new HashMap<>();
    StringBuilder output = new StringBuilder();

    int countOfInputLines = Integer.parseInt(reader.readLine());
    int counter = 0;
    while (counter < countOfInputLines) {
      counter++;

      String inputLine = reader.readLine();
      String[] tokens = inputLine.split(" ");
      String command = tokens[0];

      String childName;
      String[] detailedTokens;
      switch (command) {
        case "AddWish":
          detailedTokens = inputLine.split(";");

          String wishName = detailedTokens[0].substring(8);
          double price = Double.parseDouble(detailedTokens[1]);
          childName = detailedTokens[2];

          Wish wish = new Wish(wishName, price, childName);

          listOfWishes.add(wish);
          if (!mapOfWishesByKeyChildName.containsKey(childName)) {
            mapOfWishesByKeyChildName.put(childName, new ArrayList<>());
          }
          mapOfWishesByKeyChildName.get(childName).add(wish);

          output.append("Wish added")
                  .append(System
                          .lineSeparator());
          break;

        case "DeleteWishes":
          childName = inputLine.substring(13);

          if (!mapOfWishesByKeyChildName.containsKey(childName)) {
            output
                    .append("No Wishes found")
                    .append(System.lineSeparator());
            break;
          }
          int wishesCount = mapOfWishesByKeyChildName.get(childName).size();

          mapOfWishesByKeyChildName.remove(childName);
          listOfWishes = listOfWishes
                  .stream()
                  .filter(wish1 -> !wish1.childName.equals(childName))
                  .collect(Collectors.toList());
          output
                  .append(String.format("%d Wishes deleted", wishesCount))
                  .append(System.lineSeparator());
          break;

        case "FindWishesByPriceRange":
          detailedTokens = tokens[1].split(";");
          double priceFrom = Double.parseDouble(detailedTokens[0]);
          double priceTo = Double.parseDouble(detailedTokens[1]);

          List<Wish> wishesInRange = listOfWishes
                  .stream()
                  .filter(wish1 -> wish1.getPrice() >= priceFrom && wish1.getPrice() <= priceTo)
                  .collect(Collectors.toList());

          if (wishesInRange.isEmpty()) {
            output
                    .append("No Wishes found")
                    .append(System.lineSeparator());
            break;
          }
          wishesInRange
                  .stream()
                  .sorted(Comparator
                          .comparing(Wish::getWishName)
                          .thenComparing(Wish::getChildName))
                  .forEach(wish1 -> output
                          .append(wish1)
                          .append(System.lineSeparator()));
          break;

        case "FindWishesByChild":
          childName = tokens[1];

          if (!mapOfWishesByKeyChildName.containsKey(childName)) {
            output
                    .append("No Wishes found")
                    .append(System.lineSeparator());
            break;
          }
          mapOfWishesByKeyChildName.get(childName)
                  .stream()
                  .sorted(Comparator
                          .comparing(Wish::getWishName))
                  .forEach(wish1 -> output
                          .append(wish1)
                          .append(System.lineSeparator()));
          break;
      }
    }
    System.out.println(output);
  }

  private static class Wish {
    private String wishName;
    private double price;
    private String childName;

    Wish(String wishName, double price, String childName) {
      this.wishName = wishName;
      this.price = price;
      this.childName = childName;
    }

    String getWishName() {
      return wishName;
    }

    double getPrice() {
      return price;
    }

    String getChildName() {
      return childName;
    }

    @Override
    public String toString() {
      return String.format("{%s;%s;%.2f}", wishName, childName, price);
    }
  }
}
