package design.patterns.creational.prototype;

public class PrototypeDemo {
  public static void main(String[] args) throws CloneNotSupportedException {
    System.out.println(PrototypeFactory.getPrototype("Tom"));
    System.out.println(PrototypeFactory.getPrototype("Harry"));
    System.out.println(PrototypeFactory.getPrototype("Dick"));
  }
}
