package data.structures.bst;

import data.structures.binarytrees.TreeExamples;
import utilities.TreeNode;

import java.util.*;

public class BSTExamples {

  /**
   * 1.
   * Problem: Find the node with minimum value in a Binary Search Tree.
   */
  TreeNode minValueNode(TreeNode root) {
    if (root == null || root.left == null) return root;
    else return minValueNode(root.left);
  }

  /**
   * 2.
   * Problem: A program to check if a binary tree is BST or not.
   */
  private class PrevNode {
    TreeNode node;
  }

  boolean isBST(TreeNode root) {
    PrevNode prevNode = new PrevNode();
    return isBST(root, prevNode);
  }

  private boolean isBST(TreeNode root, PrevNode prev) {
    if (root == null) return true;
    else {
      if (!isBST(root.left, prev)) return false;
      if (prev.node != null && prev.node.data > root.data) return false;
        prev.node = root;
        return isBST(root.right, prev);
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
  void printSorted(int[] arr, int start, int end) {
    if(start <= end) {
      printSorted(arr, start * 2 + 1, end);
      System.out.print(arr[start] + " ");
      printSorted(arr, start * 2 + 2, end);
    }
  }

  /**
   * 5.
   * Problem: Inorder Successor in Binary Search Tree.
   */
  private class Successor {
    TreeNode succ;
  }

  TreeNode inorderSuccessor(TreeNode root, int key) {
    Successor successor = new Successor();
    inorderSucc(root, successor, key);
    return successor.succ;
  }

  private void inorderSucc(TreeNode root, Successor succ, int key) {
    if (root != null) {
      if (root.data == key && root.right != null) succ.succ = minValueNode(root.right);
      else if (root.data > key) {
        succ.succ = root;
        inorderSucc(root.left, succ, key);
      } else inorderSucc(root.right, succ, key);
    }
  }

  /**
   * 6.
   * Problem: Find k-th smallest element in BST (Order Statistics in BST).
   */
  int kthSmallest(TreeNode root, int[] k) {
    if (root == null) return Integer.MAX_VALUE;
    else {
      int left = kthSmallest(root.left, k);
      if (--k[0] == 0) return root.data;
      return (left != Integer.MAX_VALUE) ? left : kthSmallest(root.right, k);
    }
  }

  /**
   * 7.
   * Problem: Print BST keys in the given range.
   * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Print all the keys of tree
   * in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Print all the keys in
   * increasing order.
   */
  void printKeysWithinRange(TreeNode root, int k1, int k2) {
    if (root != null) {
      if (root.data > k1) printKeysWithinRange(root.left, k1, k2);
      if (k1 <= root.data && root.data <= k2) System.out.print(root.data + " ");
      if (root.data < k2) printKeysWithinRange(root.right, k1, k2);
    }
  }

  /**
   * 8.
   * Problem: Sorted Linked List to Balanced BST.
   */
  TreeNode sortedListToBST(TreeNode[] head) {
    int nodeCount = nodeCount(head[0], 0);
    return sortedDLLToBST(head, nodeCount);
  }

  private TreeNode sortedDLLToBST(TreeNode[] head, int nodeCount) {
    if (nodeCount <= 0) return null;
    else {
      TreeNode leftSubTree = sortedDLLToBST(head, nodeCount / 2);
      TreeNode root = new TreeNode(head[0].data);
      head[0] = head[0].right;
      root.left = leftSubTree;
      root.right = sortedDLLToBST(head, nodeCount - nodeCount / 2 - 1);
      return root;
    }
  }

  private int nodeCount(TreeNode head, int count) {
    if (head == null) return count;
    else return nodeCount(head.right, count + 1);
  }

  /**
   * 9.
   * Problem: Sorted Array to Balanced BST.
   */
  TreeNode sortedArrayToBST(int[] array, int start, int end) {
    if (start > end) return null;
    else {
      int mid = (start + end) / 2;
      TreeNode root = new TreeNode(array[mid]);
      root.left = sortedArrayToBST(array, start, mid - 1);
      root.right = sortedArrayToBST(array, mid + 1, end);
      return root;
    }
  }

  /**
   * 10.
   * Problem: Find the largest BST subtree in a given Binary Tree | Set 1.
   */
  int largestBST(TreeNode root) {
    return largestBSTinBT(root).bstSoFar;
  }

  /**
   * 11.
   * Problem: Merge Two Balanced Binary Search Trees.
   */
  TreeNode mergeTwoBST(TreeNode root1, TreeNode root2) {
    TreeNode head1 = new TreeExamples().treeToDLL(root1);
    TreeNode head2 = new TreeExamples().treeToDLL(root2);
    TreeNode[] head = new TreeNode[1];
    head[0] = mergeTwoList(head1, head2);
    return sortedListToBST(head);
  }

  private TreeNode mergeTwoList(TreeNode h1, TreeNode h2) {
    TreeNode result = null, tail = null;
    while (h1 != null && h2 != null) {
      if (h1.data < h2.data) {
        if (result == null) {
          result = h1;
          tail = h1;
          h1 = h1.right;
        } else {
          tail = insertAtLast(tail, h1);
          h1 = h1.right;
        }
      } else {
        if (result == null) {
          result = h2;
          tail = h2;
          h2 = h2.right;
        } else {
          tail = insertAtLast(tail, h2);
          h2 = h2.right;
        }
      }
    }
    if (h1 != null)  insertAtLast(tail, h1);
    else if (h2 != null)  insertAtLast(tail, h2);
    return result;
  }

  private TreeNode insertAtLast(TreeNode tail, TreeNode head) {
    tail.right = head;
    head.left = tail;
    return tail.right;
  }


  /**
   * 12.
   * Problem: Merge two BSTs with limited extra space.
   * Solution:
   */

  /**
   * 13.
   * Problem: Binary Tree to Binary Search Tree Conversion.
   * Given a Binary Tree, convert it to a Binary Search Tree. The conversion must be done in such a way that keeps the
   * original structure of Binary Tree.
   * Solution: Store inorder traversal in array -> Sort -> copy arrayValues to node values.
   */
  void binaryTreeToBST(TreeNode root) {
    ArrayList<Integer> arrayList = bstToArray(root);
    Collections.sort(arrayList);
    bTreeToBST(root, arrayList);
  }

  private void bTreeToBST(TreeNode root, ArrayList<Integer> arrayList) {
    if (root != null) {
      bTreeToBST(root.left, arrayList);
      root.data = arrayList.remove(0);
      bTreeToBST(root.right, arrayList);
    }
  }

  /**
   * 14.
   * Problem: Check if each internal node of a BST has exactly one child.
   * Given Preorder traversal of a BST, check if each non-leaf node has only one child. Assume that the BST contains
   * unique entries.
   */
  boolean hasOnlyChild(int[] pre) {
    int min, max;
    if (pre[pre.length - 1] < pre[pre.length - 2]) {
      min = pre[pre.length - 1];
      max = pre[pre.length - 2];
    } else {
      min = pre[pre.length - 2];
      max = pre[pre.length - 1];
    }
    return hasOnlyChild(pre, min, max, pre.length - 3);
  }

  private boolean hasOnlyChild(int[] pre, int min, int max, int index) {
    if (index < 0) return true;
    else {
      if (pre[index] < min) return hasOnlyChild(pre, pre[index], max, index - 1);
      else if (pre[index] > max) return hasOnlyChild(pre, min, pre[index], index - 1);
      else return false;
    }
  }

  /**
   * 15.
   * Problem: Two nodes of a BST are swapped, correct the BST.
   */
  private class SwapInfo {
    TreeNode prev, first, mid, last;
  }
  void correctBST(TreeNode root) {
    SwapInfo swapInfo = new SwapInfo();
    correctBST(root, swapInfo);
    if (swapInfo.first != null && swapInfo.last != null) swapNodes(swapInfo.first, swapInfo.last);
    else if (swapInfo.first != null && swapInfo.mid != null) swapNodes(swapInfo.first, swapInfo.last);
  }

  private void correctBST(TreeNode root, SwapInfo swapInfo) {
    if (root != null) {
      correctBST(root.left, swapInfo);
      if (swapInfo.prev != null && root.data < swapInfo.prev.data) {
        if (swapInfo.first == null) {
          swapInfo.first = swapInfo.prev;
          swapInfo.mid = root;
        } else swapInfo.last = root;
      }
      swapInfo.prev = root;
      correctBST(root.right, swapInfo);
    }
  }

  private void swapNodes(TreeNode node1, TreeNode node2) {
    int temp = node1.data;
    node1.data = node2.data;
    node2.data = temp;
  }

  /**
   * 16.
   * Problem: Construct BST from given preorder traversal | Set 1.
   */
  TreeNode constructTreePre(int[] pre) {
    int[] index = {0};
    return constructTreeFromPre(pre, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode constructTreeFromPre(int[] pre, int[] index, int min, int max) {
    if (index[0] >= pre.length) return null;
    else {
      TreeNode root = null;
      if (min < pre[index[0]] && pre[index[0]] < max) {
        root = new TreeNode(pre[index[0]++]);
        root.left = constructTreeFromPre(pre, index, min, root.data);
        root.right = constructTreeFromPre(pre, index, root.data, max);
      }
      return root;
    }
  }


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
   */
  void convertBSTToBT(TreeNode root) {
    int[] sum = {0};
    addGreater(root, sum);
  }

  private void addGreater(TreeNode root, int[] sum) {
    if (root != null) {
      addGreater(root.right, sum);
      sum[0] += root.data;
      root.data = sum[0];
      addGreater(root.left, sum);
    }
  }

  /**
   * 20.
   * Problem: Find if there is a triplet in a Balanced BST that adds to zero.
   */
  boolean isTripletPresent(TreeNode root) {
    TreeNode head = new TreeExamples().treeToDLL(root);
    TreeNode curr = head, tail = getLastNode(head);
    while (curr.right != tail && curr.data < 0) {
      if (hasPair(curr.right, tail, -curr.data)) return true;
      else curr = curr.right;
    }
    return false;
  }

  /**
   * 21.
   * Problem: Find a pair with given sum in a Balanced BST.
   */
  void findPairs(TreeNode root, int sum) {
    TreeNode head = new TreeExamples().treeToDLL(root);
    hasPair(head, getLastNode(root), sum);
  }

  private boolean hasPair(TreeNode low, TreeNode high, int sum) {
    while (low.data < high.data) {
      if (low.data + high.data == sum) {
        System.out.println(low.data + " " + high.data);
        return true;
      } else if (low.data + high.data < sum) low = low.right;
      else high = high.left;
    }
    return false;
  }

  class TraversalInfo {
    boolean done;
    int val;
    TreeNode curr;

    public TraversalInfo(boolean done, int val, TreeNode curr) {
      this.done = done;
      this.val = val;
      this.curr = curr;
    }
  }

  boolean findPair(TreeNode root, int sum) {
    Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
    TraversalInfo traversal1 = new TraversalInfo(false, 0, root), traversal2 = new TraversalInfo(false, 0, root);
    findNextNode(stack1, traversal1, false);
    findNextNode(stack2, traversal2, true);

    while (traversal1.val < traversal2.val) {
      if (traversal1.val + traversal2.val == sum) {
        System.out.println(traversal1.val + " " + traversal2.val);
        return true;
      } else if (traversal1.val + traversal2.val < sum) traversal1.done = false;
      else traversal2.done = false;
      findNextNode(stack1, traversal1, false);
      findNextNode(stack2, traversal2, true);
    }
    return false;
  }

  private void findNextNode(Stack<TreeNode> stack, TraversalInfo traversal, boolean reverse) {
    while (!traversal.done) {
      if (traversal.curr != null) {
        stack.push(traversal.curr);
        if (reverse) traversal.curr = traversal.curr.right;
        else traversal.curr = traversal.curr.left;
      } else {
        if (stack.isEmpty()) traversal.done = true;
        else {
          traversal.curr = stack.pop();
          traversal.val = traversal.curr.data;
          if (reverse) traversal.curr = traversal.curr.left;
          else traversal.curr = traversal.curr.right;
          traversal.done = true;
        }
      }
    }
  }


  /**
   * 22.
   * Problem: Remove BST keys outside the given range.
   */
  TreeNode removeOutsideRange(TreeNode root, int min, int max) {
    if (root == null) return null;
    else {
      root.left = removeOutsideRange(root.left, min, max);
      root.right = removeOutsideRange(root.right, min, max);
      if (root.data < min) return root.right;
      if (root.data > max) return root.left;
      return root;
    }
  }

  /**
   * 23.
   * Problem: Check for Identical BSTs without building the trees.
   * Solution:
   */

  /**
   * 24.
   * Problem: Add all greater values to every node in a given BST.
   */
  void addGreaterValues(TreeNode root) {
    convertBSTToBT(root);
  }

  /**
   * 25.
   * Problem: Binary Search Tree | Set 1 (Search and Insertion).
   */
  TreeNode search(TreeNode root, int k) {
    if (root == null || root.data == k) return root;
    else if (root.data > k) return search(root.left, k);
    else return search(root.right, k);
  }

  TreeNode insert(TreeNode root, int key) {
    if (root == null) return new TreeNode(key);
    else if (root.data > key) root.left = insert(root.left, key);
    else root.right = insert(root.right, key);
    return root;
  }

  /**
   * 26.
   * Problem: Binary Search Tree | Set 2 (Delete).
   * Solution:
   */

  TreeNode delete(TreeNode root, int key) {
    if (root != null) {
      if (root.data > key) root.left = delete(root.left, key);
      else if (root.data < key) root.right = delete(root.right, key);
      else {
        if (root.left == null) return root.right;
        else if (root.right == null) return root.left;
        else {
          root.data = minValueNode(root.right).data;
          root.right = delete(root.right, root.data);
        }
      }
    }
    return root;
  }

  /**
   * 27.
   * Problem: Transform a BST to greater sum tree.
   * Given a BST, transform it into greater sum tree where each node contains sum of all nodes greater than that node.
   */
  void greaterSumTree(TreeNode root) {
    int[] sum = {0};
    greaterSumTree(root, sum);
  }

  private void greaterSumTree(TreeNode root, int[] sum) {
    if (root != null) {
      greaterSumTree(root.right, sum);
      sum[0] += root.data;
      root.data = sum[0] - root.data;
      greaterSumTree(root.left, sum);
    }
  }

  /**
   * 28.
   * Problem: Inorder predecessor and successor for a given key in BST.
   */
  private class PreSuccessor {
    TreeNode succ, pre;
  }

  void inorderPreSuccessor(TreeNode root, int key) {
    PreSuccessor preSucc = new PreSuccessor();
    inorderPreSucc(root, preSucc, key);
    System.out.println(preSucc.pre.data + " " + preSucc.succ.data);
  }

  private void inorderPreSucc(TreeNode root, PreSuccessor preSuccessor, int key) {
    if (root != null) {
      if (root.data == key) {
        if (root.right != null) preSuccessor.succ = minValueNode(root.right);
        if (root.left != null) preSuccessor.pre = maxInBST(root.left);
      } else if (root.data > key) {
        preSuccessor.succ = root;
        inorderPreSucc(root.left, preSuccessor, key);
      } else {
        preSuccessor.pre = root;
        inorderPreSucc(root.right, preSuccessor, key);
      }
    }
  }

  private TreeNode maxInBST(TreeNode root) {
    if (root == null || root.right == null) return root;
    else return maxInBST(root.right);
  }

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
   * Problem: K'th Largest Element in BST when modification to BST is not allowed.
   */
  int kthLargestElement(TreeNode root, int[] k) {
    if (root == null) return Integer.MIN_VALUE;
    else {
      int right = kthLargestElement(root.right, k);
      if (--k[0] == 0) return root.data;
      return (right != Integer.MIN_VALUE) ? right : kthLargestElement(root.left, k);
    }
  }

  /**
   * 32.
   * Problem: Advantages of BST over Hash Table.
   * Solution:
   * Hash Table supports following operations in Θ(1) time.
   * 1) Search
   * 2) Insert
   * 3) Delete
   * The time complexity of above operations in a self-balancing Binary Search Tree (BST) (like Red-Black Tree, AVL Tree,
   * Splay Tree, etc) is O(Logn).
   * So Hash Table seems to beating BST in all common operations. When should we prefer BST over Hash Tables, what are
   * advantages. Following are some important points in favor of BSTs.
   * We can get all keys in sorted order by just doing Inorder Traversal of BST. This is not a natural operation in Hash
   * Tables and requires extra efforts.
   * Doing order statistics, finding closest lower and greater elements, doing range queries are easy to do with BSTs.
   * Like sorting, these operations are not a natural operation with Hash Tables.
   * BSTs are easy to implement compared to hashing, we can easily implement our own customized BST. To implement Hashing,
   * we generally rely on libraries provided by programming languages.
   * With BSTs, all operations are guaranteed to work in O(Logn) time. But with Hashing, Θ(1) is average time and some
   * particular operations may be costly, especially when table resizing happens.
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
   * Given a Binary Search Tree(BST), find the second largest element.
   */
  int secondLargest(TreeNode root) {
    int[] k = {2};
    return kthLargestElement(root, k);
  }

  /**
   * 36.
   * Problem: Count BST nodes that lie in a given range.
   * Given a Binary Search Tree (BST) and a range, count number of nodes that lie in the given range.
   */
  int nodesGivenRange(TreeNode root, int low, int high) {
    if (root == null) return 0;
    else {
      if (low <= root.data && root.data <= high)
        return 1 + nodesGivenRange(root.left, low, high) + nodesGivenRange(root.right, low, high);
      else if (root.data < low) return nodesGivenRange(root.right, low, high);
      else return nodesGivenRange(root.left, low, high);
    }
  }

  /**
   * 37.
   * Problem: Count BST subtrees that lie in given range.
   * Given a Binary Search Tree (BST) of integer values and a range [low, high], return count of nodes where all the nodes
   * under that node (or subtree rooted with that node) lie in the given range.
   */
  int countBSTSubtree(TreeNode root, int min, int max) {
    int[] count = {0};
    countBSTSubTree(root, count, min, max);
    return count[0];
  }

  private boolean inRange(TreeNode root, int min, int max) {
    return root.data < max && root.data > min;
  }

  private boolean countBSTSubTree(TreeNode root, int[] count, int min, int max) {
    if (root == null) return true;
    else {
      boolean left = countBSTSubTree(root.left, count, min, max);
      boolean right = countBSTSubTree(root.right, count, min, max);
      if (left && right && inRange(root, min, max)) {
        count[0]++;
        return true;
      }
      else return false;
    }
  }

  /**
   * 38.
   * Problem: K'th smallest element in BST using O(1) Extra Space.
   * Solution:
   * The idea is to use Morris Traversal. In this traversal, we first create links to Inorder successor and print the
   * data using these links, and finally revert the changes to restore original tree.
   */
  int kthSmallestSpaceEff(TreeNode root, int k) {
    int result = Integer.MIN_VALUE, count = 0;
    TreeNode prev, current = root;

    while (current != null) {
      if (current.left == null) {
        count++;
        if (k == count) result = current.data;
        current = current.right;
      } else {
        prev = new TreeExamples().getInorderPredecessor(current.left, current);
        if (prev.right == null) {
          new TreeExamples().link(prev, current);
          current = current.left;
        } else {
          new TreeExamples().unLink(prev);
          count++;
          if (k == count) result = current.data;
          current = current.right;
        }
      }
    }
    return result;
  }

  /**
   * 39.
   * Problem: Construct all possible BSTs for keys 1 to N.
   */

  /**
   * 40.
   * Problem: How to implement decrease key or change key in Binary Search Tree?.
   * Solution:
   */

  /**
   * 41.
   * Problem: Print Common Nodes in Two Binary Search Trees.
   * Given two Binary Search Trees, find common nodes in them. In other words, find intersection of two BSTs.
   * Solution: Find intersection in two sorted Arrays. (with extra space)
   * 2. Iterative inorder traversal.
   */
  void printCommonNodes(TreeNode root1, TreeNode root2) {
    Stack<TreeNode> stack1 = new Stack(), stack2 = new Stack<>();
    if (root1 == null || root2 == null) return;
    else {
      stack1.push(root1);
      stack2.push(root2);
      root1 = root1.left;
      root2 = root2.left;
    }
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      if (root1 != null) {
        stack1.push(root1);
        root1 = root1.left;
      } else if (root2 != null) {
        stack2.push(root2);
        root2 = root2.left;
      } else if (!stack1.isEmpty() && !stack2.isEmpty()) {
        root1 = stack1.peek();
        root2 = stack2.peek();

        if (root1.data == root2.data) {
          System.out.print(root1.data + " ");
          stack1.pop();
          stack2.pop();
          root1 = root1.right;
          root2 = root2.right;
        } else if (root1.data < root2.data) {
          stack1.pop();
          root1 = root1.right;
          root2 = null;
        } else {
          stack2.pop();
          root2 = root2.right;
          root1 = null;
        }
      }
    }
  }

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
   */
  void replace(int[] array) {
    TreeNode root = null;
    for (int i = array.length - 1; i >= 0; i--) {
      Successor successor = new Successor();
      root = insertWithSuccessor(root, successor, array[i]);
      if (successor.succ != null) array[i] = successor.succ.data;
      else array[i] = -1;
    }
  }

  private TreeNode insertWithSuccessor(TreeNode root, Successor successor, int key) {
    if (root == null) return new TreeNode(key);
    else if (root.data > key) {
      successor.succ = root;
      root.left = insertWithSuccessor(root.left, successor, key);
    }else root.right = insertWithSuccessor(root.right, successor, key);
    return root;
  }

  /**
   * 45.
   * Problem: Check if given sorted sub-sequence exists in binary search tree.
   * Given a binary search tree and a sorted sub-sequence. the task is to check if the given sorted sub-sequence exist
   * in binary search tree or not.
   */
  boolean isContainedSeq(TreeNode root, int[] seq, int[] index) {
    if (index[0] == seq.length) return true;
    else if (root == null) return false;
    else {
      if (isContainedSeq(root.left, seq, index)) return true;
      if (seq[index[0]] == root.data) index[0]++;
      return isContainedSeq(root.right, seq, index);
    }
  }

  /**
   * 46.
   * Problem: Find pairs with given sum such that pair elements lie in different BSTs.
   */
  void printPairs(TreeNode root1, TreeNode root2, int sum) {
    TreeNode head1 = new TreeExamples().treeToDLL(root1);
    TreeNode head2 = new TreeExamples().treeToDLL(root2);
    TreeNode low = head1, high = getLastNode(head2);

    while (low != null && high != null) {
      if (low.data + high.data == sum) {
        System.out.print("(" + low.data + " " + high.data + ")" + " ");
        low = low.right;
        high = high.left;
      } else if (low.data + high.data < sum) low = low.right;
      else high = high.left;
    }
  }

  private TreeNode getLastNode(TreeNode node) {
    while (node.right != null) node = node.right;
    return node;
  }

  /**
   * 47.
   * Problem: Find the closest element in Binary Search Tree.
   * Given a binary search tree and a target node K. The task is to find the node with minimum absolute difference with
   * given target value K.
   */
  int closetElement(TreeNode root, int key, int minDiff, int result) {
    if (root == null) return result;
    else if (root.data == key) return key;
    else if (root.data > key) {
      if (isValid(minDiff, root.data - key)) return closetElement(root.left, key, Math.abs(root.data - key), root.data);
      else return closetElement(root.left, key, minDiff, result);
    } else {
      if (isValid(minDiff, root.data - key))
        return closetElement(root.right, key, Math.abs(root.data - key), root.data);
      else return closetElement(root.right, key, minDiff, result);
    }
  }

  private boolean isValid(int x, int y) {
    return (x > Math.abs(y)) ? true : false;
  }

  /**
   * 48.
   * Problem: Check whether BST contains Dead End or not
   * Given a Binary search Tree that contains positive integer values greater then 0. The task is to check whether the
   * BST contains a dead end or not. Here Dead End means, we are not able to insert any element after that node.
   */
  boolean isDeadEnd(TreeNode root) {
    HashSet<Integer> nodes = new HashSet<>(), leafNodes = new HashSet<>();
    nodes.add(0);
    insertBSTNodes(root, nodes, leafNodes);
    for (Integer leafNode : leafNodes) if (nodes.contains(leafNode + 1) && nodes.contains(leafNode - 1)) return true;
    return false;
  }

  private void insertBSTNodes(TreeNode root, HashSet<Integer> nodes, HashSet<Integer> leafNodes) {
    if (root != null) {
      nodes.add(root.data);
      if (new TreeExamples().isLeaf(root)) leafNodes.add(root.data);
      insertBSTNodes(root.left, nodes, leafNodes);
      insertBSTNodes(root.right, nodes, leafNodes);
    }
  }

  /**
   * 49.
   * Problem: Sum of k smallest elements in BST.
   * Given Binary Search Tree. The task is to find sum of all elements smaller than and equal to Kth smallest element.
   */
  int kSmallestSum(TreeNode root, int[] sum, int[] k) {
    if (root == null) return 0;
    else {
      int left = kSmallestSum(root.left, sum, k);
      if (--k[0] == 0) return sum[0] + root.data;
      sum[0] += root.data;
      return (left != 0) ? left : kSmallestSum(root.right, sum, k);
    }

  }

  /**
   * 50.
   * Problem: Maximum element between two nodes of BST.
   * Given an array of N elements and two integers A, B which belongs to the given array. Create a Binary Search Tree by
   * inserting element from arr[0] to arr[n-1]. The task is to find the maximum element in the path from A to B.
   */
  int maxValueNode(TreeNode root, int key1, int key2) {
    TreeNode lca = new TreeExamples().bstLCA(root, key1, key2);
    return Math.max(maxInPath(lca, key1, Integer.MIN_VALUE), maxInPath(lca, key2, Integer.MIN_VALUE));
  }

  private int maxInPath(TreeNode root, int key, int max) {
    if (root.data == key) return Math.max(max, key);
    else if (root.data > key) return maxInPath(root.left, key, Math.max(root.data, max));
    else return maxInPath(root.right, key, Math.max(root.data, max));
  }


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
   */
  public class Info {
    public int size, max, min, bstSoFar;
    boolean isBST;

    Info(int size, int max, int min, int bstSoFar, boolean isBST) {
      this.size = size;
      this.max = max;
      this.min = min;
      this.bstSoFar = bstSoFar;
      this.isBST = isBST;
    }
  }

  public Info largestBSTinBT(TreeNode root) {
    if (root == null) return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
    else if (new TreeExamples().isLeaf(root)) return new Info(1, root.data, root.data, 1, true);
    else {
      Info left = largestBSTinBT(root.left);
      Info right = largestBSTinBT(root.right);
      if (left.isBST && right.isBST && inRange(root, left.max, right.min))
        return new Info(1 + left.size + right.size, Math.min(left.min, Math.min(right.min, root.data)),
                Math.max(root.data, Math.max(left.max, right.max)), 1 + left.size + right.size, true);
      else return new Info(1 + left.size + right.size, 0, 0, Math.max(left.bstSoFar, right.bstSoFar), false);
    }
  }

  /**
   * 54.
   * Problem: Threaded Binary Search Tree | Deletion.
   * Solution:
   */

  /**
   * 55.
   * Problem: Leaf nodes from Preorder of a Binary Search Tree.
   * Given a Preorder traversal of a Binary Search Tree. The task is to print leaf nodes of the Binary Search Tree from
   * the given preorder.
   */


  /**
   * 56.
   * Problem: Find median of BST in O(n) time and O(1) space.
   * Solution:
   * 1- Count the no. of nodes in the given BST using Morris Inorder Traversal.
   * 2- Then Perform Morris Inorder traversal one more time by counting nodes and by checking if count is equal to the median point.
   * To consider even no. of nodes an extra pointer pointing to the previous node is used
   */
  int findMedian(TreeNode root) {
    int count = getNodesCount(root);
    TreeNode prev = null, pre, current = root;
    int countSoFar = 1;
    while (current != null) {
      if (current.left == null) {
        if (isOddMedian(count, countSoFar)) return current.data;
        else if (isEvenMedian(count, countSoFar)) return (prev.data + current.data) / 2;
        countSoFar++;
        prev = current;
        current = current.right;
      } else {
        pre = new TreeExamples().getInorderPredecessor(current.left, current);
        if (pre.right == null) {
          new TreeExamples().link(pre, current);
          current = current.left;
        } else {
          new TreeExamples().unLink(pre);
          if (isOddMedian(count, countSoFar)) return current.data;
          else if (isEvenMedian(count, countSoFar)) return (prev.data + current.data) / 2;
          countSoFar++;
          prev = current;
          current = current.right;
        }
      }
    }
    return 0;
  }

  private boolean isOddMedian(int count, int countSoFar) {
    return count % 2 != 0 && countSoFar == (count + 1) / 2;
  }

  private boolean isEvenMedian(int count, int countSoFar) {
    return count % 2 == 0 && countSoFar == (count / 2) + 1;
  }


  private int getNodesCount(TreeNode root) {
    int count = 0;
    TreeNode prev, current = root;
    while (current != null) {
      if (current.left == null) {
        count++;
        current = current.right;
      } else {
        prev = new TreeExamples().getInorderPredecessor(current.left, current);
        if (prev.right == null) {
          new TreeExamples().link(prev, current);
          current = current.left;
        } else {
          new TreeExamples().unLink(prev);
          count++;
          current = current.right;
        }
      }
    }
    return count;
  }


  /**
   * 57.
   * Problem: Convert BST to Min Heap.
   * Given a binary search tree which is also a complete binary tree. The problem is to convert the given BST into a Min
   * Heap with the condition that all the values in the left subtree of a node should be less than all the values in the
   * right subtree of the node. This condition is applied on all the nodes in the so converted Min Heap.
   */
  TreeNode bstToMinHeap(TreeNode root) {
    ArrayList arrayList = bstToArray(root);
    convertBstToMinHeap(root, arrayList);
    return root;
  }

  private void convertBstToMinHeap(TreeNode root, ArrayList<Integer> arrayList) {
    if (root != null) {
      root.data = arrayList.remove(0);
      convertBstToMinHeap(root.left, arrayList);
      convertBstToMinHeap(root.right, arrayList);
    }

  }

  public ArrayList bstToArray(TreeNode root) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    convertBstToArray(root, arrayList);
    return arrayList;
  }

  private void convertBstToArray(TreeNode root, ArrayList<Integer> arrayList) {
    if (root != null) {
      convertBstToArray(root.left, arrayList);
      arrayList.add(root.data);
      convertBstToArray(root.right, arrayList);
    }
  }

  /**
   * 58.
   * Problem: Check if an array represents Inorder of Binary Search tree or not.
   * Solution:
   */

  /**
   * 59.
   * Problem: Largest number in BST which is less than or equal to N.
   */
  int findMaxForN(TreeNode root, int key) {
    if (root == null || new TreeExamples().isLeaf(root) && root.data > key) return -1;
    else if (root.data <= key && root.right == null || root.data <= key && root.right.data > key) return root.data;
    else if (root.data > key) return findMaxForN(root.left, key);
    else return findMaxForN(root.right, key);
  }


  /**
   * 60.
   * Problem: Remove all leaf nodes from the binary search tree.
   */
  TreeNode removeLeafNodes(TreeNode root) {
    if (root == null || new TreeExamples().isLeaf(root)) return null;
    else {
      root.left = removeLeafNodes(root.left);
      root.right = removeLeafNodes(root.right);
      return root;
    }
  }

  /**
   * 61.
   * Problem: Count pairs from two BSTs whose sum is equal to a given value x.
   */
  int countPairs(TreeNode root1, TreeNode root2, int sum) {
    int count = 0;
    TreeNode head1 = new TreeExamples().treeToDLL(root1);
    TreeNode head2 = new TreeExamples().treeToDLL(root2);
    TreeNode low = head1, high = getLastNode(head2);

    while (low != null && high != null) {
      if (low.data + high.data == sum) {
        count++;
        low = low.right;
        high = high.left;
      } else if (low.data + high.data < sum) low = low.right;
      else high = high.left;
    }
    return count;
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
