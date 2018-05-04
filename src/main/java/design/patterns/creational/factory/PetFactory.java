package design.patterns.creational.factory;

public class PetFactory {
  public static Pet getPet(PetType petType) {
    switch (petType) {
      case Bark: return new Dog();
      case Meow: return new Cat();
      default: return null;
    }
  }
}
