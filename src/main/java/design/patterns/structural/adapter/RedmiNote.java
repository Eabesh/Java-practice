package design.patterns.structural.adapter;

public class RedmiNote implements AndroidPhone{

  @Override
  public void charge() {
    System.out.println("Redmi is charging");
  }
}
