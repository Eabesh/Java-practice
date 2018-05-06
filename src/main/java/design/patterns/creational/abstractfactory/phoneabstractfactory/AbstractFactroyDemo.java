package design.patterns.creational.abstractfactory.phoneabstractfactory;

public class AbstractFactroyDemo {
  public static void main(String[] args) {
    OSFactory factory = AbstractPhoneFactory.getFactory(OSType.ANDROID);
    Phone phone = factory.create(ManufacturerType.GOOGLE);
    phone.display();

    OSFactory factory1 = AbstractPhoneFactory.getFactory(OSType.WINDOWS);
    Phone phone1 = factory1.create(ManufacturerType.MICROSOFT);
    phone1.display();

  }
}
