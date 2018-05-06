package design.patterns.creational.abstractfactory;

public class WonderLandFactory {

  public static Animal createAnimal(FactoryType factoryType) {
    switch (factoryType) {
      case Sea: return new SeaFactory().createAnimal();
      case Land: return new LandFactory().createAnimal();
      default: return null;
    }
  }

}
