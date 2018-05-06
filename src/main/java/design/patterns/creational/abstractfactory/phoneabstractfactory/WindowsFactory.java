package design.patterns.creational.abstractfactory.phoneabstractfactory;

public class WindowsFactory implements OSFactory {

  @Override
  public Phone create(ManufacturerType manufacturerType) {
    switch (manufacturerType) {
      case MICROSOFT: return new MicroSoftPhone();
      default:return null;
    }
  }
}
