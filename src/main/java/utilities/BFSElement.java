package utilities;

/**
 * Created by abhay on 10/09/17.
 */
public class BFSElement {
  int val, distance;
  public BFSElement(int x, int d) {
    this.val = x;
    this.distance = d;
  }
  public int getVal() { return val;}
  public int getDistance() {return distance;}
}
