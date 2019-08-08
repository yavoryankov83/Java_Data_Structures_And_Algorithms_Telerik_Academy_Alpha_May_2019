package override_equals_hashcode_compareTo;

import java.util.Objects;

public class Main {
  public static void main(String[] args) {
    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (object == null || getClass() != object.getClass()) {
        return false;
      }
      City city = (City) object;
      return name.equals(city.name)
              && countryName.equals(city.countryName)
              && postalCode.equals(city.postalCode);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, countryName, postalCode);
    }

    @Override
    public int compareTo(City object) {
      if (name.compareTo(object.name) == 0) {
        return countryName.compareTo(object.countryName);
      }
      return name.compareTo(object.name);
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
  }
}
