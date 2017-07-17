package design.patterns.behavioral.strategy;

public class CantFly implements Flys {

  @Override
  public String fly() {
    return "Cant fly !";
  }

}
