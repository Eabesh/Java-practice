package data.structures.binarytrees;

import data.structures.bst.BSTExamples;
import utilities.NaryTreeNode;
import utilities.TreeNode;
import utilities.Utils;

import java.lang.reflect.Array;
import java.util.*;

public class TreeExamples {
  private BSTExamples bstExamples = new BSTExamples();



  /**
   * 1.
   * Problem: Tree Traversals (Inorder, Pre-order and Post-order).
   * Unlike linear data structures (Array, Linked List, Queues, Stacks, etc) which have only one logical way to
   * traverse them, trees can be traversed in different ways.
   * Depth First Traversals: In-order, Pre-order and Post-order
   * Breadth First or Level Order Traversal
   */

  /**
   * Uses of in-order
   * In case of BST, in-order traversal gives nodes in non-decreasing order.To get nodes of BST in non-increasing order,
   * a variation of in-order traversal where in-order is traversal's reversed, can be used.
   */
  public void inOrder(TreeNode root) {
    if (root != null) {
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
    }
  }

  /**
   * Uses of Pre-order
   * To create a copy of the tree.
   * To get prefix expression on of an expression tree.
   */
  void preOrder(TreeNode root) {
    if (root != null) {
      System.out.print(root.data + " ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  /**
   * Uses of Post-order
   * To delete the tree.
   * To get the postfix expression of an expression tree.
   */
  void postOrder(TreeNode root) {
    if (root != null) {
      postOrder(root.left);
      postOrder(root.right);
      System.out.print(root.data + " ");
    }
  }

  /**
   * 2.
   * Problem: Write a program to Calculate Size of a tree.
   */
  int treeSize(TreeNode root) {
    if (root == null) return 0;
    else return 1 + treeSize(root.left) + treeSize(root.right);
  }

  /**
   * 3.
   * Problem: Write Code to Determine if Two Trees are Identical.
   */
  boolean areIdentical(TreeNode root1, TreeNode root2) {
    return root1 == null && root2 == null || root1 != null && root2 != null && root1.data == root2.data &&
            areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
  }

  /**
   * 4.
   * Problem: Write a Program to Find the Maximum Depth or Height of a Tree.
   */
  int height(TreeNode node) {
    if (node == null) return 0;
    else return 1 + Math.max(height(node.left), height(node.right));
  }

  /**
   * 5.
   * Problem: Write a  program to Delete a Tree.
   * Solution: Do a post order traversal and make the node as null.
   * Postorder, because before deleting the parent node we should delete its children nodes first.
   * Note: Java manipulates objects 'by reference,' but it passes object references to methods 'by value.'
   */
  void deleteTree(TreeNode root) {
    if (root != null) {
      deleteTree(root.left);
      deleteTree(root.right);
      root.left = root.right = null;
    }
  }

  /**
   * 6.
   * Problem: Write an Efficient Function to Convert a Binary Tree into its Mirror Tree.
   */
  void mirror(TreeNode root) {
    if (root != null) {
      mirror(root.left);
      mirror(root.right);
      swapChildren(root);
    }
  }

  private void swapChildren(TreeNode node) {
    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;
  }

  /**
   * 7.
   * Problem: If you are given two traversal sequences, can you construct the binary tree?.
   * Solution: It depends on what traversals are given. If one of the traversal methods is Inorder then the tree can be
   * constructed, otherwise not.
   */

  /**
   * 8.
   * Problem: Given a binary tree, print out all of its root-to-leaf paths one per line..
   */
  void rootToLeafPath(TreeNode root, String path) {
    if (root != null) {
      if (isLeaf(root)) System.out.println(path + root.data);
      else {
        rootToLeafPath(root.left, path + root.data + "->");
        rootToLeafPath(root.right, path + root.data + "->");
      }
    }
  }

  /**
   * 9.
   * Problem: Lowest Common Ancestor in a Binary Search Tree.
   * Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA). You may assume
   * that both the values exist in the tree.
   */
  public TreeNode bstLCA(TreeNode root, int k1, int k2) {
    if (root == null) return null;
    else if (root.data > k1 && root.data > k2) return bstLCA(root.left, k1, k2);
    else if (root.data < k1 && root.data < k2) return bstLCA(root.right, k1, k2);
    else return root;
  }

/**
 * Problem: Lowest Common Ancestor in a Binary Tree. (When both keys present.)
 */
 TreeNode findLCABT(TreeNode root, int k1, int k2) {
   if (root == null) return null;
   else if (root.data == k1 || root.data == k2) return root;
   else {
     TreeNode leftLCA = findLCABT(root.left, k1, k2);
     TreeNode rightLCA = findLCABT(root.right, k1, k2);
     if (leftLCA != null && rightLCA != null) return root;
     return (leftLCA != null) ? leftLCA : rightLCA;
   }
 }



  /**
   * Problem: Lowest Common Ancestor in a Binary Tree. (When both keys may not be present.)
   */

  class KeyInfo {
    boolean present;

    public KeyInfo(boolean present) {
      this.present = present;
    }
  }

  TreeNode findLCA(TreeNode root, int k1, int k2) {
    KeyInfo keyInfo1 = new KeyInfo(false), keyInfo2 = new KeyInfo(false);
    TreeNode lca = LCAUtil(root, k1, k2, keyInfo1, keyInfo2);
    if (keyInfo1.present && keyInfo2.present || keyInfo1.present && treeContains(root, k2) || keyInfo2.present && treeContains(root, k1)) return lca;
    else return null;
  }

  private TreeNode LCAUtil(TreeNode root, int k1, int k2, KeyInfo keyInfo1, KeyInfo keyInfo2) {
    if (root == null) return root;
    if (root.data == k1) {
      keyInfo1.present = true;
      return root;
    }
    if (root.data == k2) {
      keyInfo2.present = true;
      return root;
    }
    TreeNode leftLCA = LCAUtil(root.left, k1, k2, keyInfo1, keyInfo2);
    TreeNode rightLCA = LCAUtil(root.right, k1, k2, keyInfo1, keyInfo2);
    if (leftLCA != null && rightLCA != null) return root;
    else return leftLCA != null ? leftLCA : rightLCA;
  }

  private boolean treeContains(TreeNode root, int key) {
    if (root == null) return false;
    else return root.data == key || treeContains(root.left, key) || treeContains(root.right, key);
  }


  /**
   * 10.
   * Problem: The Great Tree-List Recursion Problem.
   */
  TreeNode head2 = null, prev1 = null;

  void treeToList(TreeNode root) {
    if (root != null) {
      treeToList(root.left);
      if (head2 == null) head2 = root;
      else {
        prev1.right = root;
        root.left = prev1;
      }
      prev1 = root;
      treeToList(root.right);
    }
  }

  /**
   * 11.
   * Problem: Level Order Tree Traversal
   */
  void levelOrder(TreeNode root) {
    int height = height(root);
    for (int i = 1; i <= height; i++) {
      level(root, i);
      System.out.println();
    }
  }

  private void level(TreeNode root, int level) {
    if (root != null) {
      if (level == 1) System.out.print(root.data + " ");
      else {
        level(root.left, level - 1);
        level(root.right, level - 1);
      }
    }
  }

  /**
   * 12.
   * Problem: Count leaf nodes in a binary tree
   */
  int countLeaves(TreeNode root) {
    if (root == null) return 0;
    else if (isLeaf(root)) return 1;
    else return countLeaves(root.right) + countLeaves(root.left);
  }

  public boolean isLeaf(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }

  /**
   * 13.
   * Problem: Level order traversal in spiral form
   */
  void levelOrderSpiral(TreeNode root) {
    int height = height(root);
    for (int i = 1; i <= height; i++) {
      levelSpiral(root, i, i % 2 == 0);
      System.out.println();
    }
  }

  private void levelSpiral(TreeNode root, int level, boolean odd) {
    if (root != null) {
      if (level < 2) System.out.print(root.data + " ");
      else if (odd) {
        level(root.right, level - 1);
        level(root.left, level - 1);
      } else {
        level(root.left, level - 1);
        level(root.right, level - 1);
      }
    }
  }

  /**
   * 14.
   * Problem: Check for Children Sum Property in a Binary Tree.
   * Given a binary tree, write a function that returns true if the tree satisfies below property.
   * For every node, data value must be equal to sum of data values in left and right children.
   */
  boolean hasChildSum(TreeNode root) {
    return root == null || isLeaf(root) || root.data == getChildSum(root) && hasChildSum(root.left) && hasChildSum(root.right);
  }

  private int getChildSum(TreeNode node) {
    int sum = 0;
    if (node.left != null) sum += node.left.data;
    if (node.right != null) sum += node.right.data;
    return sum;
  }

  /**
   * 15.
   * Problem: Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
   */
  TreeNode convertToChildSum(TreeNode root) {
    if (root == null || isLeaf(root)) return root;
    else {
      convertToChildSum(root.left);
      convertToChildSum(root.right);
      root.data = getChildSum(root);
      return root;
    }
  }



  /**
   * 16.
   * Problem: Diameter of a Binary Tree
   */
  int diameter(TreeNode root) {
    if (root == null) return 0;
    else return Utils.max(0,height(root.left) + 1 + height(root.right), diameter(root.left), diameter(root.right));
  }

  class DiameterInfo{
    int height, diameter;
    DiameterInfo(int h, int d) {
      this.height = h;
      this.diameter = d;
    }
  }

  DiameterInfo diameterOpt1(TreeNode root) {
    if (root == null) return new DiameterInfo(0, 0);
    else {
      DiameterInfo left = diameterOpt1(root.left);
      DiameterInfo right = diameterOpt1(root.right);
      return new DiameterInfo(1 + Math.max(left.height, right.height),
              Utils.max(0,left.height + 1 + right.height, left.diameter, right.diameter));
    }
  }

  /**
   * 17.
   * Problem: How to determine if a binary tree is height-balanced?.
   * Solution:
   */




  /**
   * 18.
   * Problem: Inorder Tree Traversal without Recursion.
   * Solution:
   */


  /**
   * 19.
   * Problem: Inorder Tree Traversal without recursion and without stack! (Morris Traversal)
   * Solution: Use Morris Traversal.
   * 1. Initialize current as root
   * 2. While current is not NULL
   * If current does not have left child
   * a) Print current’s data
   * b) Go to the right, i.e., current = current->right
   * Else
   * a) Make current as right child of the rightmost node in current's left subtree
   * b) Go to this left child, i.e., current = current->left
   */
  void morrisTraversal(TreeNode root) {
    TreeNode prev, current = root;

    while (current != null) {
      if (current.left == null) {
        System.out.print(current.data + " ");
        current = current.right;
      } else {
        prev = getInorderPredecessor(current.left, current);
        if (prev.right == null) {
          link(prev, current);
          current = current.left;
        } else {
          unLink(prev);
          System.out.print(current.data + " ");
          current = current.right;
        }
      }
    }
  }

  public void link(TreeNode prev, TreeNode current) {
    prev.right = current;
  }

  public void unLink(TreeNode prev) {
    prev.right = null;
  }

  public TreeNode getInorderPredecessor(TreeNode node, TreeNode current) {
    while (node.right != null && node.right != current) node = node.right;
    return node;
  }


  /**
   * 20.
   * Problem: Root to leaf path sum equal to a given number.
   * Given a binary tree and a number, return true if the tree has a root-to-leaf path such that adding up all the values
   * along the path equals the given number. Return false if no such path can be found.
   */
  boolean hasRootToLeafSumPath(TreeNode root, int sum) {
    if (root == null) return false;
    else if (isLeaf(root)) return sum == root.data;
    else return hasRootToLeafSumPath(root.left, sum - root.data) ||
              hasRootToLeafSumPath(root.right, sum - root.data);
  }

  /**
   * 21.
   * Problem: Construct Tree from given Inorder and Preorder traversals
   */
  int preIndex = 0;
  public TreeNode constructTree(int[] preOder, int[] inOrder, int inStart, int end) {
    if (inStart > end) return null;
    else {
      TreeNode root = new TreeNode(preOder[preIndex]);
      int inIndex = getInorderIndex(inOrder, preOder[preIndex++]);
      root.left = constructTree(preOder, inOrder, inStart, inIndex - 1);
      root.right = constructTree(preOder, inOrder, inIndex + 1, end);
      return root;
    }
  }

  public int getInorderIndex(int[] inorder, int key) {
    for (int i = 0; i < inorder.length; i++)
      if (inorder[i] == key) return i;
    return -1;
  }





  /**
   * 22.
   * Problem: Given a binary tree, print all root-to-leaf paths
   * Solution: same as Problem 8
   */

  /**
   * 23.
   * Problem: Double Tree
   * Write a program that converts a given tree to its Double tree.
   * To create Double tree of the given tree, create a new duplicate for each node,
   * and insert the duplicate as the left child of the original node.
   */

  public TreeNode doubleTree(TreeNode root) {
    if (root == null) return null;
    else {
      root.left = doubleTree(root.left);
      root.right = doubleTree(root.right);
      TreeNode leftSubTree = root.left;
      root.left = new TreeNode(root.data);
      root.left.left = leftSubTree;
      return root;
    }
  }

  /**
   * 24.
   * Problem: Maximum width of a binary tree
   * Given a binary tree, write a function to get the maximum width of the given tree.
   * Width of a tree is maximum of widths of all levels.
   */
  public int maxWidth(TreeNode root) {
    int height = height(root);
    int[] levelWidth = new int[height];
    findMaxWidth(root, 0, levelWidth);
    int max = Integer.MIN_VALUE;
    for (int n : levelWidth) if (n > max) max = n;
    return max;
  }

  public void findMaxWidth(TreeNode root, int level, int[] levelWidth) {
    if (root != null) {
      levelWidth[level]++;
      findMaxWidth(root.left, level + 1, levelWidth);
      findMaxWidth(root.right, level + 1, levelWidth);
    }
  }


  /**
   * 25.
   * Problem: Foldable Binary Trees
   * Given a binary tree, find out if the tree can be folded or not.
   * Solution:
   */
  public boolean isFoldable(TreeNode root) {
    return root == null || isFoldable(root.left, root.right);
  }

  public boolean isFoldable(TreeNode node1, TreeNode node2) {
    return node1 == null && node2 == null || node1 != null && node2 != null && isFoldable(node1.left, node2.right)
            && isFoldable(node1.right, node2.left);
  }


  /**
   * 26.
   * Problem: Print nodes at k distance from root
   * Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.
   * Solution:
   */
  public static void printNodesAtKdistance(TreeNode root, int k) {
    if (root == null) return;
    else if (k == 0) System.out.print(root.data);
    else {
      printNodesAtKdistance(root.left, k - 1);
      printNodesAtKdistance(root.right, k - 1);
    }
  }

  /**
   * 27.
   * Problem: Applications of tree data structure.
   * Solution:
   */

  /**
   * 28.
   * Problem: Get Level of a node in a Binary Tree
   * Given a Binary Tree and a key, write a function that returns level of the key.
   * Solution: The idea is to start from the root and level as 1.
   * If the key matches with root’s data, return level. Else recursively call for left and right subtrees with level as level + 1.
   */
  int getLevel(TreeNode root, TreeNode node, int level) {
    if (root == null) return 0;
    else if (root == node) return level;
    else return getLevel(root.left, node, level + 1) + getLevel(root.right, node, level + 1);
  }



  /**
   * 29.
   * Problem: Print Ancestors of a given node in Binary Tree.
   * Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
   */
  public void printAncestors(TreeNode root, TreeNode key, String soFar) {
    if (root != null) {
      if (root == key) System.out.print(soFar);
      else {
        printAncestors(root.left, key, soFar + root.data + " ");
        printAncestors(root.right, key, soFar + root.data + " ");
      }
    }
  }

  /**
   * 30.
   * Problem: Applications of Minimum Spanning Tree Problem.
   * Solution:
   */

  /**
   * 31.
   * Problem: Check if a given Binary Tree is SumTree.
   * Solution:
   */

  /**
   * 32.
   * Problem: Check if a binary tree is subtree of another binary tree | Set 1.
   * Solution:
   */

  /**
   * 33.
   * Problem: Connect nodes at same level.
   * Solution:
   */

  /**
   * 34.
   * Problem: Connect nodes at same level using constant extra space.
   * Solution:
   */

  /**
   * 35.
   * Problem: Populate Inorder Successor for all nodes.
   * Solution:
   */

  /**
   * 36.
   * Problem: Convert a given tree to its Sum Tree.
   * Solution:
   */

  /**
   * 37.
   * Problem: Vertical Sum in a given Binary Tree | Set 1.
   * Solution:
   */

  /**
   * 38.
   * Problem: Find the maximum sum leaf to root path in a Binary Tree.
   * Solution:
   */

  /**
   * 39.
   * Problem: Construct Special Binary Tree from given Inorder traversal.
   * Solution:
   */

  /**
   * 40.
   * Problem: Construct a special tree from given preorder traversal.
   * Solution:
   */

  /**
   * 41.
   * Problem: Check whether a given Binary Tree is Complete or not | Set 1 (Iterative Solution).
   * Solution:
   */

  /**
   * 42.
   * Problem: Boundary Traversal of binary tree.
   */
  void printBoundary(TreeNode root) {
    if (root == null) return;
    else {
      System.out.print(root.data + " ");
      printLeftBoundary(root.left);
      printLeaves(root);
      printRightBoundary(root.right);
    }
  }

  private void printLeaves(TreeNode root) {
    if (root == null) return;
    else if (isLeaf(root)) System.out.print(root.data + " ");
    else {
      printLeaves(root.left);
      printLeaves(root.right);
    }
  }

  private void printLeftBoundary(TreeNode root) {
    if (root != null) {
      if (root.left != null) {
        System.out.print(root.data + " ");
        printLeftBoundary(root.left);
      } else if (root.right != null) {
        printLeftBoundary(root.right);
        System.out.print(root.data + " ");
      }
    }
  }

  private void printRightBoundary(TreeNode root) {
    if (root != null) {
      if (root.right != null) {
        printRightBoundary(root.right);
        System.out.print(root.data + " ");
      } else if (root.left != null) {
        printRightBoundary(root.left);
        System.out.print(root.data + " ");
      }
    }
  }



  /**
   * 43.
   * Problem: Construct Full Binary Tree from given preorder and postorder traversals.
   * Solution:
   */

  /**
   * 44.
   * Problem: Iterative Preorder Traversal.
   * Solution:
   */

  /**
   * 45.
   * Problem: Morris traversal for Preorder.
   * Solution:
   */

  /**
   * 46.
   * Problem: Linked complete binary tree &#038; its creation.
   * Solution:
   */

  /**
   * 47.
   * Problem: Iterative Postorder Traversal | Set 1 (Using Two Stacks).
   * Solution:
   */

  /**
   * 48.
   * Problem: Iterative Postorder Traversal | Set 2 (Using One Stack).
   * Solution:
   */

  /**
   * 49.
   * Problem: Reverse Level Order Traversal.
   * Solution:
   */

  /**
   * 50.
   * Problem: Construct Complete Binary Tree from its Linked List Representation.
   * Solution:
   */

  /**
   * 51.
   * Problem: Binary Tree | Set 1 (Introduction).
   * Solution:
   */

  /**
   * 52.
   * Problem: Convert a given Binary Tree to Doubly Linked List | Set 1.
   */
  public TreeNode treeToDLL(TreeNode root) {
    TreeNode[] head = {null};
    treeToDLL(root, head);
    return head[0];
  }

  void treeToDLL(TreeNode root, TreeNode[] head) {
    if (root != null) {
      treeToDLL(root.right, head);
      insertAtFront(root, head);
      treeToDLL(root.left, head);
    }
  }

  private void insertAtFront(TreeNode node, TreeNode[] head) {
    node.right = head[0];
    if (head[0] != null) head[0].left = node;
    head[0] = node;
  }


  /**
   * 53.
   * Problem: Tree Isomorphism Problem.
   * Solution:
   */

  /**
   * 54.
   * Problem: Iterative Method to find Height of Binary Tree.
   * Solution:
   */

  /**
   * 55.
   * Problem: Custom Tree Problem.
   * Solution:
   */

  /**
   * 56.
   * Problem: Convert a given Binary Tree to Doubly Linked List | Set 2.
   * Solution:
   */

  /**
   * 57.
   * Problem: Difference between sums of odd level and even level nodes of a Binary Tree.
   * Solution:
   */

  /**
   * 58.
   * Problem: Print Postorder traversal from given Inorder and Preorder traversals.
   * Solution:
   */

  /**
   * 59.
   * Problem: Find depth of the deepest odd level leaf node.
   * Solution:
   */

  /**
   * 60.
   * Problem: Check if all leaves are at same level.
   * Solution:
   */

  /**
   * 61.
   * Problem: Print Left View of a Binary Tree.
   */
  public void printLeftView(TreeNode root, int level, int[] maxLevel) {
    if (root == null) return;
    else if (level > maxLevel[0]) {
      System.out.print(root.data + " ");
      maxLevel[0] = level;
    } else {
      printLeftView(root.left, level + 1, maxLevel);
      printLeftView(root.right, level + 1, maxLevel);
    }
  }


  /**
   * 62.
   * Problem: Remove all nodes which don&#8217;t lie in any path with sum>= k.
   * Solution:
   */

  /**
   * 63.
   * Problem: Extract Leaves of a Binary Tree in a Doubly Linked List.
   * Solution:
   */

  /**
   * 64.
   * Problem: Deepest left leaf node in a binary tree.
   * Solution:
   */

  /**
   * 65.
   * Problem: Find next right node of a given key.
   * Solution:
   */

  /**
   * 66.
   * Problem: Sum of all the numbers that are formed from root to leaf paths
   * Given a binary tree, where every node value is a Digit from 1-9 .
   * Find the sum of all the numbers which are formed from root to leaf paths.
   * Solution:
   */

  int sumOfRootToLeafPath(TreeNode root, int num) {
    if (root == null) return 0;
    else if (isLeaf(root)) return num * 10 + root.data;
    else return sumOfRootToLeafPath(root.left, num * 10 + root.data) +
              sumOfRootToLeafPath(root.right, num * 10 + root.data);
  }

  /**
   * 67.
   * Problem: Convert a given Binary Tree to Doubly Linked List | Set 3.
   * Solution:
   */

  /**
   * 68.
   * Problem: Print all nodes that don&#8217;t have sibling.
   * Solution:
   */

  /**
   * 69.
   * Problem: Lowest Common Ancestor in a Binary Tree | Set 1.
   * Solution:
   */

  /**
   * 70.
   * Problem: Find distance between two nodes of a Binary Tree.
   * Solution:
   */

  /**
   * 71.
   * Problem: Print all nodes that are at distance k from a leaf node.
   * Solution:
   */

  /**
   * 72.
   * Problem: Check if a given Binary Tree is height balanced like a Red-Black Tree.
   * Solution:
   */

  /**
   * 73.
   * Problem: Print a Binary Tree in Vertical Order | Set 1.
   * Solution:
   */

  /**
   * 74.
   * Problem: Print all nodes at distance k from a given node.
   * Solution:
   */

  /**
   * 75.
   * Problem: Construct a tree from Inorder and Level order traversals.
   * Solution:
   */

  /**
   * 76.
   * Problem: Print Right View of a Binary Tree.
   * Solution:
   */

  /**
   * 77.
   * Problem: Print a Binary Tree in Vertical Order | Set 2 (Map based Method).
   * Solution:
   */

  /**
   * 78.
   * Problem: Reverse alternate levels of a perfect binary tree.
   * Solution:
   */

  /**
   * 79.
   * Problem: Threaded Binary Tree.
   * Solution:
   */

  /**
   * 80.
   * Problem: Find the maximum path sum between two leaves of a binary tree.
   * Solution:
   */

  /**
   * 81.
   * Problem: Check if a binary tree is subtree of another binary tree | Set 2.
   * Solution:
   */

  /**
   * 82.
   * Problem: Check if two nodes are cousins in a Binary Tree
   * Given the binary Tree and the two nodes say ‘a’ and ‘b’,
   * determine whether the two nodes are cousins of each other or not.
   * Two nodes are cousins of each other if they are at same level and have different parents.
   */
  boolean areSibling(TreeNode root, TreeNode node1, TreeNode node2) {
    if (root == null) return false;
    else return root.left == node1 && root.right == node2 || root.right == node1 && root.left == node2 ||
            areSibling(root.left, node1, node2) || areSibling(root.right, node1, node2);
  }

  boolean areCousins(TreeNode root, TreeNode node1, TreeNode node2) {
    if (root == null) return false;
    else return getLevel(root, node1, 1) == getLevel(root, node2, 1) && !areSibling(root, node1, node2);
  }


  /**
   * 83.
   * Problem: Print level order traversal line by line | Set 1.
   * Solution:
   */

  /**
   * 84.
   * Problem: Convert left-right representation of a binary tree to down-right.
   * Solution:
   */

  /**
   * 85.
   * Problem: Minimum no. of iterations to pass information to all nodes in the tree.
   * Solution:
   */

  /**
   * 86.
   * Problem: Find Height of Binary Tree represented by Parent array.
   * Solution:
   */

  /**
   * 87.
   * Problem: Print nodes between two given level numbers of a binary tree.
   * Solution:
   */

  /**
   * 88.
   * Problem: Check if a given graph is tree or not.
   * Solution:
   */

  /**
   * 89.
   * Problem: Serialize and Deserialize a Binary Tree.
   * Solution:
   */

  /**
   * 90.
   * Problem: Serialize and Deserialize an N-ary Tree.
   * Solution:
   */

  /**
   * 91.
   * Problem: Convert a Binary Tree to Threaded binary tree | Set 1 (Using Queue).
   * Solution:
   */

  /**
   * 92.
   * Problem: Print Nodes in Top View of Binary Tree.
   * Solution:
   */

  /**
   * 93.
   * Problem: Perfect Binary Tree Specific Level Order Traversal.
   * Solution:
   */

  /**
   * 94.
   * Problem: Bottom View of a Binary Tree.
   * Solution:
   */

  /**
   * 95.
   * Problem: Diagonal Sum of a Binary Tree.
   * Solution:
   */

  /**
   * 96.
   * Problem: Find the closest leaf in a Binary Tree.
   * Given a Binary Tree and a key ‘k’, find distance of the closest leaf from ‘k’.
   */
  int closetLeafFromKey(TreeNode root, TreeNode key) {
    ArrayList<TreeNode> ancestors = ancestors(root, key, new ArrayList<>());
    int minDistance = Integer.MAX_VALUE;
    int distanceFromKey = ancestors.size();
    for (TreeNode ancestor : ancestors)
      minDistance = Math.min(minDistance, findClosestLeafRoot(ancestor, 0) +
              distanceFromKey--);
    return Math.min(findClosestLeafRoot(key, 0), minDistance);
  }

  int findClosestLeafRoot(TreeNode root, int distance) {
    if (root == null) return Integer.MAX_VALUE;
    else if (isLeaf(root)) return distance;
    else return Math.min(findClosestLeafRoot(root.left, distance + 1),
              findClosestLeafRoot(root.right, distance + 1));
  }

  ArrayList ancestors(TreeNode root, TreeNode key, ArrayList<TreeNode> soFar) {
    if (root == null) return new ArrayList<>();
    else if (root == key) return new ArrayList(soFar);
    else {
      soFar.add(root);
      ArrayList left = ancestors(root.left, key, soFar);
      ArrayList right = ancestors(root.right, key, soFar);
      soFar.remove(soFar.size() - 1);
      return left.isEmpty() ? right : left;
    }
  }


  /**
   * 97.
   * Problem: Remove nodes on root to leaf paths of length < K.
   * Solution:
   */


  /**
   * 98.
   * Problem: Find sum of all left leaves in a given Binary Tree.
   */
  int sumOfLeftLeaves(TreeNode root, TreeNode parent) {
    if (root == null) return 0;
    else if (isLeaf(root) && parent.left == root) return root.data;
    else return sumOfLeftLeaves(root.left, root) + sumOfLeftLeaves(root.right, root);
  }

  /**
   * 99.
   * Problem: Check whether a binary tree is a full binary tree or not.
   * Solution:
   */

  /**
   * 100.
   * Problem: Check whether a binary tree is a complete tree or not | Set 2 (Recursive Solution).
   * Solution:
   */

  /**
   * 101.
   * Problem: Given a binary tree, how do you remove all the half nodes?.
   * Solution:
   */

  /**
   * 102.
   * Problem: Find maximum (or minimum) in Binary Tree.
   * Solution:
   */

  /**
   * 103.
   * Problem: Iterative Search for a key &#8216;x&#8217; in Binary Tree.
   * Solution:
   */

  /**
   * 104.
   * Problem: Handshaking Lemma and Interesting Tree Properties.
   * Solution:
   */

  /**
   * 105.
   * Problem: Binary Tree | Set 2 (Properties).
   * Solution:
   */

  /**
   * 106.
   * Problem: Binary Tree | Set 3 (Types of Binary Tree).
   * Solution:
   */

  /**
   * 107.
   * Problem: AVL with duplicate keys.
   * Solution:
   */

  /**
   * 108.
   * Problem: Change a Binary Tree so that every node stores sum of all nodes in left subtree.
   * Solution:
   */

  /**
   * 109.
   * Problem: Expression Tree.
   * Solution:
   */

  /**
   * 110.
   * Problem: Maximum Path Sum in a Binary Tree.
   * Solution:
   */

  /**
   * 111.
   * Problem: Find Minimum Depth of a Binary Tree.
   * Solution:
   */

  /**
   * 112.
   * Problem: Symmetric Tree (Mirror Image of itself)
   * Given a binary tree, check whether it is a mirror of itself.
   * Solution:
   */

  public boolean isMirror(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    else return root1 != null && root2 != null && root1.data == root2.data && isMirror(root1.left, root2.right) &&
            isMirror(root1.right, root2.left);
  }

  public boolean isSymmetricTree(TreeNode root) {
    return isMirror(root, root);
  }



  /**
   * 113.
   * Problem: Construct Binary Tree from given Parent Array representation.
   * Solution:
   */

  /**
   * 114.
   * Problem: Succinct Encoding of Binary Tree.
   * Solution:
   */

  /**
   * 115.
   * Problem: Mirror of n-ary Tree.
   * Solution:
   */

  /**
   * 116.
   * Problem: Check if a given array can represent Preorder Traversal of Binary Search Tree.
   * Solution:
   */

  /**
   * 117.
   * Problem: Find Count of Single Valued Subtrees.
   * Solution:
   */

  /**
   * 118.
   * Problem: Enumeration of Binary Trees.
   * Solution:
   */

  /**
   * 119.
   * Problem: Find multiplication of sums of data of leaves at same levels.
   * Solution:
   */

  /**
   * 120.
   * Problem: Find LCA in Binary Tree using RMQ.
   * Solution:
   */

  /**
   * 121.
   * Problem: Find all possible binary trees with given Inorder Traversal.
   * Solution:
   */

  /**
   * 122.
   * Problem: Locking and Unlocking of Resources arranged in the form of n-ary Tree.
   * Solution:
   */

  /**
   * 123.
   * Problem: Closest leaf to a given node in Binary Tree.
   * Solution:
   */

  /**
   * 124.
   * Problem: Check if leaf traversal of two Binary Trees is same?.
   * Solution:
   */

  /**
   * 125.
   * Problem: Inorder Non-threaded Binary Tree Traversal without Recursion or Stack.
   * Solution:
   */



  /**
   * 126.
   * Problem: Maximum difference between node and its ancestor in Binary Tree.
   */
  int maxDifferenceAncestor(TreeNode root) {
    int[] maxDiff = {Integer.MIN_VALUE};
    maxDiffAncestors(root, maxDiff);
    return maxDiff[0];
  }

  int maxDiffAncestors(TreeNode root, int[] maxDiff) {
    if (root == null) return Integer.MAX_VALUE;
    else if (isLeaf(root)) return root.data;
    else {
      int minValue = Math.min(maxDiffAncestors(root.left, maxDiff), maxDiffAncestors(root.right, maxDiff));
      maxDiff[0] = Math.max(maxDiff[0], root.data - minValue);
      return Math.min(root.data, minValue);
    }
  }


  /**
   * 127.
   * Problem: BFS vs DFS for Binary Tree
   * Solution: A Tree is typically traversed in two ways:
   * Breadth First Traversal (Or Level Order Traversal)
   * Depth First Traversals
   * Inorder Traversal (Left-Root-Right)
   * Preorder Traversal (Root-Left-Right)
   * Postorder Traversal (Left-Right-Root)
   *
   * Is there any difference in terms of Time Complexity?
   * All four traversals require O(n) time as they visit every node exactly once.
   * Is there any difference in terms of Extra Space.
   * There is difference in terms of extra space required.
   * Extra Space required for Level Order Traversal is O(w) where w is maximum width of Binary Tree. In level order traversal, queue one by one stores nodes of different level.
   * Extra Space required for Depth First Traversals is O(h) where h is maximum height of Binary Tree. In Depth First Traversals, stack (or function call stack) stores all ancestors of a node.
   * Maximum Width of a Binary Tree at depth (or height) h can be 2h where h starts from 0. So the maximum number of nodes can be at the last level. And worst case occurs when Binary Tree is a perfect Binary Tree with numbers of nodes like 1, 3, 7, 15, …etc. In worst case, value of 2h is Ceil(n/2).
   *
   * Height for a Balanced Binary Tree is O(Log n). Worst case occurs for skewed tree and worst case height becomes O(n).
   *
   * So in worst case extra space required is O(n) for both. But worst cases occur for different types of trees.
   * How to Pick One?
   * Extra Space can be one factor (Explained above.
   *
   * Depth First Traversals are typically recursive and recursive code requires function call overheads
   *
   * The most important points is, BFS starts visiting nodes from root while DFS starts visiting nodes from leaves.
   * So if our problem is to search something that is more likely to closer to root, we would prefer BFS.
   * And if the target node is close to a leaf, we would prefer DFS.
   */

  /**
   * 128.
   * Problem: Construct a Binary Search Tree from given postorder.
   * Solution:
   */

  /**
   * 129.
   * Problem: Lowest Common Ancestor in a Binary Tree | Set 2 (Using Parent Pointer).
   * Solution:
   */

  /**
   * 130.
   * Problem: Check sum of Covered and Uncovered nodes of Binary Tree.
   * Solution:
   */

  /**
   * 131.
   * Problem: Check if removing an edge can divide a Binary Tree in two halves.
   * Solution:
   */

  /**
   * 132.
   * Problem: Print leftmost and rightmost nodes of a Binary Tree.
   * Solution:
   */

  /**
   * 133.
   * Problem: Vertical Sum in Binary Tree | Set 2 (Space Optimized).
   * Solution:
   */

  /**
   * 134.
   * Problem: Construct Ancestor Matrix from a Given Binary Tree.
   * Solution:
   */

  /**
   * 135.
   * Problem: Construct tree from ancestor matrix.
   * Solution:
   */

  /**
   * 136.
   * Problem: Perfect Binary Tree Specific Level Order Traversal | Set 2.
   * Solution:
   */

  /**
   * 137.
   * Problem: Convert a normal BST to Balanced BST.
   * Solution:
   */

  /**
   * 138.
   * Problem: Convert a given Binary Tree to Doubly Linked List | Set 4.
   * Solution:
   */

  /**
   * 139.
   * Problem: Diagonal Traversal of Binary Tree.
   * Solution:
   */

  /**
   * 140.
   * Problem: Print root to leaf paths without using recursion.
   * Solution:
   */

  /**
   * 141.
   * Problem: Non-recursive program to delete an entire binary tree.
   * Solution:
   */

  /**
   * 142.
   * Problem: Convert a Binary Tree into Doubly Linked List in spiral fashion.
   * Solution:
   */

  /**
   * 143.
   * Problem: Density of Binary Tree in One Traversal.
   * Solution:
   */

  /**
   * 144.
   * Problem: Number of ways to traverse an N-ary tree.
   * Solution:
   */

  /**
   * 145.
   * Problem: Sink Odd nodes in Binary Tree.
   * Solution:
   */

  /**
   * 146.
   * Problem: Print Binary Tree in 2-Dimensions.
   * Solution:
   */

  /**
   * 147.
   * Problem: Create a Doubly Linked List from a Ternary Tree.
   * Solution:
   */


  /**
   * 148.
   * Problem: Check if two trees are Mirror
   * Given two Binary Trees, write a function that returns true if two trees are mirror of each other, else false.
   */
  public boolean areMirror(TreeNode root1, TreeNode root2) {
    return root1 == null && root2 == null || root1 != null && root2 != null && root1.data == root2.data
            && areMirror(root1.left, root2.right) && areMirror(root1.right, root2.left);
  }

  /**
   * 149.
   * Problem: Construct a Binary Tree from Postorder and Inorder.
   * Solution:
   */

  /**
   * 150.
   * Problem: Find largest subtree having identical left and right subtrees.
   * Given a binary tree, find the largest subtree having identical left and right subtree. Expected complexity is O(n).
   */
  private class IdenticalInfo {
    String soFar;
    int maxSize, size;
    TreeNode maxNode;

    public IdenticalInfo(String soFar, int maxSize, int size, TreeNode maxNode) {
      this.soFar = soFar;
      this.maxSize = maxSize;
      this.maxNode = maxNode;
      this.size = size;
    }
  }

  void findMaxIdenticalSubTree(TreeNode root) {
     IdenticalInfo identicalInfo = findLargestIdenticalSubTree(root);
    System.out.println(identicalInfo.maxNode.data + " " + identicalInfo.maxSize);
  }
  private IdenticalInfo findLargestIdenticalSubTree(TreeNode root) {
    if (root == null) return new IdenticalInfo("", 0, 0,null);
    else if (isLeaf(root)) return new IdenticalInfo("" + root.data, 0, 1, null);
    else {
      IdenticalInfo left = findLargestIdenticalSubTree(root.left);
      IdenticalInfo right = findLargestIdenticalSubTree(root.right);
      if (left.soFar.equals(right.soFar))
          return new IdenticalInfo(left.soFar + right.soFar + root.data, 1 + left.size + right.size, 1 + left.size + right.size, root);
      else if (left.maxSize > right.maxSize) return new IdenticalInfo(left.soFar + right.soFar + root.data, left.maxSize, 1 + left.size + right.size, left.maxNode);
      else  return new IdenticalInfo(left.soFar + right.soFar + root.data,right.maxSize, 1 + left.size + right.size, right.maxNode);

    }
  }

  /**
   * 151.
   * Problem: Iterative function to check if two trees are identical.
   * Solution:
   */

  /**
   * 152.
   * Problem: Print cousins of a given node in Binary Tree.
   * Solution:
   */

  /**
   * 153.
   * Problem: Print extreme nodes of each level of Binary Tree in alternate order.
   * Solution:
   */

  /**
   * 154.
   * Problem: Evaluation of Expression Tree.
   * Solution:
   */

  /**
   * 155.
   * Problem: Find a number in minimum steps.
   * Given an infinite number line from -INFINITY to +INFINITY and we are on zero. We can move n steps either
   * side at each n’th time.
   */
  int minSteps(int source, int dest, int steps) {
    if (Math.abs(source) > dest) return Integer.MAX_VALUE;
    else if (source == dest) return steps;
    else return Math.min(minSteps(source - steps - 1, dest, steps + 1),
              minSteps(source + steps + 1, dest, steps + 1));
  }


  /**
   * 156.
   * Problem: Find height of a special binary tree whose leaf nodes are connected.
   * Solution:
   */

  /**
   * 157.
   * Problem: Convert a Binary Tree to a Circular Doubly Link List.
   * Solution:
   */

  /**
   * 158.
   * Problem: Maximum Consecutive Increasing Path Length in Binary Tree.
   * Solution:
   */

  /**
   * 159.
   * Problem: Binary Indexed Tree : Range Updates and Point Queries.
   * Solution:
   */

  /**
   * 160.
   * Problem: Flip Binary Tree.
   * Solution:
   */

  /**
   * 161.
   * Problem: Longest consecutive sequence in Binary tree.
   * Solution:
   */

  /**
   * 162.
   * Problem: Swap Nodes in Binary tree of every k&#8217;th level.
   * Solution:
   */

  /**
   * 163.
   * Problem: Check if there is a root to leaf path with given sequence.
   * Solution:
   */

  /**
   * 164.
   * Problem: Find if there is a pair in root to a leaf path with sum equals to root&#8217;s data.
   * Solution:
   */

  /**
   * 165.
   * Problem: Continuous Tree.
   * Solution:
   */

  /**
   * 166.
   * Problem: Root to leaf paths having equal lengths in a Binary Tree.
   * Solution:
   */

  /**
   * 167.
   * Problem: Find maximum level sum in Binary Tree.
   * Solution:
   */

  /**
   * 168.
   * Problem: Maximum sum of nodes in Binary tree such that no two are adjacent.
   * Solution:
   */

  /**
   * 169.
   * Problem: Print all nodes in a binary tree having K leaves.
   * Solution:
   */

  /**
   * 170.
   * Problem: Subtree with given sum in a Binary Tree.
   * Solution:
   */

  /**
   * 171.
   * Problem: Number of full binary trees such that each node is product of its children.
   * Solution:
   */

  /**
   * 172.
   * Problem: Calculate depth of a full Binary tree from Preorder.
   * Solution:
   */

  /**
   * 173.
   * Problem: Depth of the deepest odd level node in Binary Tree.
   * Solution:
   */

  /**
   * 174.
   * Problem: LCA for general or n-ary trees  (Sparse Matrix DP approach < O(nlogn), O(logn)>).
   * Solution:
   */

  /**
   * 175.
   * Problem: Print all the paths from root, with a specified sum in Binary tree.
   * Solution:
   */

  /**
   * 176.
   * Problem: Depth of an N-Ary tree.
   * Solution:
   */

  /**
   * 177.
   * Problem: Diameter of an N-ary tree.
   * Solution:
   */

  /**
   * 178.
   * Problem: Minimum swap required to convert binary tree to binary search tree.
   * Solution:
   */

  /**
   * 179.
   * Problem: Convert a tree to forest of even nodes.
   * Solution:
   */

  /**
   * 180.
   * Problem: Print all k-sum paths in a binary tree.
   * Solution:
   */

  /**
   * 181.
   * Problem: Print a Binary Tree in Vertical Order | Set 3 (Using Level Order Traversal).
   * Solution:
   */

  /**
   * 182.
   * Problem: Sqrt (or Square Root) Decomposition | Set 2 (LCA of Tree in O(sqrt(height)) time).
   * Solution:
   */

  /**
   * 183.
   * Problem: Persistent Segment Tree | Set 1 (Introduction).
   * Solution:
   */

  /**
   * 184.
   * Problem: ScapeGoat Tree | Set 1 (Introduction and Insertion).
   * Solution:
   */

  /**
   * 185.
   * Problem: Convert a Binary Tree to Threaded binary tree | Set 2 (Efficient).
   * Solution:
   */

  /**
   * 186.
   * Problem: LCA for n-ary Tree | Constant Query O(1).
   * Solution:
   */

  /**
   * 187.
   * Problem: Longest path in an undirected tree.
   * Solution:
   */

  /**
   * 188.
   * Problem: Check if a Binary Tree contains duplicate subtrees of size 2 or more.
   * Solution:
   */

  /**
   * 189.
   * Problem: Print all root to leaf paths with there relative positions.
   * Solution:
   */

  /**
   * 190.
   * Problem: Maximum edge removal from tree to make even forest.
   * Solution:
   */

  /**
   * 191.
   * Problem: Find the Deepest Node in a Binary Tree.
   * Solution:
   */

  /**
   * 192.
   * Problem: Palindromic Tree | Introduction &amp; Implementation.
   * Solution:
   */

  /**
   * 193.
   * Problem: BK-Tree | Introduction &amp; Implementation.
   * Solution:
   */

  /**
   * 194.
   * Problem: Print all full nodes in a Binary Tree.
   */
  void printFullNodes(TreeNode root) {
    if (root != null) {
      printFullNodes(root.left);
      printFullNodes(root.right);
      if (root.left != null && root.right != null) System.out.print(root.data + " ");
    }
  }

  /**
   * 195.
   * Problem: Iterative program to count leaf nodes in a Binary Tree.
   * Solution:
   */

  /**
   * 196.
   * Problem: Count half nodes in a Binary tree (Iterative and Recursive).
   * Solution:
   */

  /**
   * 197.
   * Problem: Prufer Code to Tree Creation.
   * Solution:
   */

  /**
   * 198.
   * Problem: Find first non matching leaves in two binary trees.
   * Solution:
   */

  /**
   * 199.
   * Problem: Sum of nodes at k-th level in a tree represented as string.
   * Solution:
   */

  /**
   * 200.
   * Problem: Number of subtrees having odd count of even numbers.
   * Solution:
   */

  /**
   * 201.
   * Problem: Given level order traversal of a Binary Tree, check if the Tree is a Min-Heap.
   * Solution:
   */

  /**
   * 202.
   * Problem: Level with maximum number of nodes.
   * Solution:
   */

  /**
   * 203.
   * Problem: Threaded Binary Tree | Insertion.
   * Solution:
   */

  /**
   * 204.
   * Problem: Find distance from root to given node in a binary tree.
   * Solution:
   */

  /**
   * 205.
   * Problem: Count full nodes in a Binary tree (Iterative and Recursive).
   * Solution:
   */

  /**
   * 206.
   * Problem: Largest BST in a Binary Tree | Set 2.
   */
  int LargestBSTinBinaryTree(TreeNode root) {
    return bstExamples.largestBSTinBT(root).bstSoFar;
  }

  /**
   * 207.
   * Problem: Left-Child Right-Sibling Representation of Tree.
   * Solution:
   */

  /**
   * 208.
   * Problem: Create loops of even and odd values in a binary tree.
   * Solution:
   */

  /**
   * 209.
   * Problem: Convert Ternary Expression to a Binary Tree.
   * Solution:
   */

  /**
   * 210.
   * Problem: Convert a given Binary tree to a tree that holds Logical AND property.
   * Solution:
   */

  /**
   * 211.
   * Problem: Check for Symmetric Binary Tree (Iterative Approach).
   * Solution:
   */

  /**
   * 212.
   * Problem: Level order traversal line by line | Set 2 (Using Two Queues).
   * Solution:
   */

  /**
   * 213.
   * Problem: Check whether a given binary tree is perfect or not.
   * Solution:
   */

  /**
   * 214.
   * Problem: Creating a tree with Left-Child Right-Sibling Representation.
   * Solution:
   */

  /**
   * 215.
   * Problem: Quad Tree.
   * Solution:
   */

  /**
   * 216.
   * Problem: Iterative method to check if two trees are mirror of each other.
   * Solution:
   */

  /**
   * 217.
   * Problem: Splay Tree | Set 3 (Delete).
   * Solution:
   */

  /**
   * 218.
   * Problem: Count Balanced Binary Trees of Height h.
   * Solution:
   */


  /**
   * 219.
   * Problem: Print path from root to a given node in a binary tree.
   * Given a binary tree with distinct nodes(no two nodes have the same have data values). The problem is to print the
   * path from root to a given node x. If node x is not present then print “No Path”.
   */
  String pathFromRoot(TreeNode root, int x, String soFar) {
    if (root == null) return "";
    else if (root.data == x) return soFar + x;
    else return pathFromRoot(root.left, x, soFar + root.data + " ") +
              pathFromRoot(root.right, x, soFar + root.data + " ");
  }


  /**
   * 220.
   * Problem: Find mirror of a given node in Binary tree.
   * Given a Binary tree, the problem is to find mirror of a given node. The mirror of a node is a node which exist at
   * the mirror position of node in opposite subtree at the root.
   */
  int findMirrorNode(TreeNode root, int targetNode, TreeNode mirrorNode) {
    if (root == null || mirrorNode == null) return Integer.MIN_VALUE;
    else if (targetNode == root.data) return mirrorNode.data;
    return Math.max(findMirrorNode(root.left, targetNode, mirrorNode.right),
            findMirrorNode(root.right, targetNode, mirrorNode.left));

  }

  /**
   * 221.
   * Problem: Print the path common to the two paths from the root to the two given nodes.
   */
  void printCommonPathsFromTwoNodes(TreeNode root, TreeNode node1, TreeNode node2) {
    printCommonAncestors(root, node1, node2);
  }


  /**
   * 222.
   * Problem: Merge Two Binary Trees by doing Node Sum (Recursive and Iterative).
   * Given two binary trees. We need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
   * then sum node values up as the new value of the merged node. Otherwise, the non-null node will be used as the node
   * of new tree.
   */
  TreeNode mergeTwoTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null ) return root2;
    else if (root2 == null) return root1;
    else {
      TreeNode root;
      root = new TreeNode(root1.data + root2.data);
      root.left = mergeTwoTrees(root1.left, root2.left);
      root.right = mergeTwoTrees(root1.right, root2.right);
      return root;
    }
  }


  /**
   * 223.
   * Problem: Print common nodes on path from root (or common ancestors).
   * Given a binary tree and two nodes, the task is to Print all the nodes that are common for 2 given nodes in a binary
   * tree.
   */
  void printCommonAncestors(TreeNode root, TreeNode node1, TreeNode node2) {
    TreeNode lca = findLCA(root, node1.data, node2.data);
    printAncestors(root, lca, "");
    System.out.print(lca.data);
  }

  /**
   * 224.
   * Problem: Replace each node in binary tree with the sum of its inorder predecessor and successor.
   */
  void replaceNodeWithPreSuccessor(TreeNode root) {
    ArrayList<Integer> arrayList = new BSTExamples().bstToArray(root);
    int[] index = {0};
    replace(root, arrayList, index);
  }

  private void replace(TreeNode root, ArrayList<Integer> arrayList, int[] index) {
    if (root != null) {
      replace(root.left, arrayList, index);
      root.data = getSumOfPreSuccessor(arrayList, index);
      index[0]++;
      replace(root.right, arrayList, index);
    }
  }

  private int getSumOfPreSuccessor(ArrayList<Integer> arrayList, int[] index) {
    if (arrayList.size() < 2) return 0;
    else if (index[0] == 0) return arrayList.get(index[0] + 1);
    else if (index[0] == arrayList.size() - 1) return arrayList.get(index[0] - 1);
    else return arrayList.get(index[0] - 1) + arrayList.get(index[0] + 1);

  }

  /**
   * 225.
   * Problem: Shortest path between two nodes in array like representation of  binary tree.
   * Solution:
   */

  /**
   * 226.
   * Problem: Query for ancestor-descendant relationship in a tree.
   * Solution:
   */

  /**
   * 227.
   * Problem: Maximum sum from a tree with adjacent levels not allowed.
   * Given a binary tree with positive integer values. Find the maximum sum of nodes such that we cannot pick two levels
   * for computing sum
   */
  class LevelSum {
    int evenLevelSum, oddLevelSum;

    public LevelSum(int evenLevelSum, int oddLevelSum) {
      this.evenLevelSum = evenLevelSum;
      this.oddLevelSum = oddLevelSum;
    }
  }

  int maxSumOfAlternateLevel(TreeNode root) {
    LevelSum levelSum = new LevelSum(0, 0);
    getLevelSum(root, levelSum, 0);
    return Math.max(levelSum.evenLevelSum, levelSum.oddLevelSum);
  }

  private void getLevelSum(TreeNode root, LevelSum levelSum, int level) {
    if (root != null) {
      if (level % 2 == 0) levelSum.evenLevelSum += root.data;
      else levelSum.oddLevelSum += root.data;
      getLevelSum(root.left, levelSum, level + 1);
      getLevelSum(root.right, levelSum, level + 1);
    }
  }


  /**
   * 228.
   * Problem: Averages of Levels in Binary Tree.
   * Given a non-empty binary tree, print the average value of the nodes on each level.
   */
  void printAvgLevels(TreeNode root) {
    Queue<TreeNode> first = new LinkedList<>(), second = new LinkedList<>();
    int prevSum = 0, prevCount = 0;
    first.add(root);
    while (!first.isEmpty()) {
      TreeNode temp = first.poll();
      prevSum += temp.data;
      prevCount++;
      if (temp.left != null) second.add(temp.left);
      if (temp.right != null) second.add(temp.right);

      if (first.isEmpty()) {
        System.out.print((float) prevSum / prevCount + " ");
        prevCount = 0;
        prevSum = 0;
        first = second;
        second = new LinkedList<>();
      }
    }

  }


  /**
   * 229.
   * Problem: Iterative method to find ancestors of a given binary tree.
   * Solution:
   */

  /**
   * 230.
   * Problem: Factor Tree of a given Number.
   * Solution:
   */

  /**
   * 231.
   * Problem: Print middle level of perfect binary tree without finding height.
   */
  void printMiddleLevel(TreeNode root) {
    printMiddleLevel(root, root);
  }

  private void printMiddleLevel(TreeNode slow, TreeNode fast) {
    if (slow != null && fast != null) {
      if (isLeaf(fast)) System.out.print(slow.data + " ");
      else {
        printMiddleLevel(slow.left, fast.left.left);
        printMiddleLevel(slow.right, fast.left.left);
      }
    }
  }

  /**
   * 232.
   * Problem: Ternary Search Tree (Deletion).
   * Solution:
   */

  /**
   * 233.
   * Problem: Check if all levels of two trees are anagrams or not.
   * Solution:
   */

  /**
   * 234.
   * Problem: Get level of a node in binary tree | iterative approach.
   * Solution:
   */

  /**
   * 235.
   * Problem: Print nodes at k distance from root | Iterative.
   * Solution:
   */

  /**
   * 236.
   * Problem: Construct a complete binary tree from given array in level order fashion.
   * Solution:
   */

  /**
   * 237.
   * Problem: Check mirror in n-ary tree.
   * Solution:
   */

  /**
   * 238.
   * Problem: Leftist Tree / Leftist Heap.
   * Solution:
   */

  /**
   * 239.
   * Problem: Calculate number of nodes in all subtrees | Using DFS.
   * Solution:
   */

  /**
   * 240.
   * Problem: Number of turns to reach from one node to other in binary tree.
   * Solution:
   */

  /**
   * 241.
   * Problem: Find All Duplicate Subtrees.
   * Solution:
   */

  /**
   * 242.
   * Problem: Print Levels of all nodes in a Binary Tree.
   */
  void printLevelOfAllNode(TreeNode root, int level) {
    if (root != null) {
      System.out.print("Level of " + root.data + "is " + level);
      printLevelOfAllNode(root.left, level + 1);
      printLevelOfAllNode(root.right, level + 1);
    }
  }

  /**
   * 243.
   * Problem: Connect Nodes at same Level (Level Order Traversal).
   * Solution:
   */

  /**
   * 244.
   * Problem: Counting the number of words in a Trie.
   * Solution:
   */

  /**
   * 245.
   * Problem: Find right sibling of a binary tree with parent pointers.
   * Solution:
   */

  /**
   * 246.
   * Problem: Diameter of a tree using DFS.
   * Solution:
   */

  /**
   * 247.
   * Problem: Sum of all nodes in a binary tree.
   */
  int sumOfAllNodes(TreeNode root) {
    if (root == null) return 0;
    else return root.data + sumOfAllNodes(root.left) + sumOfAllNodes(root.right);
  }

  /**
   * 248.
   * Problem: Find sum of all right leaves in a given Binary Tree.
   */
  int sumOfRightLeaves(TreeNode root, TreeNode parent) {
    if (root == null) return 0;
    else if (isLeaf(root) && parent.right == root) return root.data;
    else return sumOfRightLeaves(root.left, root) + sumOfRightLeaves(root.right, root);
  }

  /**
   * 249.
   * Problem: Sum of all leaf nodes of binary tree.
   */
  int sumOfLeafNodes(TreeNode root) {
    if (root == null) return 0;
    else if (isLeaf(root)) return root.data;
    else return sumOfLeafNodes(root.left) + sumOfLeafNodes(root.right);
  }

  /**
   * 250.
   * Problem: Construct the full k-ary tree from its preorder traversal.
   * Solution:
   */

  /**
   * 251.
   * Problem: Insertion in a Binary Tree.
   * Solution:
   */

  /**
   * 252.
   * Problem: Height of n-ary tree if parent array is given.
   * Solution:
   */

  /**
   * 253.
   * Problem: Find root of the tree where children id sum for every node is given.
   * Solution:
   */

  /**
   * 254.
   * Problem: Deletion in a  Binary Tree.
   * Solution:
   */

  /**
   * 255.
   * Problem: Implementation of Binary Search Tree in Javascript.
   * Solution:
   */

  /**
   * 256.
   * Problem: Diameter of a Binary Tree in O(n) [A new method].
   */


  /**
   * 257.
   * Problem: Print the nodes at odd levels of a tree.
   * Solution:
   */

  /**
   * 258.
   * Problem: Longest word in ternary search tree.
   * Solution:
   */

  /**
   * 259.
   * Problem: DFS for a n-ary tree (acyclic graph) represented as adjacency list.
   * Solution:
   */

  /**
   * 260.
   * Problem: Sum of all the parent nodes having child node x.
   */
  int sumOfParentsNodes(TreeNode root, int x) {
    int[] sum = {0};
    sumOfParents(root, x, sum);
    return sum[0];
  }

  private boolean sumOfParents(TreeNode root, int key, int[] sum) {
    if (root == null) return false;
    else if (isLeaf(root) && root.data == key) return true;
    else {
      boolean left = sumOfParents(root.left, key, sum);
      boolean right = sumOfParents(root.right, key, sum);
      if (left || right) {
        sum[0] += root.data;
        return true;
      }
      else return false;
    }
  }

  /**
   * 261.
   * Problem: General Tree (Each node can have arbitrary number of children) Level Order Traversal.
   * Solution:
   */

  /**
   * 262.
   * Problem: K-th ancestor of a node in Binary Tree.
   * Solution:
   */

  /**
   * 263.
   * Problem: Sum of nodes on the longest path from root to leaf node.
   */
  private class LongestPathInfo {
    int length, sum;

    public LongestPathInfo(int length, int sum) {
      this.length = length;
      this.sum = sum;
    }
  }

  private LongestPathInfo longestPathSum(TreeNode root) {
    if (root == null) return new LongestPathInfo(0, Integer.MIN_VALUE);
    else if (isLeaf(root)) return new LongestPathInfo(1, root.data);
    else {
      LongestPathInfo left = longestPathSum(root.left);
      LongestPathInfo right = longestPathSum(root.right);
      if (left.length > right.length) return new LongestPathInfo(left.length + 1, left.sum + root.data);
      else if (right.length > left.length) return new LongestPathInfo(right.length + 1, right.sum + root.data);
      else return new LongestPathInfo(left.length + 1, Math.max(left.sum, right.sum) + root.data);
    }
  }

  int longestRootToLeafPathSum(TreeNode root) {
    return longestPathSum(root).sum;
  }

  /**
   * 264.
   * Problem: Print all leaf nodes  of a Binary Tree from left to right.
   */
  void printLeavesFromLToR(TreeNode root) {
    if (root != null) {
      if (isLeaf(root)) System.out.print(root.data + " ");
      else {
        printLeavesFromLToR(root.left);
        printLeavesFromLToR(root.right);
      }
    }
  }

  /**
   * 265.
   * Problem: Pairwise Swap  leaf nodes in a binary tree.
   */
  private class LeafInfo{
    int leafCount;
    TreeNode prevLeaf;

    public LeafInfo(int leafCount, TreeNode prevLeaf) {
      this.leafCount = leafCount;
      this.prevLeaf = prevLeaf;
    }
  }
  void pairWiseSwap(TreeNode root) {
    pairwiseLeafSwap(root, new LeafInfo(0, null));
  }

  private void pairwiseLeafSwap(TreeNode root, LeafInfo leafInfo) {
    if (root != null) {
      if (isLeaf(root)) {
        leafInfo.leafCount++;
        if (leafInfo.prevLeaf != null && leafInfo.leafCount % 2 == 0) swapNodes(root, leafInfo.prevLeaf);
        leafInfo.prevLeaf = root;
      }
      else {
        pairwiseLeafSwap(root.left, leafInfo);
        pairwiseLeafSwap(root.right, leafInfo);
      }
    }
  }

  private void swapNodes(TreeNode node1, TreeNode node2) {
    int temp = node1.data;
    node1.data = node2.data;
    node2.data = temp;
  }

  /**
   * 266.
   * Problem: Right view of Binary Tree using Queue.
   */
  void printRightViewQueue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int last = queue.size();
      for (int i = 1; i <= last; i++) {
        TreeNode temp = queue.poll();
        if (i == last) System.out.print(temp.data + " ");
        if (temp.left != null) queue.add(temp.left);
        if (temp.right != null) queue.add(temp.right);
      }
    }
  }

  /**
   * 267.
   * Problem: Check if given Preorder, Inorder and Postorder traversals are of same tree.
   * Solution:
   */

  /**
   * 268.
   * Problem: Given a n-ary tree, count number of nodes which have more number of children than parents.
   */
  int countNaryTreeNodes(NaryTreeNode root, NaryTreeNode parent) {
    if (root == null) return 0;
    else {
      int count = 0;
      for (NaryTreeNode child : root.children) {
        if (parent != null && parent.children.size() < child.children.size()) count += 1 + countNaryTreeNodes(child, root);
        else count += countNaryTreeNodes(child, root);
      }
      return count;
    }
  }

  /**
   * 269.
   * Problem: Construct Full Binary Tree using its Preorder traversal and Preorder traversal of its mirror tree.
   * Solution:
   */

  /**
   * 270.
   * Problem: Inorder Successor of a node in Binary Tree.
   * Solution:
   */

  /**
   * 271.
   * Problem: Kth ancestor of a node in binary tree | Set 2.
   * Solution:
   */

  /**
   * 272.
   * Problem: Sub-tree with minimum color difference in a 2-coloured tree.
   * Solution:
   */

  /**
   * 273.
   * Problem: Node having maximum sum of immediate children and itself in n-ary tree.
   * Solution:
   */

  /**
   * 274.
   * Problem: Second Largest element in n-ary tree.
   * Solution:
   */



















































  /**
   * 200.
   * Problem: Number of subtrees having odd count of even numbers.
   * Given a binary tree, find the number of subtrees having odd count of even numbers.
   */
  int subTreesOfOddCount(TreeNode root, int[] count) {
    if (root == null) return 0;
    int leftCount = subTreesOfOddCount(root.left, count);
    int rightCount = subTreesOfOddCount(root.right, count);
    if (root.data % 2 == 0 && (leftCount + rightCount) % 2 == 0) count[0]++;
    if (root.data % 2 != 0 && (leftCount + rightCount) % 2 != 0) count[0]++;
    if (root.data % 2 == 0) return 1 + leftCount + rightCount;
    else return leftCount + rightCount;
  }

  /**
   * 201.
   * Problem: Given level order traversal of a Binary Tree, check if the Tree is a Min-Heap.
   * Solution:
   */

  /**
   * 202.
   * Problem: Level with maximum number of nodes.
   * Solution:
   */

  /**
   * 203.
   * Problem: Threaded Binary Tree | Insertion.
   * Solution:
   */

  /**
   * 204.
   * Problem: Find distance from root to given node in a binary tree.
   */
  int findDistanceFromRoot(TreeNode root, TreeNode node, int distance) {
    if (root == null) return -1;
    else if (root == node) return distance;
    else return Math.max(findDistanceFromRoot(root.left, node, distance + 1),
              findDistanceFromRoot(root.right, node, distance + 1));
  }

  int findDistanceFromRoot1(TreeNode root, TreeNode node, int distance) {
    if (root == null) return -1;
    else if (root == node) return distance;
    else {
      int left = findDistanceFromRoot(root.left, node, distance + 1);
      if (left > -1) return left;
      int right = findDistanceFromRoot(root.right, node, distance + 1);
      if (right > -1) return right;
      return Math.max(left, right);
    }
  }


  /**
   * 213.
   * Problem: Check whether a given binary tree is perfect or not.
   * Given a Binary Tree, write a function to check whether the given Binary Tree is a prefect Binary Tree or not.
   */
  private int leftLeafDepth(TreeNode root, int depth) {
    if (isLeaf(root)) return depth;
    else return root.left != null ? leftLeafDepth(root.left, depth + 1) : leftLeafDepth(root.right, depth + 1);
  }

  boolean isPerfect(TreeNode root, int leafDepth, int level) {
    if (root == null) return true;
    else if (isLeaf(root)) return leafDepth == level + 1;
    else if (root.left == null || root.right == null) return false;
    else return isPerfect(root.left, leafDepth, level + 1) && isPerfect(root.right, leafDepth, level + 1);
  }








  /**
   * 17.
   * Problem: How to determine if a binary tree is height-balanced?
   */
  boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    else {
      int leftHeight = height(root.left);
      int rightHeight = height(root.right);
      return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
  }

  /**
   * Short circuited solution
   */
  boolean isBalancedS(TreeNode root) {
    if (root == null) return true;
    else {
      if (!isBalancedS(root.left)) return false;
      else if (!isBalancedS(root.right)) return false;
      else {
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1;
      }
    }
  }

  /**
   * Optimized solution
   */
  boolean isBal = true;

  int isBalancedOpt(TreeNode root) {
    if (root == null) return 0;
    else {
      int leftHeight = isBalancedOpt(root.left);
      int rightHeight = isBalancedOpt(root.right);
      int difference = Math.abs(leftHeight - rightHeight);
      if (difference > 1) isBal = false;
      return 1 + Math.max(leftHeight, rightHeight);
    }
  }

  /**
   * 18.
   * Problem: Inorder Tree Traversal without Recursion
   * Solution:
   * 1) Create an empty stack S.
   * 2) Initialize current node as root
   * 3) Push the current node to S and set current = current->left until current is NULL
   * 4) If current is NULL and stack is not empty then
   *      a) Pop the top item from stack.
   *      b) Print the popped item, set current = popped_item->right
   *      c) Go to step 3.
   * 5) If current is NULL and stack is empty then we are done.
   */



  /**
   * 27.
   * Problem: Applications of tree data structure

   * Solution:
   */




  /**
   * 30.
   * Problem: Check if a given Binary Tree is SumTree
   * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree
   * and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
   * Solution:
   */
  public boolean isSumTree(TreeNode root) {
    if (root == null || isLeaf(root)) return true;
    else return isSumTree(root.left) && isSumTree(root.right) && hasSumProperty(root);
  }

  public boolean hasSumProperty(TreeNode root) {
    if (root == null) return true;
    else if (root.right == null && isLeaf(root.left)) return root.data == root.left.data;
    else if (root.left == null && isLeaf(root.right)) return root.data == root.right.data;
    else if (isLeaf(root.left) && isLeaf(root.right)) return root.data == root.left.data + root.right.data;
    else if (root.left != null && root.right != null) return root.data == 2 * (root.left.data + root.right.data);
    else if (root.left != null && root.right == null) return root.data == 2 * (root.left.data);
    else return root.data == 2 * (root.right.data);

  }

  /**
   * 31.
   * Problem: Check if a binary tree is subtree of another binary tree | Set 1
   * Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree T is a tree S
   * consisting of a node in T and all of its descendants in T. The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other node is called a proper subtree.
   * Solution: Complexity O(mn), we can solve this in O(n) too.
   */
  public boolean isSubTree(TreeNode root1, TreeNode root2) {
    if (root1 == null) return false;
    else if (root2 == null) return true;
    else if (areIdentical(root1, root2)) return true;
    else return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
  }

  /**
   * 32.
   * Problem: Connect nodes at same level

   * Solution:
   */


  /**
   * 33.
   * Problem: Connect nodes at same level using constant extra space

   * Solution:
   */
  /**
   * 34.
   * Problem: Populate Inorder Successor for all nodes

   * Solution:
   */


  /**
   * 35.
   * Problem: Convert a given tree to its Sum Tree
   * Solution:
   */


  /**
   * 36.
   * Problem: Vertical Sum in a given Binary Tree | Set 1

   * Solution:
   */


  /**
   * 37.
   * Problem: Find the maximum sum leaf to root path in a Binary Tree
   * Given a Binary Tree, find the maximum sum path from a leaf to root.
   * For example, in the following tree, there are three leaf to root paths 8->-2->10, -4->-2->10 and 7->10.
   * The sums of these three paths are 16, 4 and 17 respectively. The maximum of them is 17 and the path for maximum is 7->10.
   * Solution:
   */
  public int maxRootToLeaOfPath(TreeNode root) {
    if (root == null) return 0;
    else return root.data + Math.max(maxRootToLeaOfPath(root.left), maxRootToLeaOfPath(root.right));

  }


  /**
   * 38.
   * Problem: Construct Special Binary Tree from given Inorder traversal

   * Solution:
   */


  /**
   * 39.
   * Problem: Construct a special tree from given preOrder traversal

   * Solution:
   */


  /**
   * Page 11.
   * 40.
   * Problem: Check whether a given Binary Tree is Complete or not | Set 1 (Iterative Solution)

   * Solution:
   */


  /**
   * 42.
   * Problem: Construct Full Binary Tree from given preOrder and postOrder traversals

   * Solution:
   */


  /**
   * 43.
   * Problem: Iterative Preorder Traversal

   * Solution:
   */


  /**
   * 44.
   * Problem: Morris traversal for Preorder
   * <p>
   * Solution:
   */

  public void morrisTraversalPreoder(TreeNode root) {

  }


  /**
   * 45.
   * Problem: Linked complete binary tree & its creation

   * Solution:
   */


  /**
   * 46.
   * Problem: Iterative Postorder Traversal | Set 2 (Using One Stack)

   * Solution:
   */


  /**
   * 47.
   * Problem: Reverse Level Order Traversal
   * <p>
   * Solution:
   */
  public void printReverseLevel(TreeNode root) {
    for (int i = height(root); i >= 0; i--) printReverseLevel(root, i);
  }

  public void printReverseLevel(TreeNode root, int level) {
    if (level == 0) System.out.print(root.data);
    else {
      printReverseLevel(root.left, level - 1);
      printReverseLevel(root.right, level - 1);
    }

  }


  /**
   * 48.
   * Problem: Construct Complete Binary Tree from its Linked List Representation

   * Solution:
   */

  /**
   * 49.
   * Problem: Convert a given Binary Tree to Doubly Linked List | Set 1
   * <p>
   * Solution:
   */
  TreeNode headDLL = null;

  public void convertToDLL(TreeNode root) {
    if (root != null) {
      convertToCDLL(root.right);
      root.right = headDLL;
      if (headDLL != null) headDLL.left = root;
      headDLL = root;
      convertToCDLL(root.left);
    }
  }

  /**
   * Page 10
   * 50.
   * Problem: Tree Isomorphism Problem

   * Solution:
   */


  /**
   * Page 9.
   * 51.
   * Problem: Iterative Method to find Height of Binary Tree

   * Solution:
   */


  /**
   * 52.
   * Problem: Custom Tree Problem

   * Solution:
   */


  /**
   * 53.
   * Problem: Convert a given Binary Tree to Doubly Linked List | Set 2
   * Solution:
   */


  /**
   * 54.
   * Problem: Difference between sums of odd level and even level nodes of a Binary Tree

   * Solution:
   */


  /**
   * 55.
   * Problem: Print Postorder traversal from given Inorder and Preorder traversals

   * Solution:
   */

  /**
   * 56.
   * Problem: Find depth of the deepest odd level leaf node

   * Solution:
   */


  /**
   * 57.
   * Problem: Check if all leaves are at same level

   * Solution:
   */





  /**
   * 59.
   * Problem: Remove all nodes which don’t lie in any path with sum>= k

   * Solution:
   */


  /**
   * 60.
   * Problem: Extract Leaves of a Binary Tree in a Doubly Linked List

   * Solution:
   */


  /**
   * Page 9.
   * 61.
   * Problem: Deepest left leaf node in a binary tree
   * Given a Binary Tree, find the deepest leaf node that is left child of its parent.
   * Solution:
   */

  TreeNode deepestLeftNode = null;

  public void printDeepestLeftNode(TreeNode root, int level, TreeNode parent, int[] maxLevel) {
    if (root == null) return;
    else if (isLeaf(root) && isLeft(parent, root) && level > maxLevel[0]) {
      maxLevel[0] = level;
      deepestLeftNode = root;
    } else {
      printDeepestLeftNode(root.left, level + 1, root, maxLevel);
      printDeepestLeftNode(root.left, level + 1, root, maxLevel);
    }
  }


  /**
   * Page 8.
   *  62.
   * Problem: Find next right node of a given key
   * Solution:
   */




  /**
   * 64.
   * Problem: Convert a given Binary Tree to Doubly Linked List | Set 3
   * <p>
   * Solution:
   */
  TreeNode head3 = null;

  void convertTreeToDLL(TreeNode root) {
    if (root == null) return;
    else {
      convertToCDLL(root.right);
      if (head3 == null) root.right = head3;
      else {
        head.left = root;
        head = root;
      }
      convertToCDLL(root.right);
    }
  }


  /**
   * 65.
   * Problem: Print all nodes that don’t have sibling
   * Given a Binary Tree, print all nodes that don’t have a sibling (a sibling is a node that has same parent.
   * In a Binary Tree, there can be at most one sibling). Root should not be printed as root cannot have a sibling.
   * Solution:
   */
  boolean isOnlyChild(TreeNode parent) {
    if (parent == null) return false;
    else return parent.left == null && parent.right != null || parent.left != null && parent.right == null;
  }

  void printWithNoSibling(TreeNode root, TreeNode parent) {
    if (root == null) return;
    else {
      if (isOnlyChild(parent)) System.out.print(root.data);
      printWithNoSibling(root.left, root);
      printWithNoSibling(root.right, root);
    }
  }


  /**
   * 66.
   * Problem: Lowest Common Ancestor in a Binary Tree | Set 1

   * Solution:
   */


  /**
   * 67.
   * Problem: Find distance between two given keys of a Binary Tree
   * Find the distance between two keys in a binary tree, no parent pointers are given.
   * Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
   * Solution:
   */

  int findDistance(TreeNode root, TreeNode node1, TreeNode node2) {
    TreeNode lca = findLCA(root, node1.data, node2.data);
    if (lca != null) return getLevel(lca, node1, 1) + getLevel(lca, node2, 1);
    else return -1;
  }


  /**
   * 68.
   * Problem: Print all nodes that are at distance k from a leaf node
   * Given a Binary Tree and a positive integer k, print all nodes that are distance k from a leaf node.
   * Solution:
   */

  void printKNodeFromLeaf(TreeNode root, int k, Set<TreeNode> set) {

  }

  /**
   * 69.
   * Problem: Check if a given Binary Tree is height balanced like a Red-Black Tree

   * Solution:
   */

  /**
   * 70.
   * Problem: Print a Binary Tree in Vertical Order | Set 1

   * Solution:
   */

  /**
   * 71.
   * Problem: Print all nodes at distance k from a given node

   * Solution:
   */

  /**
   * 72.
   * Problem: Construct a tree from Inorder and Level order traversals

   * Solution:
   */

  /**
   * Page 7.
   * 73.
   * Problem: Print Right View of a Binary Tree

   * Solution:
   */

  /**
   * 74.
   * Problem: Print a Binary Tree in Vertical Order | Set 2 (Hashmap based Method)
   * Solution:
   */

  /**
   * 75.
   * Problem: Reverse alternate levels of a perfect binary tree

   * Solution:
   */

  /**
   * 76.
   * Problem: Find the maximum path sum between two leaves of a binary tree
   * Given a binary tree in which each node element contains a number.
   * Find the maximum possible sum from one leaf node to another.
   * Solution:
   */

  public int maxPathBetweenTwoLeaf(TreeNode root) {
    int[] res = new int[1];
    res[0] = Integer.MIN_VALUE;
    maxPathBetweenTwoLeaves(root, res);
    return res[0];
  }

  int maxPathBetweenTwoLeaves(TreeNode root, int[] res) {
    if (root == null) return 0;
    else if (isLeaf(root)) return root.data;
    else {
      int leftSum = maxPathBetweenTwoLeaves(root.left, res);
      int rightSum = maxPathBetweenTwoLeaves(root.right, res);
      if (root.left != null && root.right != null) {
        res[0] = Math.max(res[0], leftSum + rightSum + root.data);
        return Math.max(leftSum, rightSum) + root.data;
      } else return (root.left == null) ? rightSum + root.data : leftSum + root.data;
    }
  }

  /**
   * 77.
   * Problem: Check if a binary tree is subtree of another binary tree | Set 2

   * Solution:
   */

  /**
   * 78.



  /**
   * Page 6.
   * 85.
   * Problem: Print Nodes in Top View of Binary Tree
   * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
   * Given a binary tree, print the top view of it. The output nodes can be printed in any order.
   * Expected time complexity is O(n)
   * <p>
   * Solution: Use HasSet, BFS, and mark the position.
   */

  public void printTopView(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    Set<Integer> set = new HashSet<Integer>();
    HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    map.put(root, 0);
    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      int position = map.get(curr);
      if (set.add(position)) System.out.print(curr.data + " ");
      if (curr.left != null) {
        queue.add(curr.left);
        map.put(curr.left, map.get(curr) - 1);
      }
      if (curr.right != null) {
        queue.add(curr.right);
        map.put(curr.right, map.get(curr) + 1);
      }
    }
  }


  /**
   * Page 6.
   * 86.
   * Problem: Perfect Binary Tree Specific Level Order Traversal

   * Solution:
   */

  /**
   * Page 6.
   * 87.
   * Problem: Bottom View of a Binary Tree
   * <p>
   * Solution: Use BFS and  TreeMap to store pos - > Node and replace every pos with new Node
   */
  public void bottomView(TreeNode root) {
    if (root == null) return;
    TreeMap<Integer, TreeNode> resultMap = new TreeMap<Integer, TreeNode>();
    Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    map.put(root, 0);
    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      int position = map.get(curr);
      resultMap.put(position, curr);
      if (curr.left != null) {
        queue.add(curr.left);
        map.put(curr.left, map.get(curr) - 1);
      }
      if (curr.right != null) {
        queue.add(curr.right);
        map.put(curr.right, map.get(curr) + 1);
      }
    }
    for (int key : resultMap.keySet()) System.out.print(resultMap.get(key).data + " ");

  }


  /**
   * Page 6.
   * 91.
   * Problem: Convert a given Binary Tree to Doubly Linked List | Set 3
   * <p>
   * Solution:
   */
  TreeNode head1 = null;

  public void convertDLL(TreeNode root) {
    if (root == null) return;
    else {
      convertDLL(root.right);
      root.right = head1;
      if (head1 != null) {
        head1.left = root;
      }
      head1 = root;
      convertDLL(root.left);
    }
  }


  /**
   * Page 6.
   * 92.
   * Problem: Find sum of all left leaves in a given Binary Tree
   * Solution: The idea is to traverse the tree return sum of all left leaves.
   */
  public int sumOfLeftLeaves(TreeNode root, boolean isLeftLeaf) {
    if (root == null) return 0;
    else if (isLeaf(root) && isLeftLeaf) return root.data;
    else return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
  }

  public boolean isLeft(TreeNode parent, TreeNode node) {
    if (parent == null) return false;
    else return parent.left == node;
  }








  /**
   * 113.
   * Problem: Maximum difference between node and its ancestor in Binary Tree
   * Given a binary tree, we need to find maximum value we can get by subtracting value of node B from value of node A,
   * where A and B are two nodes of the binary tree and A is an ancestor of B. Expected time complexity is O(n).
   */
  int findAmplitude(TreeNode root, ArrayList<Integer> path) {
    if (isLeaf(root)) {
      path.add(root.data);
      return Collections.max(path) - Collections.min(path);
    } else {
      ArrayList<Integer> newPath = new ArrayList<Integer>();
      newPath.addAll(path);
      newPath.add(root.data);
      return Math.max(findAmplitude(root.left, newPath), findAmplitude(root.right, newPath));
    }
  }




  /**
   * Page 2.
   * 142. Problem: Print cousins of a given node in Binary Tree
   * <p>
   * Solution: Get the level and stop at penultimate level and check if the either child node is not equal to
   * given node.
   */
  void printCousins(TreeNode root, TreeNode node) {
    if (root != null) {
      int level = getLevel(root, node, 1);
      printCousinsNodes(root, node, level);
    }
  }

  void printCousinsNodes(TreeNode root, TreeNode node, int level) {
    if (root != null && level > 1) {
      if (level == 2 && isValidParent(root, node)) {
        if (root.right != null) System.out.print(root.right.data + " ");
        else if (root.left != null) System.out.print(root.left.data + " ");
      }
    } else {
      printCousinsNodes(root.left, node, level - 1);
      printCousinsNodes(root.right, node, level - 1);
    }
  }

  private boolean isValidParent(TreeNode parent, TreeNode node) {
    if (parent.left == null && parent.right == null) return false;
    else if (parent.left != null && parent.right != null) return parent.left != node && parent.right != node;
    else if (parent.right != null) return parent.right != node;
    else return parent.left != node;
  }

  /**
   * Page 1.
   * 143. Problem: Print extreme nodes of each level of Binary Tree in alternate order
   */
  void printExtremeNodesAlt(TreeNode root) {
    for (int i = 0; i < height(root); i++) printLevelSpiral(root, i, i % 2 == 0);
  }

  boolean printLevelSpiral(TreeNode root, int level, boolean flag) {
    if (root == null) return true;
    else if (level == 0) {
      System.out.print(root.data + " ");
      return true;
    } else if (flag) {
      if (printLevelSpiral(root.left, level - 1, flag)) return true;
      else if (printLevelSpiral(root.right, level - 1, flag)) return true;
      else return false;
    } else {
      if (printLevelSpiral(root.right, level - 1, flag)) return true;
      else if (printLevelSpiral(root.left, level - 1, flag)) return true;
      else return false;
    }
  }




  /**
   * Page 1.
   * 146. Problem: Find height of a special binary tree whose leaf nodes are connected
   * Given a special binary tree whose leaf nodes are connected to form a circular doubly linked list,
   * find its height.
   * <p>
   * Solution: Node is leaf if (node.left.right = node && node.right.left == node)
   */
  int maxDepth(TreeNode node) {
    if (node == null) return 0;
    else if (isLeafModified(node)) return 1;
    else return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
  }

  boolean isLeafModified(TreeNode node) {
    return node.left != null && node.right != null && node.left.right == node && node.right.left == node;
  }

  /**
   * Page 1.
   * 147. Problem: Convert a Binary Tree to a Circular Doubly Link List
   * Given a Binary Tree, convert it to a Circular Doubly Linked List (In-Place).
   */
  TreeNode head = null;
  TreeNode prev = null;

  void convertToCDLL(TreeNode root) {
    if (root == null) return;
    else {
      convertToCDLL(root.left);
      if (head == null) head = root;
      else {
        prev.right = root;
        root.left = prev;
      }
      prev = root;
      convertToCDLL(root.right);
    }
  }

  void convertToCircularDLL(TreeNode root) {
    convertToCDLL(root);
    head.left = prev;
    prev.right = head;
  }
  /**
   * 148.
   * Problem: Maximum Consecutive Increasing Path Length in Binary Tree

   * Solution:
   */


  /**
   * 149.
   * Problem: Binary Indexed Tree : Range Updates and Point Queries

   * Solution:
   */


  /**
   * 150.
   * Problem: Flip Binary Tree

   * Solution:
   */


  /**
   * Page 1.
   * 151. Problem: Longest consecutive sequence in Binary tree
   * Given a Binary Tree find the length of the longest path which comprises of nodes with consecutive values
   * in increasing order. Every node is considered as a path of length 1.
   */
  int findLCP(TreeNode root, int parent, int pathLength, int maxLength) {
    if (root == null) return maxLength;
    else {
      if (root.data == parent + 1) pathLength++;
      else pathLength = 1;
      maxLength = Math.max(pathLength, maxLength);
      return Math.max(findLCP(root.left, root.data, pathLength, maxLength),
              findLCP(root.right, root.data, pathLength, maxLength));
    }
  }


  /**
   * 152.
   * Problem: Swap Nodes in Binary tree of every k’th level

   * Solution:
   */

  /**
   * Page 1.
   * 153. Problem: Check if there is a root to leaf path with given sequence
   * Given a binary tree and an array, the task is to find if the given array sequence is present as a root to
   * leaf path in given tree.
   */
  boolean existsPath(TreeNode root, int[] array, int start) {
    if (root == null) return start == array.length;
    else return compareNodes(root, array, start) &&
            existsPath(root.left, array, start + 1) ||
            existsPath(root.right, array, start + 1);
  }

  boolean compareNodes(TreeNode root, int[] array, int index) {
    if (index >= array.length) return false;
    else return root.data == array[index];
  }


  /**
   * 1001.Problem: Print Right View of a Binary Tree
   * Given a Binary Tree, print Right view of it.
   * Right view of a Binary Tree is set of nodes visible when tree is visited from Right side.
   */
  int maxLevel = -1;

  public void printRightView(TreeNode root, int level) {
    if (root != null) {
      if (level > maxLevel) {
        System.out.print(root.data + " ");
        maxLevel = level;
      }
      printRightView(root.right, level + 1);
      printRightView(root.left, level + 1);
    }
  }

  /**
   * 1002.Problem: Print Left View of a Binary Tree
   * Given a Binary Tree, print Left view of it.
   * Left view of a Binary Tree is set of nodes visible when tree is visited from Left side.
   */


  /**
   * 114. Change a Binary Tree so that every node stores sum of all nodes in left subtree.
   */
  int updateTree(TreeNode root) {
    if (root == null) return 0;
    else if (isLeaf(root)) return root.data;
    else {
      int leftSum = updateTree(root.left);
      int rightSum = updateTree(root.right);
      root.data += leftSum;
      return root.data + rightSum;
    }
  }

  /**
   * 115. Iterative Search for a key ‘x’ in Binary Tree
   *
   * Solution: Use any traversal.
   */

  /**
   * 116. Find maximum (or minimum) in Binary Tree.
   */
  int findMax(TreeNode root) {
    if (root == null) return Integer.MIN_VALUE;
    else return Utils.max(0, root.data, findMax(root.left), findMax(root.right));
  }

  /**
   * 112. Expression Tree.
   * Expression tree is a binary tree in which each internal node corresponds to operator and each leaf node
   * corresponds to operand.
   *
   * Solution:
   * If  t is not null then
   *      If t.value is operand then
   *          Return  t.value
   *      A = solve(t.left)
   *      B = solve(t.right)
   *
   *      calculate applies operator 't.value' on A and B, and returns value.
   *      Return calculate(A, B, t.value)
   */

}
