package design.patterns.creational.prototype;

import java.util.HashMap;

public class PrototypeFactory {
  private static final HashMap<String, Person> prototypes = new HashMap<>();
  static {
    prototypes.put("Tom", new Tom());
    prototypes.put("Dick", new Dick());
    prototypes.put("Harry", new Harry());
  }

  public static Person getPrototype(String type) {
    try {
      return (Person) prototypes.get(type).clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
      return null;
    }
  }

}
