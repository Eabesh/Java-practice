package design.patterns.behavioral.strategy;

class Bird extends Animal {

  Bird() {
    flyingType = new ItFlys();
  }

}
