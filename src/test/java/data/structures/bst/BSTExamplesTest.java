package data.structures.bst;

import org.junit.Test;
import utilities.TreeNode;

import static org.junit.Assert.*;

/**
 * Created by abhay on 27/07/17.
 */
public class BSTExamplesTest {
  @Test
  public void closetElement() throws Exception {
    assertEquals(8, new BSTExamples().closetElement(createBST(), 8, Integer.MAX_VALUE, Integer.MAX_VALUE));
    assertEquals(17, new BSTExamples().closetElement(createBST(), 18, Integer.MAX_VALUE, Integer.MAX_VALUE));
    assertEquals(9, new BSTExamples().closetElement(createBST(), 12, Integer.MAX_VALUE, Integer.MAX_VALUE));
  }

  @Test
  public void minValueNode() throws Exception {
    assertEquals(4, new BSTExamples().minValueNode(createBST()).data);

  }

  private TreeNode createBST() {
    TreeNode root = new TreeNode(9);
    root.left = new TreeNode(8);
    root.right = new TreeNode(17);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(12);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);
    root.right.right = new TreeNode(22);
    root.right.right.left = new TreeNode(20);

    return root;
  }

}