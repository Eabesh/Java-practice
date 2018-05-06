package design.patterns.creational.abstractfactory.phoneabstractfactory;

public interface OSFactory {
    Phone create(ManufacturerType manufacturerType);
}
