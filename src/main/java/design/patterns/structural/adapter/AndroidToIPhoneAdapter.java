package design.patterns.structural.adapter;

public class AndroidToIPhoneAdapter implements IPhone{
  AndroidPhone androidPhone;

  public AndroidToIPhoneAdapter(AndroidPhone androidPhone) {
    this.androidPhone = androidPhone;
  }

  @Override
  public void charge() {
    androidPhone.charge();
  }
}
