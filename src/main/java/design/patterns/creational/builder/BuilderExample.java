package design.patterns.creational.builder;

import design.patterns.creational.builder.Phone.Builder;

public class BuilderExample {
  public static void main(String[] args) {
    Phone.Builder builder = new Builder().backPanel("Black").frontPanel("White").camera("12 MP").processor("Snapdragon");
    Phone phone = builder.build();
    System.out.println(phone);
  }
}
