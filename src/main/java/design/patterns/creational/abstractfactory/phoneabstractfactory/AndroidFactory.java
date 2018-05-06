package design.patterns.creational.abstractfactory.phoneabstractfactory;

public class AndroidFactory implements OSFactory {

  @Override
  public Phone create(ManufacturerType manufacturerType) {
    switch (manufacturerType) {
      case GOOGLE: return new GooglePhone();
      case LENOVO: return new LenovePhone();
      default:return null;
    }
  }
}
