package data.structures.binarysearchtrees;

import data.structures.bst.BSTExamples;
import org.junit.Test;
import utilities.TreeNode;

import static org.junit.Assert.assertEquals;

public class BSTExamplesTest {

    @Test
    public void LCATest() {
        TreeNode root = new TreeNode(20);
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(30);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(15);
        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        assertEquals(10,new BSTExamples().LCA(root,4,15).data);
    }

}
