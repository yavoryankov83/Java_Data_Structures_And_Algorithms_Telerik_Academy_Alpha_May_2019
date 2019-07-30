package city_person;

import java.util.Objects;

public class Person {
  private String firstName;
  private String lastName;

  Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object){
      return true;
    }
    if (object == null || getClass() != object.getClass()){
      return false;
    }
    Person person = (Person) object;
    return firstName.equals(person.firstName) && lastName.equals(person.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return String.format("%s %s", firstName, lastName);
  }
}
