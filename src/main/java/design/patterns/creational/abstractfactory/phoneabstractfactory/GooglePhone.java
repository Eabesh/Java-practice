package design.patterns.creational.abstractfactory.phoneabstractfactory;

public class GooglePhone implements Phone {

  @Override
  public void display() {
    System.out.println("Google Pixel");
  }
}
