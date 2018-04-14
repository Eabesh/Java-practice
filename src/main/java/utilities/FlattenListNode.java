package utilities;

public class FlattenListNode {
  public int data;
  public FlattenListNode next, down;

  public FlattenListNode(int data) {
    this.data = data;
    this.next = this.down = null;
  }
}
