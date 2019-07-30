package garage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Garage {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder builder = new StringBuilder();

    Map<String, Car> carsByBrandModel = new HashMap<>();
    Set<Car> carsSortedByHorsepowerAndBrandModel = new TreeSet<>();
    Map<String, Set<Car>> carsByType = new HashMap<>();

    String line;
    while (!"end".equals(line = reader.readLine())) {
      stringTokenizer = new StringTokenizer(line, " ", false);
      String command = stringTokenizer.nextToken();
      String brandModel;
      String type;
      int counter;

      switch (command) {
        case "add":
          brandModel = stringTokenizer.nextToken();
          type = stringTokenizer.nextToken();
          int horsepower = Integer.parseInt(stringTokenizer.nextToken());
          Car car = new Car(brandModel, type, horsepower);

          if (carsByBrandModel.containsKey(brandModel)) {
            builder.append(String.format("FAIL: %s already exists!%n", car.brandModel));
          } else {
            carsByBrandModel.put(brandModel, car);
            carsSortedByHorsepowerAndBrandModel.add(car);
            if (!carsByType.containsKey(car.type)) {
              carsByType.put(car.type, new TreeSet<>());
            }
            carsByType.get(car.type).add(car);

            builder.append(String.format("SUCCESS: %s added!%n", car.brandModel));
          }
          break;

        case "power":
          int numOfCars = Integer.parseInt(stringTokenizer.nextToken());
          builder.append("RESULT: ");

          counter = 0;
          for (Car sortedByHorsepowerAndBrandModelCar : carsSortedByHorsepowerAndBrandModel) {
            builder.append(sortedByHorsepowerAndBrandModelCar).append(", ");
            counter++;
            if (counter == numOfCars) {
              break;
            }
          }
          if ((builder.substring(builder.length() - 2).equals(", "))) {
            builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
          }
          builder.append(System.lineSeparator());
          break;

        case "find":
          type = stringTokenizer.nextToken();
          builder.append("RESULT: ");

          if (!carsByType.containsKey(type)) {
            builder.append(System.lineSeparator());
            break;
          }

          counter = 0;
          Set<Car> carsByTypeToFind = carsByType.get(type);
          for (Car currentCar : carsByTypeToFind) {
            builder.append(currentCar).append(", ");
            counter++;
            if (counter == 10) {
              break;
            }
          }
          if ((builder.substring(builder.length() - 2).equals(", "))) {
            builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
          }
          builder.append(System.lineSeparator());
          break;

        case "remove":
          brandModel = stringTokenizer.nextToken();

          if (!carsByBrandModel.containsKey(brandModel)) {
            builder.append(String.format("FAIL: %s could not be found!%n", brandModel));
          } else {
            Car currentCar = carsByBrandModel.get(brandModel);
            carsByBrandModel.remove(brandModel);
            carsSortedByHorsepowerAndBrandModel.remove(currentCar);
            carsByType.get(currentCar.type).remove(currentCar);
            builder.append(String.format("SUCCESS: %s removed!%n", brandModel));
          }
          break;
      }
    }
    System.out.println(builder);
  }

  private static class Car implements Comparable<Car> {
    private String brandModel;
    private String type;
    private int horsepower;

    Car(String brandModel, String type, int horsepower) {
      this.brandModel = brandModel;
      this.type = type;
      this.horsepower = horsepower;
    }

    @Override
    public int compareTo(Car object) {
      if (horsepower == object.horsepower) {
        return brandModel.compareTo(object.brandModel);
      } else {
        return Integer.compare(object.horsepower, horsepower);
      }
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (object == null || getClass() != object.getClass()) {
        return false;
      }
      Car car = (Car) object;
      return brandModel.equals(car.brandModel)
              && type.equals(car.type)
              && horsepower == car.horsepower;
    }

    @Override
    public int hashCode() {
      return Objects.hash(brandModel, type, horsepower);
    }

    @Override
    public String toString() {
      return String.format("%s[%s](%d)", brandModel, type, horsepower);
    }
  }
}

