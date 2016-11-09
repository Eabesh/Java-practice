package data.structures.binarytrees;

import org.junit.Test;
import utilities.TreeNode;

public class TraversalsTest {


    @Test
    public void traversalTest() {

        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        Traversals traversals = new Traversals();
        traversals.inorder(root);
        System.out.println("");
        traversals.preorder(root);
        System.out.println("");
        traversals.postorder(root);

    }

}
