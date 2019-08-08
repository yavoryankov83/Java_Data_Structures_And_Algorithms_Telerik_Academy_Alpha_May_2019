package inventory_manager;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class InventoryManager1 {
  static class Product implements Comparable {
    public String name;
    public String type;
    public double price;

    Product(String name, String type, double price) {
      this.name = name;
      this.type = type;
      this.price = price;
    }

    @Override
    public int compareTo(Object o) {
      Product p = (Product) o;

      int byPrice = Double.compare(price, p.price);
      if (byPrice != 0) {
        return byPrice;
      }
      int byName = name.compareTo(p.name);
      if (byName != 0) {
        return byName;
      }
      return type.compareTo(p.type);
    }
  }

  private static HashMap<String, Product> products = new HashMap<>();
  private static HashMap<String, TreeSet<Product>> productsByType = new HashMap<>();
  private static TreeSet<Product> productsSorted = new TreeSet<>();

  private static StringBuilder output = new StringBuilder();

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);

    while (true) {
      String nextLine = in.nextLine();
      String[] command = nextLine.split(" ");

      switch (command[0]) {
        case "add":
          addProduct(command[1], Double.parseDouble(command[2]), command[3]);
          break;
        case "filter":
          if (command[2].equals("type")) {
            filterByType(command[3]);
          } else if (command[3].equals("from")) {
            if (command.length == 7) {
              filterFromTo(Double.parseDouble(command[4]), Double.parseDouble(command[6]));
            } else {
              filterFrom(Double.parseDouble(command[4]));
            }
          } else {
            filterTo(Double.parseDouble(command[4]));
          }
          break;
        case "end":
          System.out.println(output);
          return;
      }
    }
  }

  private static void addProduct(String name, double price, String type) {
    if (products.containsKey(name)) {
      output.append(String.format("Error: Product %s already exists\n", name));
      return;
    }

    Product p = new Product(name, type, price);
    products.put(name, p);

    if (!productsByType.containsKey(type)) {
      productsByType.put(type, new TreeSet<>());
    }
    TreeSet<Product> bucket = productsByType.get(type);
    bucket.add(p);

    productsSorted.add(p);

    output.append(String.format("Ok: Product %s added successfully\n", name));
  }

  private static void filterByType(String type) {
    if (productsByType.containsKey(type)) {
      List<Product> filteredProducts = productsByType.get(type)
              .stream()
              .limit(10)
              .collect(Collectors.toList());
      print(filteredProducts);
    } else {
      output.append(String.format("Error: Type %s does not exists\n", type));
    }
  }

  private static void filterFromTo(double from, double to) {
    List<Product> filteredProducts = productsSorted.stream().collect(Collectors.toList());
    List<Product> result = new ArrayList<>();

    int limit = 10;
    for (Product p : filteredProducts) {
      if (p.price < from) {
        continue;
      }
      if (limit == 0 || p.price > to) {
        break;
      }
      result.add(p);
      limit--;
    }
    print(result);
  }

  private static void filterFrom(double from) {
    List<Product> filteredProducts = productsSorted.stream().collect(Collectors.toList());
    List<Product> result = new ArrayList<>();

    int limit = 10;
    for (Product p : filteredProducts) {
      if (p.price < from) {
        continue;
      }
      if (limit == 0) {
        break;
      }
      result.add(p);
      limit--;
    }
    print(result);
  }

  private static void filterTo(double to) {
    List<Product> filteredProducts = productsSorted.stream().collect(Collectors.toList());
    List<Product> result = new ArrayList<>();

    int limit = 10;
    for (Product p : filteredProducts) {
      if (limit == 0 || p.price > to) {
        break;
      }
      result.add(p);
      limit--;
    }
    print(result);
  }

  private static void print(List<Product> productList) {
    DecimalFormat formatter = new DecimalFormat("#.#########");
    output.append("Ok: ");
    if (productList.size() > 0) {
      Product p = productList.get(0);
      output.append(String.format("%s(%s)", p.name, formatter.format(p.price)));
      for (int i = 1; i < productList.size(); i++) {
        p = productList.get(i);
        output.append(String.format(", %s(%s)", p.name, formatter.format(p.price)));
      }
    }
    output.append("\n");
  }
}
