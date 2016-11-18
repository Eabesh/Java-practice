package data.structures.bst;

import utilities.TreeNode;

public class BSTExamples {

    /**
     * 1. Search
     */
    TreeNode search(TreeNode root, int k) {
        if (root == null || root.data == k) return root;
        else if (root.data > k) return search(root.left, k);
        else return search(root.right, k);
    }

    /**
     * 1. Insert
     */
    void insertIterative(TreeNode root, int k) {
        if (root == null) root = new TreeNode(k);
        else {
            TreeNode parent = root;
            while (root != null) {
                parent = root;
                if (root.data > k) root = root.left;
                else root = root.right;
            }
            if (k < parent.data) parent.left = new TreeNode(k);
            else parent.right = new TreeNode(k);
        }
    }

    TreeNode insert(TreeNode root, int k) {
        if (root == null) return new TreeNode(k);
        else if (k < root.data) root.left = insert(root.left,k);
        else root.right = insert(root.right,k);
        return root;
    }

    /**
     * 5. Minimum value node in a Binary Search Tree
     */
    TreeNode min(TreeNode root) {
        if (root == null) return null;
        else {
            while (root.left != null) root = root.left;
            return root;
        }
    }

    /**
     * Max node.
     */
    TreeNode max(TreeNode root) {
        if (root == null) return null;
        else {
            while (root.right != null) root = root.right;
            return root;
        }
    }

    /**
     * 6. Inorder predecessor and successor for a given key in BST
     */
    TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null) return null;
        else if (node.right != null) return min(node.right);
        else {
            TreeNode y = node.parent;
            TreeNode x = node;
            while (y != null && x == y.right) {
                x = y;
                y = y.parent;
            }
            return y;
        }
    }


    TreeNode inOrderPredecessor(TreeNode node) {
        if (node == null) return null;
        else if (node.left != null) return max(node.left);
        else {
            TreeNode y = node.parent;
            TreeNode x = node;
            while (y != null && x == y.left) {
                x = y;
                y = y.parent;
            }
            return y;
        }
    }

    /**
     * 3. Data Structure for a single resource reservations.
     * OR Flight scheduling problem.
     * OR Design a job scheduler.
     *
     * Design a data structure to do reservations of future jobs on a single machine under following constraints.
     1) Every job requires exactly k time units of the machine.
     2) The machine can do only one job at a time.
     3) Time is part of the system. Future Jobs keep coming at different times.
        Reservation of a future job is done only if there is no existing reservation within k time frame (after and before)
     4) Whenever a job finishes (or its reservation time plus k becomes equal to current time), it is removed from system.

     Solution:
     The idea is to use Binary Search Tree to maintain set of reserved jobs.
     For every reservation request, insert it only when there is no conflicting reservation.
     While inserting job, do “within k time frame check”. If there is a k distant node on insertion path from root,
     then reject the reservation request, otherwise do the reservation.

     Deletion of job is simple BST delete operation.

     A normal BST takes O(h) time for insert and delete operations.
     We can use self-balancing binary search trees like AVL, Red-Black, .. to do both operations in O(Log n) time.
     */

    /**
     * 7. Lowest Common Ancestor.
     */
    public TreeNode LCA(TreeNode root, int k1, int k2) {
        if (root == null) return root;
        else if (root.data > k1 && root.data > k2) return LCA(root.left,k1,k2);
        else if (root.data < k1 && root.data < k2) return LCA(root.right,k1,k2);
        else return root;
    }

    /**
     *  34. K’th Largest Element in BST when modification to BST is not allowed
     */
    static int c = 0;
    static TreeNode result = null;

    public static void kthLargestNode(TreeNode root, int k) {

        if (root == null || c >= k) return;
        kthLargestNode(root.right, k);
        c++;
        if (k == c) {
            result = root;
            return ;
        }
        kthLargestNode(root.left, k);
    }

}
