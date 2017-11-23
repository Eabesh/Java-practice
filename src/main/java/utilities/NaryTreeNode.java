package utilities;

import java.util.ArrayList;

/**
 * Created by abhay on 12/10/17.
 */
public class NaryTreeNode {
  public int data;
  public ArrayList<NaryTreeNode> children;
  public NaryTreeNode(int data) {
    this.data = data;
    this.children = new ArrayList<>();
  }
}
