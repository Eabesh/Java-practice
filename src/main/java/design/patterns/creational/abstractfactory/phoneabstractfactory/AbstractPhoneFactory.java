package design.patterns.creational.abstractfactory.phoneabstractfactory;

public abstract class AbstractPhoneFactory {
    public static OSFactory getFactory(OSType osType) {
        switch (osType) {
            case ANDROID: return new AndroidFactory();
            case WINDOWS: return new WindowsFactory();
            default: return null;
        }

    }
}
