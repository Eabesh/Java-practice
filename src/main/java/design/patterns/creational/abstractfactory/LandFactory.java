package design.patterns.creational.abstractfactory;

public class LandFactory implements AnimalFactory {

  @Override
  public Animal createAnimal() {
    return new Man();
  }
}
