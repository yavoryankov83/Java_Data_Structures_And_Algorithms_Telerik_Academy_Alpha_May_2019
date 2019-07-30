package city_person;

import java.util.Objects;

public class City implements Comparable<City> {
  private String name;
  private String countryName;
  private String postalCode;

  City(String name, String countryName, String postalCode) {
    this.name = name;
    this.countryName = countryName;
    this.postalCode = postalCode;
  }

  String getName() {
    return name;
  }

  String getCountryName() {
    return countryName;
  }

  @Override
  public int compareTo(City object) {
    if (name.compareTo(object.name) == 0) {
      return countryName.compareTo(object.countryName);
    }
    return name.compareTo(object.name);
  }

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
  public String toString() {
    return String.format("%s %s %s", name, countryName, postalCode);
  }
}
