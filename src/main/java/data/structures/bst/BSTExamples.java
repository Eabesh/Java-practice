package data.structures.bst;

import utilities.TreeNode;
import utilities.Utils;

public class BSTExamples {

  /**
   * 1.
   * Problem: Find the node with minimum value in a Binary Search Tree.
   * Solution:
   */
  TreeNode minValueNode(TreeNode root) {
    if (root == null || root.left == null) return root;
    else return minValueNode(root.left);
  }

  /**
   * 2.
   * Problem: A program to check if a binary tree is BST or not.
   */
  boolean isBST(TreeNode root, TreeNode[] childNode) {
    if (root == null) return true;
    else if (!isBST(root.left, childNode)) return false;
    else if (childNode[0] != null && childNode[0].data > root.data) return false;
    else {
      childNode[0] = root;
      return isBST(root.right, childNode);
    }
  }

  /**
   * 3.
   * Problem: Total number of possible Binary Search Trees with n keys.
   * Solution:Total number of possible Binary Search Trees with n different keys = Catalan number Cn = (2n)!/(n+1)!*n!
   */


  /**
   * 4.
   * Problem: Sorted order printing of a given array that represents a BST.
   * Given an array that stores a complete Binary Search Tree, write a function that efficiently prints the given array
   * in ascending order.
   */


  /**
   * 5.
   * Problem: Inorder Successor in Binary Search Tree.
   * Solution:
   */

  /**
   * 6.
   * Problem: Find k-th smallest element in BST (Order Statistics in BST).
   * Solution:
   */

  /**
   * 7.
   * Problem: Print BST keys in the given range.
   * Solution:
   */

  /**
   * 8.
   * Problem: Sorted Linked List to Balanced BST.
   * Solution:
   */

  /**
   * 9.
   * Problem: Sorted Array to Balanced BST.
   * Solution:
   */

  /**
   * 10.
   * Problem: Find the largest BST subtree in a given Binary Tree | Set 1.
   * Solution:
   */

  /**
   * 11.
   * Problem: Merge Two Balanced Binary Search Trees.
   * Solution:
   */

  /**
   * 12.
   * Problem: Merge two BSTs with limited extra space.
   * Solution:
   */

  /**
   * 13.
   * Problem: Binary Tree to Binary Search Tree Conversion.
   * Solution:
   */

  /**
   * 14.
   * Problem: Check if each internal node of a BST has exactly one child.
   * Solution:
   */

  /**
   * 15.
   * Problem: Two nodes of a BST are swapped, correct the BST.
   * Solution:
   */

  /**
   * 16.
   * Problem: Construct BST from given preorder traversal | Set 1.
   * Solution:
   */

  /**
   * 17.
   * Problem: Construct BST from given preorder traversal | Set 2.
   * Solution:
   */

  /**
   * 18.
   * Problem: Floor and Ceil from a BST.
   * Solution:
   */

  /**
   * 19.
   * Problem: Convert a BST to a Binary Tree such that sum of all greater keys is added to every key.
   * Solution:
   */

  /**
   * 20.
   * Problem: Find if there is a triplet in a Balanced BST that adds to zero.
   * Solution:
   */

  /**
   * 21.
   * Problem: Find a pair with given sum in a Balanced BST.
   * Solution:
   */

  /**
   * 22.
   * Problem: Remove BST keys outside the given range.
   * Solution:
   */

  /**
   * 23.
   * Problem: Check for Identical BSTs without building the trees.
   * Solution:
   */

  /**
   * 24.
   * Problem: Add all greater values to every node in a given BST.
   * Solution:
   */

  /**
   * 25.
   * Problem: Binary Search Tree | Set 1 (Search and Insertion).
   * Solution:
   */

  /**
   * 26.
   * Problem: Binary Search Tree | Set 2 (Delete).
   * Solution:
   */

  /**
   * 27.
   * Problem: Transform a BST to greater sum tree.
   * Solution:
   */

  /**
   * 28.
   * Problem: Inorder predecessor and successor for a given key in BST.
   * Solution:
   */

  /**
   * 29.
   * Problem: C Program for Red Black Tree Insertion.
   * Solution:
   */

  /**
   * 30.
   * Problem: Given n appointments, find all conflicting appointments.
   * Solution:
   */

  /**
   * 31.
   * Problem: K&#8217;th Largest Element in BST when modification to BST is not allowed.
   * Solution:
   */

  /**
   * 32.
   * Problem: Advantages of BST over Hash Table.
   * Solution:
   */

  /**
   * 33.
   * Problem: How to handle duplicates in Binary Search Tree?.
   * Solution:
   */

  /**
   * 34.
   * Problem: Data Structure for a single resource reservations.
   * Solution:
   */

  /**
   * 35.
   * Problem: Second largest element in BST.
   * Solution:
   */

  /**
   * 36.
   * Problem: Count BST nodes that lie in a given range.
   * Solution:
   */

  /**
   * 37.
   * Problem: Count BST subtrees that lie in given range.
   * Solution:
   */

  /**
   * 38.
   * Problem: K&#8217;th smallest element in BST using O(1) Extra Space.
   * Solution:
   */

  /**
   * 39.
   * Problem: Construct all possible BSTs for keys 1 to N.
   * Solution:
   */

  /**
   * 40.
   * Problem: How to implement decrease key or change key in Binary Search Tree?.
   * Solution:
   */

  /**
   * 41.
   * Problem: Print Common Nodes in Two Binary Search Trees.
   * Solution:
   */

  /**
   * 42.
   * Problem: Count inversions in an array | Set 2 (Using Self-Balancing BST).
   * Solution:
   */

  /**
   * 43.
   * Problem: In-place Convert BST into a Min-Heap.
   * Solution:
   */

  /**
   * 44.
   * Problem: Replace every element with the least greater element on its right.
   * Solution:
   */

  /**
   * 45.
   * Problem: Check if given sorted sub-sequence exists in binary search tree.
   * Solution:
   */

  /**
   * 46.
   * Problem: Find pairs with given sum such that pair elements lie in different BSTs.
   * Solution:
   */

  /**
   * 47.
   * Problem: Find the closest element in Binary Search Tree.
   * Given a binary search tree and a target node K. The task is to find the node with minimum absolute difference with
   * given target value K.
   */
   int closetElement(TreeNode root, int key, int minDiff, int result) {
     if (root == null) return result;
     else if (root.data == key) return key;
     else if (root.data < key) {
       if (isValid(minDiff, root.data - key)) return closetElement(root.left, key, Math.abs(root.data - key), root.data);
       else return closetElement(root.left, key, minDiff, result);
     } else {
       if (isValid(minDiff, root.data - key)) return closetElement(root.right, key, Math.abs(root.data - key), root.data);
       else return closetElement(root.right, key, minDiff, result);
     }
  }

  private boolean isValid(int x, int y) {
     return (x < Math.abs(y)) ? true : false;
  }

  /**
   * 48.
   * Problem: Check whether BST contains Dead End or not.
   * Solution:
   */

  /**
   * 49.
   * Problem: Sum of k smallest elements in BST.
   * Solution:
   */

  /**
   * 50.
   * Problem: Maximum element between two nodes of BST.
   * Solution:
   */

  /**
   * 51.
   * Problem: Binary Search Tree insert with Parent Pointer.
   * Solution:
   */

  /**
   * 52.
   * Problem: Threaded Binary Tree | Insertion.
   * Solution:
   */

  /**
   * 53.
   * Problem: Largest BST in a Binary Tree | Set 2.
   * Solution:
   */

  /**
   * 54.
   * Problem: Threaded Binary Search Tree | Deletion.
   * Solution:
   */

  /**
   * 55.
   * Problem: Leaf nodes from Preorder of a Binary Search Tree.
   * Solution:
   */

  /**
   * 56.
   * Problem: Find median of BST in O(n) time and O(1) space.
   * Solution:
   */

  /**
   * 57.
   * Problem: Convert BST to Min Heap.
   * Solution:
   */

  /**
   * 58.
   * Problem: Check if an array represents Inorder of Binary Search tree or not.
   * Solution:
   */

  /**
   * 59.
   * Problem: Largest number in BST which is less than or equal to N.
   * Solution:
   */












  /**
   * 31.
   * Problem: Kth Largest Element in BST when modification to BST is not allowed.
   * Solution:
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


}
