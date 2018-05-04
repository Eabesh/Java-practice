package design.patterns.creational.factory;

public class Cat implements Pet {
  @Override
  public String speak() {
    return "Meow meow ...";
  }
}
