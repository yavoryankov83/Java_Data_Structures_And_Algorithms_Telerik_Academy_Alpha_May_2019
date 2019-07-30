package garage;

import java.util.Objects;

public class Car implements Comparable<Car> {
  private String brandModel;
  private String type;
  private int horsepower;

  Car(String brandModel, String type, int horsepower) {
    this.brandModel = brandModel;
    this.type = type;
    this.horsepower = horsepower;
  }

  String getBrandModel() {
    return brandModel;
  }

  public String getType() {
    return type;
  }

  int getHorsepower() {
    return horsepower;
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
