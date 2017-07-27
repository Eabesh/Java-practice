package data.structures.bst;

import org.junit.Test;
import utilities.TreeNode;

import static org.junit.Assert.*;

/**
 * Created by abhay on 27/07/17.
 */
public class BSTExamplesTest {
  @Test
  public void minValueNode() throws Exception {
    assertEquals(4, new BSTExamples().minValueNode(createBST()).data);

  }

  private TreeNode createBST() {
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(8);
    root.right = new TreeNode(22);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(12);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);
    return root;
  }

}