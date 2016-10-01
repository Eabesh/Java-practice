package data.structures.binarytrees;

import org.junit.Test;

public class TraversalsTest {


    @Test
    public void traversalTest() {

        Node root = new Node(2);
        Node node1 = new Node(1);
        Node node2 = new Node(3);
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
