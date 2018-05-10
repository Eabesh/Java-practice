package design.patterns.structural.adapter;

public class AdapterExample {
  public static void main(String[] args) {
      RedmiNote redmiNote = new RedmiNote();
      AndroidCharger redmiCharger = new AndroidCharger();
      redmiCharger.charge(redmiNote);

      IPhoneCharger iPhoneCharger = new IPhoneCharger();
      AndroidToIPhoneAdapter adapter = new AndroidToIPhoneAdapter(redmiNote);
      iPhoneCharger.charge(adapter);

  }
}
