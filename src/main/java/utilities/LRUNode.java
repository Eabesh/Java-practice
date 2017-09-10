package utilities;

/**
 * Created by abhay on 09/09/17.
 */
public class LRUNode {
  public LRUNode prev, next;
  public int key, value;

  public LRUNode(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
