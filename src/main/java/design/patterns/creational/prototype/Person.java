package design.patterns.creational.prototype;

public abstract class Person implements Cloneable{

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
