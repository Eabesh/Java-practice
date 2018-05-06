package design.patterns.creational.abstractfactory.phoneabstractfactory;

public class MicroSoftPhone implements Phone {

  @Override
  public void display() {
    System.out.println("Microsoft phone");
  }
}
