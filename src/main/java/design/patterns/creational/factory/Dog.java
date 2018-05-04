package design.patterns.creational.factory;

public class Dog implements Pet {

  @Override
  public String speak() {
    return "Bark bark...";
  }
}
