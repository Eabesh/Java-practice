package data.structures.bst;

import org.junit.Test;
import utilities.TreeNode;

import static org.junit.Assert.*;

/**
 * Created by abhay on 27/07/17.
 */
public class BSTExamplesTest {
  @Test
  public void maxValueNode() throws Exception {
    assertEquals(3, new BSTExamples().maxValueNode(createBST(), 1, 3));
  }

  @Test
  public void kSmallestSum() throws Exception {
    int[] k = {2};
    int[] sum = {0};
    assertEquals(9, new BSTExamples().kSmallestSum(createBST(), sum, k));
  }

  @Test
  public void kthLargestElement() throws Exception {
    int[] k = {2};
    assertEquals(4, new BSTExamples().kthLargestElement(createBST(), k));
    int[] k2 = {3};
    assertEquals(3, new BSTExamples().kthLargestElement(createBST(), k2));
  }

  @Test
  public void isBST() throws Exception {
    TreeNode[] childNode = {null};
    assertTrue(new BSTExamples().isBST(createBST(), childNode));
  }

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
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
//    root.left.right.left = new TreeNode(10);
//    root.left.right.right = new TreeNode(14);
//    root.right.right = new TreeNode(22);
//    root.right.right.left = new TreeNode(20);

    return root;
  }

}