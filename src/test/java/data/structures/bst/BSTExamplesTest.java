package data.structures.bst;
import data.structures.binarytrees.TreeExamples;
import org.junit.Test;
import utilities.TreeNode;
import static org.junit.Assert.*;

/**
 * Created by abhay on 27/07/17.
 */

public class BSTExamplesTest {
  @Test
  public void sortedArrayToBST() throws Exception {
    int[] array = {1, 5, 6};
    TreeNode root = new BSTExamples().sortedArrayToBST(array, 0, array.length - 1);
    new TreeExamples().inOrder(root);
  }

  @Test
  public void printSorted() throws Exception {
    int[] array = {5, 1, 10};
    new BSTExamples().printSorted(array, 0, array.length - 1);
  }

  @Test
  public void replace() throws Exception {
    int arr[] = { 8, 58, 71, 18, 31, 32, 63, 92,
            43, 3, 91, 93, 25, 80, 28 };
    new BSTExamples().replace(arr);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  @Test
  public void delete() throws Exception {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(60);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(35);
    new BSTExamples().delete(root, 35);
    new BSTExamples().delete(root, 50);
    new TreeExamples().inOrder(root);
  }

  @Test
  public void inorderPreSuccessor() throws Exception {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(60);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(35);
    new BSTExamples().inorderPreSuccessor(root, 40);
  }

  @Test
  public void inorderSucc() throws Exception {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(60);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(35);
    System.out.println(new BSTExamples().inorderSuccessor(root, 51).data);
  }

  @Test
  public void isTripletPresent() throws Exception {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(-110);
    root.left.left = new TreeNode(-120);
    root.right = new TreeNode(60);
    assertTrue(new BSTExamples().isTripletPresent(root));

  }

  @Test
  public void findPairs() throws Exception {

    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(60);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(35);
    root.right.right = new TreeNode(70);
    root.right.left = new TreeNode(55);

    new BSTExamples().findPair(root, 85);
    new BSTExamples().findPairs(root, 90);
  }

  @Test
  public void mergeTwoBST() throws Exception {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(60);
    TreeNode root1 = new TreeNode(5);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(6);
    TreeNode root3 = new BSTExamples().mergeTwoBST(root, root1);
    new TreeExamples().inOrder(root3);
  }

  @Test
  public void largestBST() throws Exception {
    TreeNode root1 = new TreeNode(5);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(4);
    root1.left.left = new TreeNode(1);
    root1.left.right = new TreeNode(3);

    assertEquals(3, new BSTExamples().largestBST(root1));

  }

  @Test
  public void largestBSTinBT() throws Exception {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(60);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(20);
    root.right.right = new TreeNode(70);
    root.right.left = new TreeNode(45);
    root.right.right.left = new TreeNode(65);
    root.right.right.right = new TreeNode(80);

    TreeNode root1 = new TreeNode(5);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(4);
    root1.left.left = new TreeNode(1);
    root1.left.right = new TreeNode(3);

    assertEquals(5, new BSTExamples().largestBSTinBT(root).bstSoFar);
    assertEquals(3, new BSTExamples().largestBSTinBT(root1).bstSoFar);
  }

  @Test
  public void countPairs() throws Exception {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(8);
    root.right.left = new TreeNode(6);

    TreeNode root1 = new TreeNode(10);
    root1.left = new TreeNode(6);
    root1.right = new TreeNode(15);
    root1.left.left = new TreeNode(3);
    root1.left.right = new TreeNode(8);
    root1.right.right = new TreeNode(18);
    root1.right.left = new TreeNode(11);
    assertEquals(3, new BSTExamples().countPairs(root, root1, 16));
  }

  @Test
  public void printPairs() throws Exception {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(8);
    root.right.left = new TreeNode(6);

    TreeNode root1 = new TreeNode(10);
    root1.left = new TreeNode(6);
    root1.right = new TreeNode(15);
    root1.left.left = new TreeNode(3);
    root1.left.right = new TreeNode(8);
    root1.right.right = new TreeNode(18);
    root1.right.left = new TreeNode(11);

    new BSTExamples().printPairs(root, root1, 16);
  }

  @Test
  public void removeLeafNodes() throws Exception {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(7);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(2);
    root.right.right = new TreeNode(13);
    root.right.left = new TreeNode(9);
    TreeNode r = new BSTExamples().removeLeafNodes(root);
    new TreeExamples().inOrder(r);
  }

  @Test
  public void secondLargest() throws Exception {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(7);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(2);
    root.right.right = new TreeNode(13);
    root.right.left = new TreeNode(9);
    assertEquals(10, new BSTExamples().secondLargest(root));
  }

  @Test
  public void isDeadEnd() throws Exception {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(7);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(2);
    root.right.right = new TreeNode(13);
    root.right.left = new TreeNode(9);
    assertTrue(new BSTExamples().isDeadEnd(root));
  }

  @Test
  public void printCommonNodes() throws Exception {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.left.right = new TreeNode(9);


    TreeNode root1 = new TreeNode(10);
    root1.left = new TreeNode(7);
    root1.right = new TreeNode(20);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(9);
    new BSTExamples().printCommonNodes(root, root1);
  }

  @Test
  public void findMedian() throws Exception {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(8);
    root.right = new TreeNode(50);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(40);
//    root.right.right = new TreeNode(100);

    assertEquals(10, new BSTExamples().findMedian(root));
  }


  @Test
  public void kthSmallestSpaceEff() throws Exception {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(50);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(40);
    root.right.right = new TreeNode(100);

    assertEquals(10, new BSTExamples().kthSmallestSpaceEff(root, 3));
  }

  @Test
  public void countBSTSubTree() throws Exception {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(50);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(40);
    root.right.right = new TreeNode(100);
    assertEquals(1, new BSTExamples().countBSTSubtree(root,1,45));
  }

  @Test
  public void greaterSumTree() throws Exception {
    TreeNode root = new TreeNode(11);
    root.left = new TreeNode(2);
    root.right = new TreeNode(29);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(7);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(40);
    root.right.right.left = new TreeNode(35);
    new BSTExamples().greaterSumTree(root);
    new TreeExamples().inOrder(root);
  }

  @Test
  public void addGreaterValues() throws Exception {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(70);
    root.left.left = new TreeNode(20);
    root.left.right = new TreeNode(40);
    root.right.left = new TreeNode(60);
    root.right.right = new TreeNode(80);
    new BSTExamples().addGreaterValues(root);
    new TreeExamples().inOrder(root);
  }

  @Test
  public void removeOutsideRange() throws Exception {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(-13);
    root.left.right = new TreeNode(-8);
    root.right = new TreeNode(14);
    root.right.left = new TreeNode(13);
    root.right.left.left = new TreeNode(7);
    root.right.right = new TreeNode(15);
    TreeNode newRoot = new BSTExamples().removeOutsideRange(root, -10, 13);
    new TreeExamples().inOrder(newRoot);
  }

  @Test
  public void convertBSTToBT() throws Exception {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(13);
    new BSTExamples().convertBSTToBT(root);
    new TreeExamples().inOrder(root);
  }

  @Test
  public void constructTreePre() throws Exception {
    int pre[] = {10, 5, 1, 7, 40, 50};

    TreeNode root = new BSTExamples().constructTreePre(pre);
    new TreeExamples().inOrder(root);
  }

  @Test
  public void hasOnlyChild() throws Exception {
    int pre[] = new int[]{8, 3, 5, 7, 6};
    assertTrue(new BSTExamples().hasOnlyChild(pre));
  }

  @Test
  public void correctBST() throws Exception {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(20);
    new BSTExamples().correctBST(root);
    new TreeExamples().inOrder(root);
  }

  @Test
  public void printKeysWithinRange() throws Exception {
    new BSTExamples().printKeysWithinRange(createBST(), 4, 5);
  }

  @Test
  public void kthSmallest() throws Exception {
    int[] k = {3};
    assertEquals(5, new BSTExamples().kthSmallest(createBST(), k));
  }

  @Test
  public void bstToMinHeap() throws Exception {
    assertEquals(2, new BSTExamples().bstToMinHeap(createBST()).data);
    assertEquals(4, new BSTExamples().bstToMinHeap(createBST()).left.data);

  }

  @Test
  public void isContainedSeq() throws Exception {
    int[] seq = {1, 2, 3}, index = {0};

    assertFalse(new BSTExamples().isContainedSeq(createBST(), seq, index));
  }

  @Test
  public void maxValueNode() throws Exception {
    assertEquals(5, new BSTExamples().maxValueNode(createBST(), 2, 5));
  }

  @Test
  public void kSmallestSum() throws Exception {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(60);
    int[] k = {3};
    int[] sum = {0};
    assertEquals(140, new BSTExamples().kSmallestSum(root, sum, k));
  }

  @Test
  public void kthLargestElement() throws Exception {
    int[] k = {2};
    assertEquals(4, new BSTExamples().kthLargestElement(createBST(), k));
    int[] k2 = {3};
    assertEquals(2, new BSTExamples().kthLargestElement(createBST(), k2));
  }

  @Test
  public void isBST() throws Exception {
    assertTrue(new BSTExamples().isBST(createBST()));
  }

  @Test
  public void closetElement() throws Exception {
    TreeNode root = new TreeNode(9);
    root.left = new TreeNode(4);
    root.right = new TreeNode(17);
    assertEquals(2, new BSTExamples().closetElement(createBST(), 2, Integer.MAX_VALUE, Integer.MAX_VALUE));
    assertEquals(17, new BSTExamples().closetElement(root, 18, Integer.MAX_VALUE, Integer.MAX_VALUE));
//    assertEquals(9, new BSTExamples().closetElement(createBST(), 12, Integer.MAX_VALUE, Integer.MAX_VALUE));
  }

  @Test
  public void minValueNode() throws Exception {
    assertEquals(2, new BSTExamples().minValueNode(createBST()).data);

  }

  private TreeNode createBST() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
//    root.left.left = new TreeNode(1);
//    root.left.right = new TreeNode(3);
//    root.left.right.left = new TreeNode(10);
//    root.left.right.right = new TreeNode(14);
//    root.right.right = new TreeNode(22);
//    root.right.right.left = new TreeNode(20);

    return root;
  }

}