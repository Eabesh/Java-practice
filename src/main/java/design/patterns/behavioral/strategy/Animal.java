package design.patterns.behavioral.strategy;

class Animal {

  Flys flyingType;

  String tryToFly() {
    return flyingType.fly();
  }

  void setFlyingType(Flys flyingType) {
    this.flyingType = flyingType;
  }

}
