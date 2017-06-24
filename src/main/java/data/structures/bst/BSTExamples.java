package data.structures.bst;

import utilities.TreeNode;

public class BSTExamples {

  /**
   * 1.
   * Problem: Find median of BST in O(n) time and O(1) space
   * Solution:
   */

  /**
   * 2.
   * Problem: Leaf nodes from Preorder of a Binary Search Tree
   * Solution:
   */

  /**
   * 3.
   * Problem: Threaded Binary Search Tree | Deletion
   * Solution:
   */

  /**
   * 4.
   * Problem: Largest BST in a Binary Tree | Set 2
   * Solution:
   */

  /**
   * 5.
   * Problem: Threaded Binary Tree | Insertion
   * Solution:
   */

  /**
   * 6.
   * Problem: Binary Search Tree insert with Parent Pointer
   * Solution:
   */

  /**
   * 7.
   * Problem: Maximum element between two nodes of BST
   * Solution:
   */

  /**
   * 8.
   * Problem: Sum of k smallest elements in BST
   * Solution:
   */

  /**
   * 9.
   * Problem: Check whether BST contains Dead End or not
   * Solution:
   */

  /**
   * 10.
   * Problem: Find the closest element in Binary Search Tree
   * Solution:
   */

  /**
   * 11.
   * Problem: Find pairs with given sum such that pair elements lie in different BSTs
   * Solution:
   */

  /**
   * 12.
   * Problem: Check if given sorted sub-sequence exists in binary search tree
   * Solution:
   */

  /**
   * 13.
   * Problem: Replace every element with the least greater element on its right
   * Solution:
   */

  /**
   * 14.
   * Problem: In-place Convert BST into a Min-Heap
   * Solution:
   */

  /**
   * 15.
   * Problem: Count inversions in an array | Set 2 (Using Self-Balancing BST)
   * Solution:
   */

  /**
   * 16.
   * Problem: Print Common Nodes in Two Binary Search Trees
   * Solution:
   */

  /**
   * 17.
   * Problem: How to implement decrease key or change key in Binary Search Tree?
   * Solution:
   */

  /**
   * 18.
   * Problem: Construct all possible BSTs for keys 1 to N
   * Solution:
   */

  /**
   * 19.
   * Problem: K&#8217;th smallest element in BST using O(1) Extra Space
   * Solution:
   */

  /**
   * 20.
   * Problem: Count BST subtrees that lie in given range
   * Solution:
   */

  /**
   * 21.
   * Problem: Count BST nodes that lie in a given range
   * Solution:
   */

  /**
   * 22.
   * Problem: Second largest element in BST
   * Solution:
   */

  /**
   * 23.
   * Problem: Data Structure for a single resource reservations
   * Solution:
   */

  /**
   * 24.
   * Problem: How to handle duplicates in Binary Search Tree?
   * Solution:
   */

  /**
   * 25.
   * Problem: Advantages of BST over Hash Table
   * Solution:
   */

  /**
   * 26.
   * Problem: K&#8217;th Largest Element in BST when modification to BST is not allowed
   * Solution:
   */

  /**
   * 27.
   * Problem: Given n appointments, find all conflicting appointments
   * Solution:
   */

  /**
   * 28.
   * Problem: C Program for Red Black Tree Insertion
   * Solution:
   */

  /**
   * 29.
   * Problem: Inorder predecessor and successor for a given key in BST
   * Solution:
   */

  /**
   * 30.
   * Problem: Transform a BST to greater sum tree
   * Solution:
   */

  /**
   * 31.
   * Problem: Binary Search Tree | Set 2 (Delete)
   * Solution:
   */

  /**
   * 32.
   * Problem: Binary Search Tree | Set 1 (Search and Insertion)
   * Solution:
   */

  /**
   * 33.
   * Problem: Add all greater values to every node in a given BST
   * Solution:
   */

  /**
   * 34.
   * Problem: Check for Identical BSTs without building the trees
   * Solution:
   */

  /**
   * 35.
   * Problem: Remove BST keys outside the given range
   * Solution:
   */

  /**
   * 36.
   * Problem: Find a pair with given sum in a Balanced BST
   * Solution:
   */

  /**
   * 37.
   * Problem: Find if there is a triplet in a Balanced BST that adds to zero
   * Solution:
   */

  /**
   * 38.
   * Problem: Convert a BST to a Binary Tree such that sum of all greater keys is added to every key
   * Solution:
   */

  /**
   * 39.
   * Problem: Floor and Ceil from a BST
   * Solution:
   */

  /**
   * 40.
   * Problem: Construct BST from given preorder traversal | Set 2
   * Solution:
   */

  /**
   * 41.
   * Problem: Construct BST from given preorder traversal | Set 1
   * Solution:
   */

  /**
   * 42.
   * Problem: Two nodes of a BST are swapped, correct the BST
   * Solution:
   */

  /**
   * 43.
   * Problem: Check if each internal node of a BST has exactly one child
   * Solution:
   */

  /**
   * 44.
   * Problem: Binary Tree to Binary Search Tree Conversion
   * Solution:
   */

  /**
   * 45.
   * Problem: Merge two BSTs with limited extra space
   * Solution:
   */

  /**
   * 46.
   * Problem: Merge Two Balanced Binary Search Trees
   * Solution:
   */

  /**
   * 47.
   * Problem: Find the largest BST subtree in a given Binary Tree | Set 1
   * Solution:
   */

  /**
   * 48.
   * Problem: Sorted Array to Balanced BST
   * Solution:
   */

  /**
   * 49.
   * Problem: Sorted Linked List to Balanced BST
   * Solution:
   */

  /**
   * 50.
   * Problem: Print BST keys in the given range
   * Solution:
   */

  /**
   * 51.
   * Problem: Find k-th smallest element in BST (Order Statistics in BST)
   * Solution:
   */

  /**
   * 52.
   * Problem: Inorder Successor in Binary Search Tree
   * Solution:
   */

  /**
   * 53.
   * Problem: Sorted order printing of a given array that represents a BST
   * Solution:
   */

  /**
   * 54.
   * Problem: Total number of possible Binary Search Trees with n keys
   * Solution:
   */

  /**
   * 55.
   * Problem: A program to check if a binary tree is BST or not
   * Solution:
   */
  TreeNode prev;
  boolean isBST(TreeNode root) {
    prev = null;
    return isBST(root);
  }
  boolean isBSTUtil(TreeNode root) {
    if (root == null) return true;
    else {
      if (!isBSTUtil(root.left)) return false;
      if (prev != null && root.data <= prev.data) return false;
      prev = root;
      return isBSTUtil(root.right);
    }
  }

  /**
   * 56.
   * Problem: Find the node with minimum value in a Binary Search Tree
   * Solution:
   */

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
  int kthLargestNode(TreeNode root, int k, int count) {
    if (root == null || count >= k) return -1;
    else {
      int left = kthLargestNode(root.right, k, count + 1);
      count++;
      if (k == count) return root.data;
      int right = kthLargestNode(root.left, k, count);
      return left != -1 ? left : right;
    }
  }

}
