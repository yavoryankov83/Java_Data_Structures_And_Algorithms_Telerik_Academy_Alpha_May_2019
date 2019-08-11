package order_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderSystem1 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(reader.readLine());

    List<Wish> list = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

    int counter = 0;
    while (counter < count) {
      counter++;
      String line = reader.readLine();
      String[] tokens = line.split(" ");
      String command = tokens[0];

      switch (command) {
        case "AddWish":
          String[] detailedTokens = line.split(";");
          String wishName = detailedTokens[0].substring(8);
          double price = Double.parseDouble(detailedTokens[1]);
          String childName = detailedTokens[2];
          Wish wish = new Wish(wishName, price, childName);

          list.add(wish);
          builder
                  .append("Wish added")
                  .append(System.lineSeparator());
          break;

        case "DeleteWishes":
          String childName1 = line.substring(13);

          boolean isEmpty = list.stream().noneMatch(wish1 -> wish1.getChildName().equals(childName1));
          if (isEmpty) {
            builder
                    .append("No Wishes found")
                    .append(System.lineSeparator());
            break;
          }
          int initialSize = list.size();
          list = list
                  .stream()
                  .filter(wish1 -> !wish1.getChildName()
                          .equals(childName1))
                  .collect(Collectors.toList());

          builder
                  .append(String.format("%d Wishes deleted", initialSize - list.size()))
                  .append(System.lineSeparator());
          break;

        case "FindWishesByPriceRange":
          String[] detailedTokens1 = tokens[1].split(";");
          double priceFrom = Double.parseDouble(detailedTokens1[0]);
          double priceTo = Double.parseDouble(detailedTokens1[1]);

          List<Wish> wishesInRange = list
                  .stream()
                  .filter(wish1 -> wish1.getPrice() >= priceFrom && wish1.getPrice() <= priceTo)
                  .sorted()
                  .collect(Collectors.toList());

          if (wishesInRange.isEmpty()) {
            builder
                    .append("No Wishes found")
                    .append(System.lineSeparator());
            break;
          }

          wishesInRange
                  .forEach(wish1 -> builder
                          .append(wish1)
                          .append(System.lineSeparator()));
          break;

        case "FindWishesByChild":
          String childName2 = tokens[1];
          boolean noWishes = list.stream().noneMatch(wish1 -> wish1.getChildName().equals(childName2));
          if (noWishes) {
            builder
                    .append("No Wishes found")
                    .append(System.lineSeparator());
            break;
          }
          list
                  .stream()
                  .filter(wish1 -> wish1.getChildName()
                          .equals(childName2))
                  .sorted()
                  .forEach(wish1 -> builder.append(wish1).append(System.lineSeparator()));
          break;
      }
    }
    System.out.println(builder.toString());
  }

  private static class Wish implements Comparable<Wish> {
    private String wishName;
    private double price;
    private String childName;

    Wish(String wishName, double price, String childName) {
      this.wishName = wishName;
      this.price = price;
      this.childName = childName;
    }

    double getPrice() {
      return price;
    }

    String getChildName() {
      return childName;
    }

    @Override
    public int compareTo(Wish wish) {
      int result = wishName.compareTo(wish.wishName);
      if (result != 0) {
        return result;
      }
      result = childName.compareTo(wish.childName);
      if (result != 0) {
        return result;
      }

      result = Double.compare(price, wish.price);

      return result;
    }

    @Override
    public String toString() {
      return String.format("{%s;%s;%.2f}", wishName, childName, price);
    }
  }
}
