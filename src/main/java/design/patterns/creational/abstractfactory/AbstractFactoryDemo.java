package design.patterns.creational.abstractfactory;

public class AbstractFactoryDemo {
  public static void main(String[] args) {
    Animal animal  = WonderLandFactory.createAnimal(FactoryType.Land);
//    Animal animal = new Man();
    System.out.println(    animal.breath());

  }
}
