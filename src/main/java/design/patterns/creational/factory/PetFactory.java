package design.patterns.creational.factory;

public abstract class PetFactory {
  public static Pet getPet(PetType petType) {
    switch (petType) {
      case Bark: return new Dog();
      case Meow: return new Cat();
      default: return null;
    }
  }
}
