package data.structures.binarytrees;
import org.junit.Test;
import utilities.TreeNode;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class TreeExamplesTest {
    @Test
    public void traversalTest() {

        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        TreeExamples traversals = new TreeExamples();
        traversals.inorder(root);
        System.out.println("");
        traversals.preorder(root);
        System.out.println("");
        traversals.postorder(root);

    }
    @Test
    public void constructTreeTest() {
        int[] pre = {1, 2, 3};
        int[] in = {2, 1, 3};
        TreeNode root = new TreeExamples().constructTree(pre, in, 0, in.length - 1);
        new TreeExamples().preorder(root);
    }
    @Test
    public void sumOfRootToLeafTest(){
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        assertEquals(13997, new TreeExamples().sumOfRootToLeafPath(root, 0));
    }

    @Test
    public void printWithNoSiblingTest() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
//        root.left.right.right = new TreeNode(4);
        new TreeExamples().printWithNoSibling(root, null);
    }

    @Test
    public void printKDistanceLeafTest() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        Set<TreeNode> set = new HashSet<>();
        new TreeExamples().printKNodeFromLeaf(root, 2, set);
        for (TreeNode node : set) System.out.print(node.data + " ");
    }

    @Test
    public void areCousinsTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(9);

        assertEquals(true, new TreeExamples().areCousins(root, root.left.left, root.right.right));
    }
    @Test
    public void sizeTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(9);


        assertEquals(3, new TreeExamples().size(root));
    }

    @Test
    public void heightTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        assertEquals(2,new TreeExamples().height(root));
    }

    @Test
    public void isIdenticalTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        assertEquals(true,new TreeExamples().isIdentical(root,root));
    }

    @Test
    public void mirrorTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;


        new TreeExamples().mirror(root);
        assertEquals(3,root.left.data);
    }

    @Test
    public void pathToLeafTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
      //  new TreeExamples().rootToLeafPath("",root);
    }

    @Test
    public void levelOrderTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        new TreeExamples().levelOrder(root);
    }

    @Test
    public void levelOrderSpiralTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        new TreeExamples().levelOrderSpiral(root);
    }

    @Test
    public void countLeavesTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        assertEquals(3,new TreeExamples().countLeaves(root));
    }

    @Test
    public void hasChildSumTest() {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        assertEquals(true,new TreeExamples().hasChildSum(root));
    }

    @Test
    public void convertToChildSumTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        new TreeExamples().convertToChildSum(root);
        assertEquals(12,root.data);
    }

    @Test
    public void diameterTest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        assertEquals(4,new TreeExamples().diameter(root));
    }

    @Test
    public void LCATest() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        assertEquals(1,new TreeExamples().LCA(root,4,5).data);
    }

}
