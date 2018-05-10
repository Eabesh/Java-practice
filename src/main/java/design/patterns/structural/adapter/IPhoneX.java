package design.patterns.structural.adapter;

public class IPhoneX implements IPhone {

  @Override
  public void charge() {
    System.out.println("IPhoneX is charging");
  }
}
