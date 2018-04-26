package data.structures.linkedlists;

import utilities.FlattenListNode;
import utilities.ListNode;
import utilities.TreeNode;

import java.util.HashSet;
import java.util.List;

public class ListExample {

  /**
   * 17. Problem: Remove duplicates from a sorted linked list. Solution: Traverse the list from the
   * head (or start) node. While traversing, compare each node with its next node. If data of next
   * node is same as current node then delete the next node. Before we delete a node, we need to
   * store next pointer of the node.
   */
  ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    else {
      ListNode p = head;
      while (p != null && p.next != null) {
        if (p.data == p.next.data) p.next = p.next.next;
        else p = p.next;
      }
      return head;
    }
  }

  /** 18. Problem: Remove duplicates from an unsorted linked list. Solution: Use HashSet. */
  ListNode removeDuplicatesUnsorted(ListNode head) {
    HashSet<Integer> set = new HashSet<>();
    ListNode prev = null, current = head;
    while (current != null) {
      if (set.contains(current.data)) prev.next = current.next;
      else {
        set.add(current.data);
        prev = current;
      }
      current = prev.next;
    }
    return head;
  }

  /**
   * 24. Problem: Intersection of two Sorted Linked Lists. Given two lists sorted in increasing
   * order, create and return a new list representing the intersection of the two lists. The new
   * list should be made with its own memory — the original lists should not be changed For example,
   * let the first linked list be 1->2->3->4->6 and second linked list be 2->4->6->8, then your
   * function should create and return a third list as 2->4->6. Solution:
   */
  ListNode intersectionOfLists(ListNode head1, ListNode head2) {
    ListNode current1 = head1, current2 = head2, head = null, tail = null;
    while (current1 != null && current2 != null) {
      if (current1.data < current2.data) current1 = current1.next;
      else if (current2.data < current1.data) current2 = current1.next;
      else {
        if (head == null) {
          head = new ListNode(current1.data);
          tail = head;
        } else tail = insertAtEnd(tail, current1.data);
        current1 = current1.next;
        current2 = current2.next;
      }
    }
    return head;
  }

  private ListNode insertAtEnd(ListNode tail, int data) {
    tail.next = new ListNode(data);
    tail = tail.next;
    return tail;
  }

  ListNode intersectionOfListRec(ListNode node1, ListNode node2) {
    if (node1 == null || node2 == null) return null;
    else if (node1.data < node2.data) return intersectionOfListRec(node1.next, node2);
    else if (node1.data > node2.data) return intersectionOfListRec(node1, node2.next);
    else {
      ListNode newNode = new ListNode(node1.data);
      newNode.next = intersectionOfListRec(node1.next, node2.next);
      return newNode;
    }
  }

  /** 28. Problem: Identical Linked Lists. Solution: */
  ListNode sortedMerge1(ListNode a, ListNode b) {
    ListNode result = null;
    if (a == null) return b;
    if (b == null) return a;

    if (a.data <= b.data) {
      result = a;
      result.next = sortedMerge1(a.next, b);
    } else {
      result = b;
      result.next = sortedMerge1(a, b.next);
    }
    return result;
  }

  /** 30. Problem: Reverse a Linked List in groups of given size Solution: */
  ListNode sortKNodes(ListNode head, int k) {
    if (size(head) <= k) return mergeSort(head);
    else {
      ListNode kthNode;
      //      for (int i = 0; i < k - 1; i++) rest = rest.next;
      kthNode = getNthNodeRec(head, k - 1);

      ListNode tail = sortKNodes(kthNode.next, k);
      kthNode.next = null;
      ListNode newHead = mergeSort(head);
      ListNode temp = newHead;
      while (temp.next != null) temp = temp.next;
      temp.next = tail;
      return newHead;
    }
  }

  /**
   * 31. Problem: Linked List vs Array Solution: Both Arrays and Linked List can be used to store
   * linear data of similar types, but they both have some advantages and disadvantages over each
   * other. (1) The size of the arrays is fixed: 2) Inserting a new element in an array of elements
   * is expensive Linked list provides following two advantages over arrays 1) Dynamic size 2) Ease
   * of insertion/deletion
   *
   * <p>Linked lists have following drawbacks: 1) Random access is not allowed. 2) Extra memory
   * space for a pointer is required with each element of the list. 3) Arrays have better cache
   * locality that can make a pretty big difference in performance.
   */

  /** 32. Problem: Sorted insert for circular linked list Solution: */

  /** 33. Problem: Reverse alternate K nodes in a Singly Linked List Solution: */

  /**
   * 34. Problem: Delete nodes which have a greater value on right side. The list
   * 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL Solution: 1. Reverse
   * the list. 2. Traverse the reversed list. Keep max till now. If next node < max, then delete the
   * next node, otherwise max = next node. 3. Reverse the list again to retain the original order.
   */
  void deleteSmallerNode(ListNode head) {
    if (head == null) return;
    else {
      head = reverseList(head);
      deleteNodes(head.next, head, head.data);
      head = reverseList(head);
    }
  }

  void deleteNodes(ListNode current, ListNode prevNode, int max) {
    if (current != null) {
      if (max > current.data) {
        prevNode.next = current.next;
        current = prevNode.next;
      } else {
        prevNode = current;
        current = current.next;
        max = current.data;
      }
      deleteNodes(current.next, current, max);
    }
  }

  /**
   * 35. Problem: Segregate even and odd nodes in a Linked List Given a Linked List of integers,
   * write a function to modify the linked list such that all even numbers appear before all the odd
   * numbers in the modified linked list. Also, keep the order of even and odd numbers same. Input:
   * 17->15->8->12->10->5->4->1->7->6->NULL Output: 8->12->10->4->6->17->15->5->1->7->NULL
   */
  ListNode segregateEvenOdd(ListNode head) {
    ListNode evenStart = null;
    ListNode evenEnd = null;
    ListNode oddStart = null;
    ListNode oddEnd = null;
    ListNode currentNode = head;
    while (currentNode != null) {
      if (currentNode.data % 2 == 0) {
        if (evenStart == null) {
          evenStart = currentNode;
          evenEnd = evenStart;
        } else {
          evenEnd.next = currentNode;
          evenEnd = evenEnd.next;
        }
      } else {
        if (oddStart == null) {
          oddStart = currentNode;
          oddEnd = oddStart;
        } else {
          oddEnd.next = currentNode;
          oddEnd = oddEnd.next;
        }
      }
      currentNode = currentNode.next;
    }

    if (oddStart == null || evenStart == null) {
      return null;
    }

    evenEnd.next = oddStart;
    oddEnd.next = null;
    return evenStart;
  }

  /**
   * 36. Problem: Detect and Remove Loop in a Linked List. Solution:1) Detect Loop using Floyd’s
   * Cycle detection algo and get the pointer to a loop node. 2) Count the number of nodes in loop.
   * Let the count be k. 3) Fix one pointer to the head and another to kth node from head. 4) Move
   * both pointers at the same pace, they will meet at loop starting node. 5) Get pointer to the
   * last node of loop and make next of it as NULL.
   */
  void removeLoop(ListNode head) {
    ListNode commonPoint = findCommonPoint(head, head.next);
    int loopCount = countLoopNodes(commonPoint, commonPoint, 0);
    ListNode node1 = head, node2 = head;
    for (int i = 0; i < loopCount; i++) node1 = node1.next;
    while (node2 != node1) {
      node1 = node1.next;
      node2 = node2.next;
    }
    while (node2.next != node1) node2 = node2.next;
    node2.next = null;
  }

  ListNode findCommonPoint(ListNode fast, ListNode slow) {
    if (fast.next == null || fast.next.next == null) return null;
    if (fast == slow) return slow;
    return findCommonPoint(fast.next.next, slow.next);
  }

  int countLoopNodes(ListNode current, ListNode commonPoint, int count) {
    if (current.next == commonPoint) return 1 + count;
    else return countLoopNodes(current.next, commonPoint, count + 1);
  }

  /**
   * 41. Problem: Sorted Linked List to Balanced BST. Given a Singly Linked List which has data
   * members sorted in ascending order. Construct a Balanced Binary Search Tree which has same data
   * members as the given Linked List. Solution:Method 1 (Simple) 1) Get the Middle of the linked
   * list and make it root. 2) Recursively do same for left half and right half. a) Get the middle
   * of left half and make it left child of the root created in step 1. b) Get the middle of right
   * half and make it right child of the root created in step 1. Time complexity: O(nLogn) where n
   * is the number of nodes in LinkedList.
   */
  TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    else {
      ListNode mid = midNode(head, head);
      ListNode midNext = mid.next;
      mid.next = null;
      TreeNode root = new TreeNode(mid.data);
      root.left = sortedListToBST(head);
      root.right = sortedListToBST(midNext);
      return root;
    }
  }

  ListNode getMid(ListNode fast, ListNode slow) {
    if (fast == null || fast.next == null) return slow;
    else return getMid(fast.next.next, slow.next);
  }

  // Method 2 (Tricky)(O(n) time)

  /**
   * 46. Problem: Rotate a Linked List Given a singly linked list, rotate the linked list
   * counter-clockwise by k nodes. Where k is a given positive integer. For example, if the given
   * linked list is 10->20->30->40->50->60 and k is 4, the list should be modified to
   * 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in linked lis
   * Solution:To rotate the linked list, we need to change next of kth node to NULL, next of last
   * node to previous head node, and finally change head to (k+1)th node. So we need to get hold of
   * three nodes: kth node, (k+1)th node and last node.
   */
  ListNode rotateList(ListNode head, int k) {
    ListNode current = head, newHead, kthNode;
    for (int i = 1; i < k && current != null; i++) current = current.next;
    if (current == null) return head;
    newHead = current.next;
    kthNode = current;
    while (current.next != null) current = current.next;
    kthNode.next = null;
    current.next = head;
    return newHead;
  }

  /** 48. Problem: Add two numbers represented by linked lists | Set 2 Solution: */

  /** 50. Problem: Flatten a multilevel linked list Solution: */

  /**
   * 52. Problem: Linked List | Set 2 (Inserting a node) Solution: A node can be added in three ways
   * 1) At the front of the linked list 2) After a given node. 3) At the end of the linked list.
   */

  /** 59. Problem: C Program for Bubble Sort on Linked List. Solution: */

  /** 82. Problem: Compare two strings represented as linked lists. Solution: */

  /**
   * 83. Problem: Delete a Linked List node at a given position. Given a singly linked list and a
   * position, delete a linked list node at the given position. Example: Input: position = 1, Linked
   * List = 8->2->3->1->7 Output: Linked List = 8->3->1->7 Solution:
   */
  void deleteNodeWithPos(ListNode head, int pos) {
    if (head != null) {
      ListNode targetNode = findTargetNode(head, pos);
      if (targetNode.next != null) {
        targetNode.data = targetNode.next.data;
        targetNode = targetNode.next.next;
      }
    }
  }

  ListNode findTargetNode(ListNode head, int pos) {
    if (head.data == pos) return head;
    else return findTargetNode(head.next, pos);
  }

  /**
   * 84. Problem: Merge two sorted linked lists such that merged list is in reverse order. Given two
   * linked lists sorted in increasing order. Merge them such a way that the result list is in
   * decreasing order (reverse order). Solution:A Simple Solution is to do following. 1) Reverse
   * first list ‘a’. 2) Reverse second list ‘b’. 3) Merge two reversed lists.
   *
   * <p>How to solve without reverse, O(1) auxiliary space (in-place) and only one traversal of both
   * lists? The idea is to follow merge style process. Initialize result list as empty. Traverse
   * both lists from beginning to end. Compare current nodes of both lists and insert smaller of two
   * at the beginning of the result list
   */
  ListNode mergeReverseOrder(ListNode head1, ListNode head2, ListNode mergedList) {
    if (head1 == null && head2 == null) return mergedList;
    else if (head1 == null && head2 != null) {
      mergedList = insertAtBeg(mergedList, head2.data);
      return mergeReverseOrder(head1, head2.next, mergedList);
    } else if (head2 == null && head1 != null) {
      mergedList = insertAtBeg(mergedList, head1.data);
      return mergeReverseOrder(head1.next, head2, mergedList);
    } else if (head1.data < head2.data) {
      mergedList = insertAtBeg(mergedList, head1.data);
      return mergeReverseOrder(head1.next, head2, mergedList);
    } else {
      mergedList = insertAtBeg(mergedList, head2.data);
      mergeReverseOrder(head1, head2.next, mergedList);
    }
    return mergedList;
  }

  ListNode insertAtBeg(ListNode head, int data) {
    ListNode newNode = new ListNode(data);
    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    return head;
  }

  /** 85. Problem: LinkedList in java. Solution: */

  /**
   * 86. Problem: Delete last occurrence of an item from linked list Given a liked list and a key to
   * be deleted. Delete last occurrence of key from linked. The list may have duplicates. Examples:
   * Input: 1->2->3->5->2->10, key = 2 Output: 1->2->3->5->10 Solution:
   */
  ListNode deleteLastOcc(ListNode head, int key) {
    if (head == null || head.next == null && head.data == key) return null;
    else {
      ListNode prevOfLastOcc = null;
      prevOfLastOcc = findLastOcc(head, key, prevOfLastOcc);
      if (prevOfLastOcc != null) prevOfLastOcc.next = prevOfLastOcc.next.next;
    }
    return head;
  }

  ListNode findLastOcc(ListNode head, int key, ListNode prev) {
    if (head.next == null) return prev;
    else if (head.next.data == key) return findLastOcc(head.next, key, head);
    else return findLastOcc(head.next, key, prev);
  }

  /**
   * 87. Problem: Rearrange a linked list such that all even and odd positioned nodes are together.
   * Input: 1->2->3->4 Output: 1->3->2->4 Solution:
   */
  void rearrage(ListNode current) {
    if (current != null || current.next != null) {
      ListNode even = current.next, odd = current, evenFirst = even;
      odd = rearrangeOddEven(even.next, even, odd, 3);
      odd.next = evenFirst;
    }
  }

  ListNode rearrangeOddEven(ListNode current, ListNode even, ListNode odd, int pos) {
    if (current != null) {
      if (pos % 2 == 0) {
        even.next = current;
        even = even.next;
      } else {
        odd.next = current;
        odd = odd.next;
      }
      if (odd.next == null) even.next = null;
      odd = rearrangeOddEven(current.next, even, odd, pos + 1);
    }
    return odd;
  }

  /**
   * 123. Problem: Remove all occurrences of duplicates from a sorted Linked List Given a sorted
   * linked list, delete all nodes that have duplicate numbers (all occurrences), leaving only
   * numbers that appear once in the original list. Input : 23->28->28->35->49->49->53->53 Output :
   * 23->35 Input : 11->11->11->11->75->75 Output : empty List Solution:
   */
  ListNode removeDuplicateOcc(ListNode prevNode, ListNode currNode) {
    if (currNode != null) {
      while (currNode.next != null && prevNode.next.data == currNode.next.data)
        currNode = currNode.next;
      if (prevNode.next == currNode) prevNode = prevNode.next;
      else prevNode.next = currNode.next;
      removeDuplicateOcc(prevNode, currNode.next);
    }
    return prevNode.next;
  }

  /**
   * 124. Problem: Partitioning a linked list around a given value and If we don’t care about making
   * the elements of the list “stable” Solution:
   */

  /**
   * 125. Problem: Remove every k-th node of the linked list. Given a singly linked list, Your task
   * is to remove every K-th node of the linked list. Input : 1->2->3->4->5->6->7->8 k = 3 Output :
   * 1->2->4->5->7->8 Solution:
   */
  ListNode removeEveryKNode(ListNode head, int k) {
    ListNode prevOfKNode = getPrevOfKNode(head, k);
    if (k == 1 && prevOfKNode == null) return null;
    else if (prevOfKNode == null) return head;
    else {
      prevOfKNode.next = prevOfKNode.next.next;
      prevOfKNode.next = removeEveryKNode(prevOfKNode.next, k);
      return head;
    }
  }

  ListNode getPrevOfKNode(ListNode head, int k) {
    if (k == 1 || head == null) return null;
    else if (k > 0 && head == null) return head;
    else if (head.next == null) return null;
    else if (k == 2) return head;
    else return getPrevOfKNode(head.next, k - 1);
  }

  /** 126. Problem: Linked List representation of Disjoint Set Data Structures. Solution: */
  ListNode reverseKNodes(ListNode head, int k, int length) {
    ListNode newHead = head;
    if (head != null && head.next != null && length > k) {
      HeadTail headTail = reverseKNode(head, k);
      newHead = headTail.head;
      head.next = reverseKNodes(headTail.rest, k, length);
    }
    return newHead;
  }

  int size(ListNode head) {
    if (head == null) return 0;
    else return 1 + size(head.next);
  }

  class HeadTail {
    ListNode head, rest;
  }

  HeadTail reverseKNode(ListNode head, int k) {
    HeadTail headTail = new HeadTail();
    ListNode current = head;
    ListNode prev = null;
    ListNode nextNode = null;
    int count = 0;
    while (current != null && count < k) {
      nextNode = current.next;
      current.next = prev;
      prev = current;
      current = nextNode;
      count++;
    }
    headTail.head = prev;
    headTail.rest = nextNode;

    return headTail;
  }

  /** 1. Problem: Write a function to get Nth node in a Linked List. */
  ListNode getNthNode(ListNode current, int index) {
    while (current != null && index > 0) {
      current = current.next;
      index--;
    }
    return current;
  }

  ListNode getNthNodeRec(ListNode head, int n) {
    if (head == null || n == 0) return head;
    else return getNthNodeRec(head.next, n - 1);
  }

  /**
   * 2. Problem: Given only a pointer/reference to a node to be deleted in a singly linked list, how
   * do you delete it? Solution: Fast solution is to copy the data from the next node to the node to
   * be deleted and delete the next node. This solution doesn’t work if the node to be deleted is
   * the last node of the list. To make this solution work we can mark the end node as a dummy node.
   * But the programs/functions that are using this function should also be modified.
   */
  void deleteNodeWithRef(ListNode node) {
    if (node.next != null) {
      swapTwoNodeData(node, node.next);
      node.next = node.next.next;
    }
  }

  /** 3. Problem: Find the middle of a given linked list in C and Java. */
  ListNode midNode(ListNode head) {
    if (head == null) return head;
    else return midNode(head, head);
  }

  private ListNode midNode(ListNode slow, ListNode fast) {
    if (fast.next == null || fast.next.next == null) return slow;
    else return midNode(slow.next, fast.next.next);
  }

  /** 4. Problem: Program for nth node from the end of a Linked List. */
  ListNode nthNodeFromEnd(ListNode head, int n) {
    ListNode nthNode = getNthNodeRec(head, n - 1);
    while (!isLastNode(nthNode)) {
      head = head.next;
      nthNode = nthNode.next;
    }
    return head;
  }

  private boolean isLastNode(ListNode head) {
    return head.next == null;
  }

  /**
   * 5. Problem: Write a function to delete a Linked List. Solution: In Java, automatic garbage
   * collection happens, so deleting a linked list is easy. We just need to change head to null.
   */

  /**
   * 6. Problem: Write a function that counts the number of times a given int occurs in a Linked
   * List.
   */
  int countOccurrences(ListNode head, int key) {
    if (head == null) return 0;
    else if (head.data == key) return 1 + countOccurrences(head.next, key);
    else return countOccurrences(head.next, key);
  }

  /**
   * 7. Problem: Given only a pointer to a node to be deleted in a singly linked list, how do you
   * delete it?. Solution: Same as problem 2;
   */

  /** 8. Problem: Write a function to reverse a linked list. */
  ListNode reverseList(ListNode head) {
    ListNode current = head, previous = null, next;
    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }

  ListNode reverseListRec(ListNode head) {
    if (head == null || head.next == null) return head;
    else {
      ListNode newHead = reverseListRec(head.next);
      head.next.next = head;
      head.next = null;
      return newHead;
    }
  }

  /** 9. Problem: Java Program for Reverse a linked list. Solution: Same as problem 8. */

  /** 10. Problem: Detect loop in a linked list. */
  boolean containsLoop(ListNode head) {
    if (head == null) return false;
    else return containsLoop(head, head.next);
  }

  private boolean containsLoop(ListNode slow, ListNode fast) {
    if (fast == null || fast.next == null) return false;
    else if (slow == fast) return true;
    else return containsLoop(slow.next, fast.next.next);
  }

  /** 11. Problem: Function to check if a singly linked list is palindrome. */
  boolean isPalindrome(ListNode head) {
    ListNode midNode = midNode(head), prevOfMid = null;
    int size = size(head);
    if (size % 2 != 0) {
      prevOfMid = head;
      while (prevOfMid.next != midNode) prevOfMid = prevOfMid.next;
      prevOfMid.next = null;
    }
    ListNode secondHalf = midNode.next;
    midNode.next = null;
    ListNode newHead = reverseListRec(secondHalf);
    boolean res = compareLists(head, newHead);
    secondHalf = reverseListRec(newHead);
    if (size % 2 != 0) prevOfMid.next = midNode;
    midNode.next = secondHalf;
    return res;
  }

  private boolean compareLists(ListNode a, ListNode b) {
    while (a != null && b != null) {
      if (a.data != b.data) return false;
      else {
        a = a.next;
        b = b.next;
      }
    }
    if (a == null && b == null) return true;
    else return false;
  }

  /** 12. Problem: The Great Tree-List Recursion Problem.. Solution: */

  /** 13. Problem: Clone a linked list with next and random pointer | Set 1. Solution: */

  /** 14. Problem: Memory efficient doubly linked list. Solution: */

  /**
   * 15. Problem: Given a linked list which is sorted, how will you insert in sorted way. Solution:
   */
  ListNode sortedInsert(ListNode head, ListNode node) {
    if (head == null || head.data >= node.data) {
      node.next = head;
      return node;
    } else {
      ListNode current = head;
      while (current.next != null && current.next.data < node.data) current = current.next;
      node.next = current.next;
      current.next = node;
      return head;
    }
  }

  ListNode sortedInsertRec(ListNode head, ListNode node) {
    if (head == null || head.data >= node.data) {
      node.next = head;
      return node;
    } else {
      head.next = sortedInsertRec(head.next, node);
      return head;
    }
  }

  /** 16. Problem: Write a function to get the intersection point of two Linked Lists.. Solution: */
  ListNode findIntersectionOfLists(ListNode first, ListNode second) {
    int firstSize = size(first), secondSize = size(second);
    ListNode tempHead;
    if (firstSize > secondSize) {
      tempHead = getNthNodeRec(first, firstSize - secondSize);
      return intersection(tempHead, second);
    } else {
      tempHead = getNthNodeRec(second, secondSize - firstSize);
      return intersection(first, tempHead);
    }
  }

  private ListNode intersection(ListNode first, ListNode second) {
    if (first == null || second == null) return null;
    if (first == second) return first;
    else return intersection(first.next, second.next);
  }

  /** 17. Problem: Print reverse of a Linked List without actually reversing. */
  void printReverse(ListNode head) {
    if (head != null) {
      printReverse(head.next);
      System.out.print(head.data + " ");
    }
  }

  /** 18. Problem: Remove duplicates from a sorted linked list. Solution: */

  /** 19. Problem: Remove duplicates from an unsorted linked list. Solution: */

  /** 20. Problem: Reverse a Doubly Linked List. Solution: */

  /** 21. Problem: Split a Circular Linked List into two halves. Solution: */

  /** 22. Problem: Practice questions for Linked List and Recursion. Solution: */

  /** 23. Problem: Move last element to front of a given Linked List. */
  ListNode moveLastToFront(ListNode head) {
    ListNode current = head, prevOfLast = null;
    while (current.next != null) {
      prevOfLast = current;
      current = current.next;
    }

    prevOfLast.next = null;
    current.next = head;
    return current;
  }

  /** 24. Problem: Pairwise swap elements of a given linked list. */
  void pairwiseSwapData(ListNode head) {
    if (head != null && head.next != null) {
      swapTwoNodeData(head, head.next);
      pairwiseSwapData(head.next.next);
    }
  }

  void swapTwoNodeData(ListNode node1, ListNode node2) {
    int temp = node1.data;
    node1.data = node2.data;
    node2.data = temp;
  }

  /** 25. Problem: Delete a node in a Doubly Linked List. Solution: */

  /** 26. Problem: Intersection of two Sorted Linked Lists. Solution: */

  /** 27. Problem: Delete alternate nodes of a Linked List. */
  ListNode deleteAlternate(ListNode head) {
    if (head == null || head.next == null) return head;
    else {
      head.next = deleteAlternate(head.next.next);
      return head;
    }
  }

  /** 28. Problem: Alternating split of a given Singly Linked List | Set 1. Solution: */

  /** 29. Problem: Merge two sorted linked lists. */
  ListNode mergeLists(ListNode a, ListNode b) {
    if (a == null) return b;
    else if (b == null) return a;
    else {
      if (a.data < b.data) {
        a.next = mergeLists(a.next, b);
        return a;
      } else {
        b.next = mergeLists(a, b.next);
        return b;
      }
    }
  }

  /** 30. Problem: Identical Linked Lists. Solution: */

  /** 31. Problem: Merge Sort for Linked Lists. */
  ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) return head;
    else {
      ListNode mid = midNode(head), midNext = mid.next;
      mid.next = null;
      //      ListNode left = mergeSort(head);
      //      ListNode right = mergeSort(midNext);
      //      ListNode merge = mergeLists(left, right);
      //      return merge;
      return mergeLists(mergeSort(head), mergeSort(midNext));
    }
  }

  /** 32. Problem: Reverse a Linked List in groups of given size | Set 1. Solution: */
  ListNode reverseKNodes(ListNode head, int k) {
    if (size(head) <= k) return reverseListRec(head);
    else {
      ListNode rest = head;
      for (int i = 0; i < k - 1; i++) rest = rest.next;

      ListNode tail = reverseKNodes(rest.next, k);
      rest.next = null;
      ListNode newHead = reverseListRec(head);
      head.next = tail;
      return newHead;
    }
  }




  /** 49. Problem: Flattening a Linked List. */
  FlattenListNode flatten(FlattenListNode node) {
    if (node == null || node.next == null) return node;
    else return flattenMerge(node, flatten(node.next));
  }

  private FlattenListNode flattenMerge(FlattenListNode node1, FlattenListNode node2) {
    if (node1 == null) return node2;
    else if (node2 == null) return node1;
    else {
      if (node1.data < node2.data) {
        node1.down = flattenMerge(node1.down, node2);
        return node1;
      } else {
        node2.down = flattenMerge(node1, node2.down);
        return node2;
      }
    }
  }

  /** 50. Problem: Add two numbers represented by linked lists | Set 2. */
  private ListNode addSameSizeLists(ListNode first, ListNode second, int[] carry) {
    if (first == null) return null;
    else {
      ListNode sumListNext = addSameSizeLists(first.next, second.next, carry);
      int sum = first.data + second.data + carry[0];
      carry[0] = sum / 10;
      sum %= 10;
      ListNode sumList = new ListNode(sum);
      sumList.next = sumListNext;
      return sumList;
    }
  }

  ListNode addLists(ListNode first, ListNode second) {
    if (first == null) return second;
    else if (second == null) return first;
    else {
      int[] carry = new int[1];
      ListNode sumList;
      int firstSize = size(first), secondSize = size(second);

      if (firstSize == secondSize) sumList = addSameSizeLists(first, second, carry);
      else {
        if (firstSize < secondSize) {
          ListNode temp = first;
          first = second;
          second = temp;
        }
        ListNode current = getNthNodeRec(first, firstSize - secondSize);
        sumList = addSameSizeLists(current, second, carry);
        sumList = addCarry(first, carry, current, sumList);
      }
      if (carry[0] != 0) {
        ListNode head = new ListNode(carry[0]);
        head.next = sumList;
        return head;
      } else return sumList;
    }
  }

  private ListNode addCarry(ListNode first, int[] carry, ListNode current, ListNode sumList) {
    if (first == current) return sumList;
    else {
      addCarry(first.next, carry, current, sumList);
      int sum = first.data + carry[0];
      carry[0] = sum / 10;
      sum %= 10;
      ListNode temp = new ListNode(sum);
      temp.next = sumList;
      sumList = temp;
      return sumList;
    }
  }

  /** 51. Problem: Sort a linked list of 0s, 1s and 2s. */
  void sortList(ListNode head) {
    int[] count = new int[3];
    populateCount(head, count);
    int i = 0;
    ListNode current = head;
    while (current != null) {
      if (count[i] == 0) i++;
      else {
        current.data = i;
        count[i]--;
        current = current.next;
      }
    }
  }

  private void populateCount(ListNode head, int[] count) {
    ListNode current = head;
    while (current != null) {
      count[current.data]++;
      current = current.next;
    }
  }

  /** 52. Problem: Flatten a multilevel linked list. Solution: */

  /**
   * 53. Problem: Linked List | Set 1 (Introduction) Solution: Like arrays, Linked List is a linear
   * data structure. Unlike arrays, linked list elements are not stored at contiguous location; the
   * elements are linked using pointers.
   *
   * <p>Why Linked List? Arrays can be used to store linear data of similar types, but arrays have
   * following limitations. 1) The size of the arrays is fixed: So we must know the upper limit on
   * the number of elements in advance. Also, generally, the allocated memory is equal to the upper
   * limit irrespective of the usage. 2) Inserting a new element in an array of elements is
   * expensive, because room has to be created for the new elements and to create room existing
   * elements have to shifted.
   *
   * <p>Advantages over arrays 1) Dynamic size 2) Ease of insertion/deletion
   *
   * <p>Drawbacks: 1) Random access is not allowed. We have to access elements sequentially starting
   * from the first node. So we cannot do binary search with linked lists. 2) Extra memory space for
   * a pointer is required with each element of the list.
   */

  /** 54. Problem: Linked List | Set 2 (Inserting a node). Solution: */

  /** 55. Problem: QuickSort on Doubly Linked List. Solution: */

  /**
   * 56. Problem: Swap Kth node from beginning with Kth node from end in a Linked List. Solution:
   */

  /** 57. Problem: Delete N nodes after M nodes of a linked list. Solution: */

  /** 58. Problem: QuickSort on Singly Linked List. Solution: */

  /** 59. Problem: Merge a linked list into another linked list at alternate positions. Solution: */

  /** 60. Problem: Pairwise swap elements of a given linked list by changing links. */
  ListNode pairwiseSwap(ListNode head) {
    if (head == null || head.next == null) return head;
    else {
      ListNode tail = pairwiseSwap(head.next.next);
      head.next.next = null;
      head = reverseList(head);
      head.next.next = tail;
      return head;
    }
  }

  // For online test
  ListNode swapPairs(ListNode node) {
    ListNode head = node, newHead = null, tail = null;
    if (head == null || head.next == null) return head;
    while (head != null && head.next != null) {
      ListNode thirdNode = head.next.next;
      head.next.next = null;
      head = reverseList(head);
      head.next.next = thirdNode;
      if (newHead == null) {
        newHead = head;
        tail = head.next;
      } else {
        tail.next = head;
        tail = tail.next.next;
      }
      head = thirdNode;
    }
    return newHead;
  }



  /** 80. Problem: Insertion Sort for Singly Linked List. Solution: */
  ListNode insertSortList(ListNode head) {
    ListNode result = null, current = head;
    while (current != null) {
      ListNode nextNode = current.next;
      result = sortedInsert(result, current);
      current = nextNode;
    }
    return result;
  }


  /**
   * 110. Problem: Partitioning a linked list around a given value and keeping the original order.
   */
  ListNode partition(ListNode head, int x) {
    ListNode smallerList = null,
        smallerListTail = null,
        equalListHead = null,
        equalListTail = null,
        greaterList = null,
        greaterListTail = null;
    while (head != null) {
      if (head.data < x) {
        if (smallerList == null) smallerList = smallerListTail = head;
        else {
          smallerListTail.next = head;
          smallerListTail = head;
        }

      } else if (head.data == x) {
        if (equalListHead == null) equalListHead = equalListTail = head;
        else {
          equalListTail.next = head;
          equalListTail = head;
        }

      } else {
        if (greaterList == null) greaterListTail = greaterList = head;
        else {
          greaterListTail.next = head;
          greaterListTail = head;
        }
      }

      head = head.next;
    }

    if (greaterListTail != null) greaterListTail.next = null;

    if (smallerList == null) {
      if (equalListHead == null) return greaterList;
      else {
        equalListTail.next = greaterList;
        return equalListHead;
      }
    } else if (equalListHead == null) {
      smallerListTail.next = greaterList;
      return smallerList;
    } else {
      smallerListTail.next = equalListHead;
      equalListTail.next = greaterList;
      return smallerList;
    }
  }

  ListNode partition1(ListNode head, int x) {
    ListNode firstPartition = null,
        firstPartitionTail = null,
        secondPartition = null,
        secondPartitionTail = null;

    while (head != null) {

      if (head.data < x) {
        if (firstPartition == null) firstPartition = firstPartitionTail = head;
        else {
          firstPartitionTail.next = head;
          firstPartitionTail = head;
        }
      } else {
        if (secondPartition == null) secondPartition = secondPartitionTail = head;
        else {
          secondPartitionTail.next = head;
          secondPartitionTail = head;
        }
      }
      head = head.next;
    }
    if (secondPartitionTail != null) secondPartitionTail.next = null;
    if (firstPartition == null) return secondPartition;
    else {
      firstPartitionTail.next = secondPartition;
      return firstPartition;
    }
  }



  /** 158. Problem: Merge two sorted lists (in-place). Solution: Same as question 29. */
  public ListNode sortedMerge(ListNode head1, ListNode head2) {
    ListNode head = null, tail = null;
    while (head1 != null && head2 != null) {
      if (head1.data < head2.data) {
        if (head == null) {
          head = head1;
          tail = head1;
        } else tail = insertAtLast(tail, head1);
        head1 = head1.next;
      } else {
        if (head == null) {
          head = head2;
          tail = head2;
        } else tail = insertAtLast(tail, head2);
        head2 = head2.next;
      }
    }
    if (head1 != null) tail.next = head1;
    if (head2 != null) tail.next = head2;
    return head;
  }

  ListNode insertAtLast(ListNode tail, ListNode head) {
    tail.next = head;
    tail = tail.next;
    return tail;
  }



  /** 1. Problem: Write a function to get Nth node in a Linked List. */

  /** 2. Problem: Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?. */

  /** 3. Problem: Find the middle of a given linked list in C and Java. */

  /** 4. Problem: Program for n&#8217;th node from the end of a Linked List. */

  /** 5. Problem: Write a function to delete a Linked List. */

  /** 6. Problem: Write a function that counts the number of times a given int occurs in a Linked List. */

  /** 7. Problem: Given only a pointer to a node to be deleted in a singly linked list, how do you delete it?. */

  /** 8. Problem: Reverse a linked list. */

  /** 9. Problem: Java Program for Reverse a linked list. */

  /** 10. Problem: Detect loop in a linked list. */

  /** 11. Problem: Function to check if a singly linked list is palindrome. */

  /** 12. Problem: The Great Tree-List Recursion Problem.. */

  /** 13. Problem: Clone a linked list with next and random pointer | Set 1. */

  /** 14. Problem: Memory efficient doubly linked list. */

  /** 15. Problem: Given a linked list which is sorted, how will you insert in sorted way. */

  /** 16. Problem: Write a function to get the intersection point of two Linked Lists.. */

  /** 17. Problem: Print reverse of a Linked List without actually reversing. */

  /** 18. Problem: Remove duplicates from a sorted linked list. */

  /** 19. Problem: Remove duplicates from an unsorted linked list. */

  /** 20. Problem: Reverse a Doubly Linked List. */

  /** 21. Problem: Split a Circular Linked List into two halves. */

  /** 22. Problem: Practice questions for Linked List and Recursion. */

  /** 23. Problem: Move last element to front of a given Linked List. */

  /** 24. Problem: Pairwise swap elements of a given linked list. */

  /** 25. Problem: Delete a node in a Doubly Linked List. */

  /** 26. Problem: Intersection of two Sorted Linked Lists. */

  /** 27. Problem: Delete alternate nodes of a Linked List. */

  /** 28. Problem: Alternating split of a given Singly Linked List | Set 1. */

  /** 29. Problem: Merge two sorted linked lists. */

  /** 30. Problem: Identical Linked Lists. */

  /** 31. Problem: Merge Sort for Linked Lists. */

  /** 32. Problem: Reverse a Linked List in groups of given size | Set 1. */

  /** 33. Problem: Linked List vs Array. */

  /** 34. Problem: Sorted insert for circular linked list. */

  /** 35. Problem: Reverse alternate K nodes in a Singly Linked List. */

  /** 36. Problem: Delete nodes which have a greater value on right side. */

  /** 37. Problem: Segregate even and odd nodes in a Linked List. */

  /** 38. Problem: Detect and Remove Loop in a Linked List. */

  /** 39. Problem: XOR Linked List &#8211; A Memory Efficient Doubly Linked List  | Set 1. */

  /** 40. Problem: Add two numbers represented by linked lists | Set 1. */

  /** 41. Problem: How to write C functions that modify head pointer of a Linked List?. */

  /** 42. Problem: Delete a given node in Linked List under given constraints. */

  /** 43. Problem: Sorted Linked List to Balanced BST. */

  /** 44. Problem: In-place conversion of Sorted DLL to Balanced BST. */

  /** 45. Problem: Union and Intersection of two Linked Lists. */

  /** 46. Problem: XOR Linked List – A Memory Efficient Doubly Linked List | Set 2. */

  /** 47. Problem: Find a triplet from three linked lists with sum equal to a given number. */

  /** 48. Problem: Rotate a Linked List. */

  /** 49. Problem: Flattening a Linked List. */

  /** 50. Problem: Add two numbers represented by linked lists | Set 2. */

  /** 51. Problem: Sort a linked list of 0s, 1s and 2s. */

  /** 52. Problem: Flatten a multilevel linked list. */

  /** 53. Problem: Linked List | Set 1 (Introduction). */

  /** 54. Problem: Linked List | Set 2 (Inserting a node). */

  /** 55. Problem: QuickSort on Doubly Linked List. */

  /** 56. Problem: Swap Kth node from beginning with Kth node from end in a Linked List. */

  /** 57. Problem: Delete N nodes after M nodes of a linked list. */

  /** 58. Problem: QuickSort on Singly Linked List. */

  /** 59. Problem: Merge a linked list into another linked list at alternate positions. */

  /** 60. Problem: Pairwise swap elements of a given linked list by changing links. */

  /** 61. Problem: C Program for Bubble Sort on Linked List. */

  /** 62. Problem: Queue | Set 2 (Linked List Implementation). */

  /** 63. Problem: Given a linked list, reverse alternate nodes and append at the end. */

  /** 64. Problem: Doubly Linked List  | Set 1 (Introduction and Insertion). */

  /** 65. Problem: Circular Linked List | Set 1 (Introduction and Applications). */

  /** 66. Problem: Circular Linked List | Set 2 (Traversal). */

  /** 67. Problem: Linked List | Set 3 (Deleting a node). */

  /** 68. Problem: A Programmer&#8217;s approach of looking at Array vs. Linked List. */

  /** 69. Problem: Can we reverse a linked list in less than O(n)?. */

  /** 70. Problem: Delete all occurrences of a given key in a linked list. */

  /** 71. Problem: Construct a Maximum Sum Linked List out of two Sorted Linked Lists having some Common nodes. */

  /** 72. Problem: Given a linked list of line segments, remove middle points. */

  /** 73. Problem: Clone a linked list with next and random pointer | Set 2. */

  /** 74. Problem: Find Length of a Linked List (Iterative and Recursive). */

  /** 75. Problem: Search an element in a Linked List (Iterative and Recursive). */

  /** 76. Problem: Generic Linked List in C. */

  /** 77. Problem: Swap nodes in a linked list without swapping data. */

  /** 78. Problem: Point to next higher value node in a linked list with an arbitrary pointer. */

  /** 79. Problem: Merge Sort for Doubly Linked List. */

  /** 80. Problem: Insertion Sort for Singly Linked List. */

  /** 81. Problem: Select a Random Node from a Singly Linked List. */

  /** 82. Problem: Sort a linked list that is sorted alternating ascending and descending orders?. */

  /** 83. Problem: Rearrange a given linked list in-place.. */

  /** 84. Problem: Compare two strings represented as linked lists. */

  /** 85. Problem: Delete a Linked List node at a given position. */

  /** 86. Problem: Merge two sorted linked lists such that merged list is in reverse order. */

  /** 87. Problem: LinkedList in java. */

  /** 88. Problem: Delete last occurrence of an item from linked list. */

  /** 89. Problem: Rearrange a linked list such that all even and odd positioned nodes are together. */

  /** 90. Problem: Rearrange a Linked List in Zig-Zag fashion. */

  /** 91. Problem: Add 1 to a number represented as linked list. */

  /** 92. Problem: Point arbit pointer to greatest value right side node in a linked list. */

  /** 93. Problem: Check if a linked list of strings forms a palindrome. */

  /** 94. Problem: Convert a given Binary Tree to Doubly Linked List | Set 4. */

  /** 95. Problem: Sort linked list which is already sorted on absolute values. */

  /** 96. Problem: Create a Doubly Linked List from a Ternary Tree. */

  /** 97. Problem: In-place Merge two linked lists without changing links of first list. */

  /** 98. Problem: Delete middle of linked list. */

  /** 99. Problem: Check if a linked list is Circular Linked List. */

  /** 100. Problem: Merge K sorted linked lists | Set 1. */

  /** 101. Problem: Decimal Equivalent of Binary Linked List. */

  /** 102. Problem: Flatten a multi-level linked list | Set 2 (Depth wise). */

  /** 103. Problem: Rearrange a given list such that it consists of alternating minimum maximum elements. */

  /** 104. Problem: Subtract Two Numbers represented as Linked Lists. */

  /** 105. Problem: Convert a Binary Tree to a Circular Doubly Link List. */

  /** 106. Problem: Unrolled Linked List | Set 1 (Introduction). */

  /** 107. Problem: Find pairs with given sum in doubly linked list. */

  /** 108. Problem: Find pair for given sum  in a sorted singly linked without extra space. */

  /** 109. Problem: Iteratively Reverse a linked list using only 2 pointers  (An Interesting Method). */

  /** 110. Problem: Partitioning a linked list around a given value and keeping the original order. */

  /** 111. Problem: Sublist Search (Search a linked list in another list). */

  /** 112. Problem: Check linked list with a loop is palindrome or not. */

  /** 113. Problem: Clone a linked list with next and random pointer in O(1) space. */

  /** 114. Problem: Length of longest palindrome list in a linked list using O(1) extra space. */

  /** 115. Problem: Adding two polynomials using Linked List. */

  /** 116. Problem: Circular Singly Linked List | Insertion. */

  /** 117. Problem: Check if a doubly linked list of characters is palindrome or not. */

  /** 118. Problem: Implementing Iterator pattern of a single Linked List. */

  /** 119. Problem: Move all occurrences of an element to end in a linked list. */

  /** 120. Problem: Deletion from a Circular Linked List. */

  /** 121. Problem: Doubly Circular Linked List | Set 1 (Introduction and Insertion). */

  /** 122. Problem: Doubly Circular Linked List | Set 2 (Deletion). */

  /** 123. Problem: Circular Queue | Set 2 (Circular Linked List Implementation). */

  /** 124. Problem: Top 20 Linked List Interview Question. */

  /** 125. Problem: Remove all occurrences of duplicates from a sorted Linked List. */

  /** 126. Problem: Partitioning a linked list around a given value and If we don&#8217;t care about making the elements of the list &#8220;stable&#8221;. */

  /** 127. Problem: Remove every k-th node of the linked list. */

  /** 128. Problem: Linked List representation of Disjoint Set Data Structures. */

  /** 129. Problem: Check whether the length of given linked list is Even or Odd. */

  /** 130. Problem: Union and Intersection of two linked lists | Set-2 (Using Merge Sort). */

  /** 131. Problem: Multiply two numbers represented by Linked Lists. */

  /** 132. Problem: Union and Intersection of two linked lists | Set-3 (Hashing). */

  /** 133. Problem: Modify contents of Linked List. */

  /** 134. Problem: Arrange consonants and vowels nodes in a linked list. */

  /** 135. Problem: Find the sum of last n nodes of the given Linked List. */

  /** 136. Problem: Count pairs from two linked lists whose sum is equal to a given value. */

  /** 137. Problem: Skip List | Set 2 (Insertion). */

  /** 138. Problem: Insert value in sorted way in a sorted doubly linked list. */

  /** 139. Problem: Delete a Doubly Linked List node at a given position. */

  /** 140. Problem: Skip List | Set 3 (Searching and Deletion). */

  /** 141. Problem: Count triplets in a sorted doubly linked list whose sum is equal to a given value x. */

  /** 142. Problem: Merge k sorted linked lists | Set 2 (Using Min Heap). */

  /** 143. Problem: Remove duplicates from a sorted doubly linked list. */

  /** 144. Problem: Delete all occurrences of a given key in a doubly linked list. */

  /** 145. Problem: Remove duplicates from an unsorted doubly linked list. */

  /** 146. Problem: Sort the biotonic doubly linked list. */

  /** 147. Problem: Sort a k sorted doubly linked list. */

  /** 148. Problem: Recursive selection sort for singly linked list | Swapping node links. */

  /** 149. Problem: Squareroot(n)-th node in a Linked List. */

  /** 150. Problem: An interesting method to print reverse of a linked list. */

  /** 151. Problem: Find length of loop in linked list. */

  /** 152. Problem: Count nodes in Circular linked list. */

  /** 153. Problem: Reverse a Linked List in groups of given size | Set 2. */

  /** 154. Problem: Find the fractional (or n/k &#8211; th) node in linked list. */

  /** 155. Problem: Find modular node in a linked list. */

  /** 156. Problem: Construct a linked list from 2D matrix. */

  /** 157. Problem: Insert node into the middle of the linked list. */

  /** 158. Problem: Merge two sorted lists (in-place). */

  /** 159. Problem: Sort a linked list of 0s, 1s and 2s by changing links. */

  /** 160. Problem: Insert a node after the n-th node from the end. */

  /** 161. Problem: Josephus Circle using circular linked list. */

  /** 162. Problem: Rotate Linked List block wise. */

  /** 163. Problem: Convert singly linked list into circular linked list. */

  /** 164. Problem: Count rotations in sorted and rotated linked list. */

  /** 165. Problem: Make middle node head in a linked list. */

  /** 166. Problem: Reverse a stack without using extra space in O(n). */

  /** 167. Problem: Find smallest and largest elements in singly linked list. */

  /** 168. Problem: Replace nodes with duplicates in linked list. */

  /** 169. Problem: Longest increasing sublist in a linked list. */

  /** 170. Problem: Reverse a sublist of linked list. */

  /** 171. Problem: Reverse a circular linked list. */

  /** 172. Problem: Recursive function to delete k-th node from linked list. */

  /** 173. Problem: Exchange first and last nodes in Circular Linked List. */

  /** 174. Problem: Recursive insertion and traversal linked list. */

  /** 175. Problem: Linked List Sum of Nodes Between 0s. */

  /** 176. Problem: Multiply two numbers represented as linked lists into a third list. */

  /** 177. Problem: Alternate sorting of Linked list. */

  /** 178. Problem: Implementation of Deque using doubly linked list. */

  /** 179. Problem: Find the largest node in Doubly linked list. */

  /** 180. Problem: Modify and Rearrange List. */

  /** 181. Problem: Reverse a Doubly Linked List | Set-2. */

  /** 182. Problem: First common element in two linked lists. */

  /** 183. Problem: Print reverse of a Linked List without extra space and modifications. */

  /** 184. Problem: Reverse first K elements of given linked list. */

  /** 185. Problem: Print Reverse a linked list using Stack. */

  /** 186. Problem: First non-repeating in a linked list. */

  /** 187. Problem: Insert a whole linked list into other at k-th position. */

  /** 188. Problem: Reverse a Doubly linked list using recursion. */

  /** 189. Problem: Sorted merge of two sorted doubly circular linked lists. */

  /** 190. Problem: Reverse a Doubly Linked List | Set 4 (Swapping Data). */

  /** 191. Problem: Self Organizing List : Move to Front Method. */

  /** 192. Problem: Self Organizing List : Count Method. */

  /** 193. Problem: Make a loop at k-th position in a linked list. */

  /** 194. Problem: Delete a linked list using recursion. */

  /** 195. Problem: Brent&#8217;s Cycle Detection Algorithm. */

  /** 196. Problem: Rearrange a linked list in to alternate first and last element. */

  /** 197. Problem: Reverse a doubly linked list in groups of given size. */

  /** 198. Problem: Linked List Pair Sum. */
  void printPairs(ListNode head, int sum) {
    HashSet<Integer> set = new HashSet<>();
    while (head != null) {
      if (set.contains(sum - head.data)) System.out.println(  (sum - head.data) + " " + head.data);
      else set.add(head.data);
      head = head.next;
    }
  }

  /** 199. Problem: Print alternate nodes of a linked list using recursion. */

  /** 200. Problem: Majority element in a linked list. */
  int findMajorityElement(ListNode head) {
    int candidate = getCandidate(head);
    return isMajority(head, candidate, 0);

  }

  private int getCandidate(ListNode head) {
    if (head == null) return Integer.MIN_VALUE;
    else {
      int candidate = head.data;
      int votes = 1;
      ListNode current = head.next;
      while (current != null) {
        if (current.data == candidate) votes++;
        else {
          votes--;
          if (votes == 0) {
            candidate = current.data;
            votes = 1;
          }
        }
        current = current.next;
      }
      return candidate;
    }
  }

  private int isMajority(ListNode head, int candidate, int count) {
    if (head == null) return Integer.MIN_VALUE;
    else if (count >= size(head)) return candidate;
    else if (head.data == candidate) return isMajority(head.next, candidate, count + 1);
    else return isMajority(head.next, candidate, count);
  }

  /** 201. Problem: Alternate Odd and Even Nodes in a Singly Linked List. */

  /** 202. Problem: Print the alternate nodes of linked list (Iterative Method). */

  /** 203. Problem: Recursive approach for alternating split of Linked List. */

  /** 204. Problem: Priority Queue using Linked List. */

  /** 205. Problem: Priority Queue using doubly linked list. */

  /** 206. Problem: Move all zeros to the front of the linked list. */

  /** 207. Problem: Iterative approach for removing middle points in a linked list of line segements. */

  /** 208. Problem: Maximum occurring character in a linked list. */

  /** 209. Problem: Find common elements in three linked lists. */

  /** 210. Problem: Find middle of singly linked list Recursively. */

  /** 211. Problem: Insertion in Unrolled Linked List. */

  /** 212. Problem: Reverse each word in a linked list node. */

  /** 213. Problem: Sort the linked list in the order of elements appearing in the array. */

  /** 214. Problem: Rotate Doubly linked list by N nodes. */

  /** 215. Problem: Lucky alive person in a circle | Code Solution to sword puzzle. */

  /** 216. Problem: Binary Search on Singly Linked List. */

  /** 217. Problem: C Program to reverse each node value in Singly Linked List. */

  /** 218. Problem: Longest common suffix of two linked lists. */

  /** 219. Problem: Large number arithmetic using doubly linked list. */

  /** 220. Problem: Data Structure design to perform required operations. */

  /** 221. Problem: Double elements and append zeros in linked list. */

  /** 222. Problem: Sorted insert in a doubly linked list with head and tail pointers. */

  /** 223. Problem: Find unique elements in linked list. */

  /** 224. Problem: Check if linked list is sorted (Iterative and Recursive). */

  /** 225. Problem: Delete all the nodes from the list that are greater than x. */

  /** 226. Problem: Remove duplicates from a sorted linked list using recursion. */

  /** 227. Problem: Program to find size of Doubly Linked List. */
}
