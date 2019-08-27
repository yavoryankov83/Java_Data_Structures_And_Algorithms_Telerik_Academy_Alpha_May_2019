package order_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OrderSystem2 {
  public static void main(String[] args) throws IOException {
    Locale.setDefault(new Locale("en", "US"));
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(input.readLine());
    List<Wish> wishes = new ArrayList<>(60000);
    Map<String, ArrayList<Wish>> sortedChild = new TreeMap<>();

    for (int i = 0; i < N; i++) {
      String command = input.readLine();
      String[] commandArr = command.split(" ");

      switch (commandArr[0]) {
        case "AddWish": {
          command = command.substring(8);
          String[] wishArr = command.split(";");
          String nameWish = wishArr[0];
          double price = Double.parseDouble(wishArr[1]);
          String child = wishArr[2];

          Wish wish = new Wish(nameWish, price, child);
          wishes.add(wish);
          if (!sortedChild.containsKey(child)) {
            sortedChild.put(child, new ArrayList<>());
          }
          sortedChild.get(child).add(wish);
          sb.append("Wish added").append(System.lineSeparator());

          break;
        }
        case "DeleteWishes": {
          String child = command.substring(13);
          if (sortedChild.containsKey(child) && sortedChild.get(child).size() != 0) {
            int count = sortedChild.get(child).size();
            wishes.removeAll(sortedChild.get(child));
            sortedChild.get(child).clear();
            sb.append(String.format("%d Wishes deleted%n", count));
          } else {
            sb.append("No Wishes found").append(System.lineSeparator());
          }
          break;
        }
        case "FindWishesByChild": {
          String child = command.substring(18);
          if (sortedChild.containsKey(child) && sortedChild.get(child).size() != 0) {
            List<Wish> wishesChild = sortedChild.get(child);
            Collections.sort(wishesChild);
            for (Wish wish : wishesChild) {
              sb.append(wish.print());
            }
          } else {
            sb.append("No Wishes found").append(System.lineSeparator());
          }
          break;
        }
        case "FindWishesByPriceRange": {
          String[] priceRange = commandArr[1].split(";");
          double priceFrom = Double.parseDouble(priceRange[0]);
          double priceTo = Double.parseDouble(priceRange[1]);
          ArrayList<Wish> sortedWishes = new ArrayList<>();
          for (Wish wish : wishes) {
            if (wish.getPrice() >= priceFrom && wish.getPrice() <= priceTo) {
              sortedWishes.add(wish);
            }
          }
          if (sortedWishes.size() == 0) {
            sb.append("No Wishes found").append(System.lineSeparator());
          } else {
            Collections.sort(sortedWishes);
            for (Wish wish : sortedWishes) {
              sb.append(wish.print());
            }
          }
          break;
        }

      }
    }
    System.out.print(sb.toString());
  }

  public static class Wish implements Comparable<Wish> {
    private String name;
    private double price;
    private String child;

    Wish(String name, double price, String child) {
      this.name = name;
      this.price = price;
      this.child = child;
    }

    String getName() {
      return name;
    }

    double getPrice() {
      return price;
    }

    String getChild() {
      return child;
    }

    String print() {
      return String.format("{%s;%s;%.2f}%n", this.name, this.child, this.price);
    }

    @Override
    public int compareTo(Wish o) {
      if (this.name.compareTo(o.name) != 0) {
        return this.name.compareTo(o.getName());
      } else if (this.child.compareTo(o.child) != 0) {
        return this.child.compareTo(o.getChild());
      }
      return Double.compare(this.price, o.getPrice());

    }

    @Override
    public boolean equals(Object obj) {
      Wish wish = (Wish) obj;
      return name.equals(wish.getName()) &&
              child.equals(wish.getChild()) && price == wish.getPrice();
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, child, price);
    }

  }
}