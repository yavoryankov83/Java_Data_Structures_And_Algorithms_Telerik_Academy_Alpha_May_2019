package city_person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    HashMap<City, List<Person>> result = new HashMap<>();
    City sofia = new City("Sofia", "Bulgaria", "11111");
    City london = new City("London", "Great Britan", "f9f8fjrj");
    City barcelona = new City("Barcelona", "Spain", "vevevbe44");
    City belgrad = new City("Barcelona", "Aerbia", "fffffffff");

    Person ivan = new Person("Ivan", "Ivanov");
    Person joro = new Person("Joro", "Jorov");
    Person tosko = new Person("Toshko", "Toshkov");

    Comparator<City> comparatorByName = Comparator.comparing(City::getName);
    Comparator<City> comparatorByCountryName = Comparator.comparing(City::getCountryName);


    if (!result.containsKey(sofia)) {
      result.put(sofia, new ArrayList<>());
    }
    result.get(sofia).add(ivan);

    if (!result.containsKey(london)) {
      result.put(london, new ArrayList<>());
    }
    result.get(london).add(joro);

    if (!result.containsKey(barcelona)) {
      result.put(barcelona, new ArrayList<>());
    }
    result.get(barcelona).add(tosko);

    if (!result.containsKey(belgrad)) {
      result.put(belgrad, new ArrayList<>());
    }
    result.get(belgrad).add(tosko);

    for (City city : result.keySet()
            .stream()
            .sorted(comparatorByName.thenComparing(comparatorByCountryName))
            .collect(Collectors.toList())) {
      System.out.println(String.format("%s - %s", city, result.get(city)));
    }
  }
}
