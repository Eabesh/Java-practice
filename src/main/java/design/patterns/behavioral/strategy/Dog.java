package design.patterns.behavioral.strategy;

class Dog extends Animal {

  Dog() {
    flyingType = new CantFly();
  }

}
