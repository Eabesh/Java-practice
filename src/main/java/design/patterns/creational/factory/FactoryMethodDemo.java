package design.patterns.creational.factory;

public class FactoryMethodDemo {

  public static void main(String[] args) {
    Pet pet = PetFactory.getPet(PetType.Meow);
    System.out.println(pet.speak());
  }
}
