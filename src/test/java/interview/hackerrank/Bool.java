package interview.hackerrank;

public class Bool {
  static class A1 {
    public int i;
    protected int j;

  }

  static class B2 extends A1 {
    int j;

    void display() {
      super.i = 3;
      super.i = 10;
      System.out.println(i + " " + j);

    }
  }

  public static void main(String[] args) {
    //
    B2 obj = new B2();
    obj.i = 1;
    obj.j = 2;
    obj.display();
  }
}
