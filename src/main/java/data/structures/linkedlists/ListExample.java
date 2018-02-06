package data.structures.linkedlists;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import utilities.ListNode;
import utilities.TreeNode;

import java.util.HashSet;
import java.util.List;


public class ListExample {

  /**
   * 1.
   * Problem: Write a function to get Nth node in a Linked List.
   */
  ListNode getNthNode(ListNode head, int index) {
    ListNode current = head;
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
   * 2.
   * Problem: Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
   * Solution: Fast solution is to copy the data from the next node to the node to be deleted and delete the next node.
   */

  /**
   * 3.
   * Problem: Find the middle of a given linked list.
   * Solution: Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
   * When the fast pointer reaches end slow pointer will reach middle of the linked list.
   */

  /**
   * 4.
   * Problem: Find n’th node from the end of a Linked List.
   * Solution: Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers
   * to head. First move reference pointer to n nodes from head. Now move both pointers one by one until reference
   * pointer reaches end. Now main pointer will point to nth node from the end. Return main pointer.
   */

  /**
   * 5.
   * Problem: Write a function to delete a Linked List.
   * Solution:
   * Algorithm For C/C++: Iterate through the linked list and delete all the nodes one by one. Main point here is not
   * to access next of the current pointer if current pointer is deleted.
   * In Java: Automatic garbage collection happens, so deleting a linked list is easy. We just need to change head to
   * null.
   */

  /**
   * 6.
   * Problem: Write a function that counts the number of times a given int occurs in a Linked List
   * Solution: Loop through the list and return the count.
   */

  /**
   * 7.
   * Problem: Same as problem 2.
   */

  /**
   * 8.
   * Problem: Write a function to reverse a linked list.
   */
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

  /**
   * 9.
   * Problem: Write a program function to detect loop in a linked list.
   * Solution:
   * 1. Use Hashing: Traverse the list one by one and keep putting the node addresses in a Hash Table.
   * 2. Mark Visited Nodes: This solution requires modifications to basic linked list data structure. Have a visited
   * flag with each node. Traverse the linked list and keep marking visited nodes.
   * 3. Floyd’s Cycle-Finding Algorithm: Traverse linked list using two pointers. Move one pointer by one and other
   * pointer by two. If these pointers meet at some node then there is a loop. If pointers do not meet then linked list
   * doesn’t have loop.
   */

  /**
   * 10.
   * Problem: Function to check if a singly linked list is palindrome.
   * Solution:
   * 1. Use a stack to store all elements and compare with all elements.
   * 2. Find mid using fast, slow pointer approach. Compare to first half and reverse of second half.
   * 3. Using recursion.
   */

  /**
   * 11.
   * Problem: The Great Tree-List Recursion Problem.
   * Solution: Done in tree section.
   */

  /**
   * 12.
   * Problem: Clone a linked list with next and random pointer.
   * Solution:
   */

  /**
   * 13.
   * Problem: Write a code for implementation of doubly linked list with use of single pointer in each node.
   * Solution: The alternative implementation is based on pointer distance, so I call it the pointer distance
   * implementation for this discussion. Each node would carry only one pointer field to traverse the list back and
   * forth. In a conventional implementation, we need to keep a forward pointer to the next item on the list and a
   * backward pointer to the previous item.
   */

  /**
   * 14.
   * Problem: Given a linked list which is sorted, how will you insert in sorted way.
   * Solution: Use two pointers and reach to the ceiling of the given node.
   */

  /**
   * 15.
   * Problem: Write a function to get the intersection point of two Linked Lists.
   * Solution:
   * 1. Using difference of node counts.
   * 2. Make circle in first list: Traverse the first linked list(count the elements) and make a circular linked list.
   * Now view the problem as find the loop in the second linked list.
   */

  /**
   * 16.
   * Problem: Write a recursive function to print reverse of a Linked List.
   */
  void printReverse(ListNode head) {
    if (head != null) {
      printReverse(head.next);
      System.out.print(head.data + " ");
    }
  }

  /**
   * 17.
   * Problem: Remove duplicates from a sorted linked list.
   * Solution: Traverse the list from the head (or start) node. While traversing, compare each node with its next node.
   * If data of next node is same as current node then delete the next node. Before we delete a node, we need to store
   * next pointer of the node.
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

  /**
   * 18.
   * Problem: Remove duplicates from an unsorted linked list.
   * Solution: Use HashSet.
   */
  ListNode removeDuplicatesUnsorted(ListNode head) {
    HashSet<Integer> set = new HashSet<>();
    ListNode prev = null, current = head;
    while (current != null) {
      if (set.contains(current.data))
        prev.next = current.next;
      else {
        set.add(current.data);
        prev = current;
      }
      current = prev.next;
    }
    return head;
  }

  /**
   * 19.
   * Problem: Reverse a Doubly Linked List.
   * Solution:
   */

  /**
   * 20.
   * Problem: Split a Circular Linked List into two halves.
   * Solution:
   */

  /**
   * 21.
   * Problem: Move last element to front of a given Linked List.
   * Write a function that moves last element to front in a given Singly
   * Linked List. For example, if the given Linked List is 1->2->3->4->5, then
   * the function should change the list to 5->1->2->3->4.
   * Solution:
   */
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

  /**
   * 22.
   * Problem: Pairwise swap elements of a given linked list.
   * Given a singly linked list, write a function to swap elements pairwise. For example, if the linked list is
   * 1->2->3->4->5 then the function should change it to 2->1->4->3->5, and if the linked list is 1->2->3->4->5->6 then
   * the function should change it to 2->1->4->3->6->5.
   * Solution: Swap data of first two nodes and recur the rest.
   */
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

  /**\
   *
   * 23.
   * Problem: Delete a node in a Doubly Linked List.
   * Solution:
   */

  /**
   * 24.
   * Problem: Intersection of two Sorted Linked Lists.
   * Given two lists sorted in increasing order, create and return a new list representing the
   * intersection of the two lists. The new list should be made with its own memory — the original
   * lists should not be changed
   * For example, let the first linked list be 1->2->3->4->6 and second linked list be 2->4->6->8, then
   * your function should create and return a third list as 2->4->6.
   * Solution:
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


  /**
   * 25.
   * Problem: Delete alternate nodes of a Linked List.
   * Given a Singly Linked List, starting from the second node delete all alternate nodes of it.
   * For example, if the given linked list is 1->2->3->4->5 then your function should convert it to
   * 1->3->5, and if the given linked list is 1->2->3->4 then convert it to 1->3.
   * Solution:
   */
  ListNode deleteAlternate(ListNode head) {
    if (head == null || head.next == null) return head;
    else {
      head.next = deleteAlternate(head.next.next);
      return head;
    }
  }

  /**
   * 26.
   * Problem: Alternating split of a given Singly Linked List.
   * Solution:
   */

  /**
   * 27.
   * Problem: Merge two sorted linked lists.
   */
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

  //Space Inefficient.
  ListNode sortedMergeRec(ListNode head1, ListNode head2) {
    if (head1 == null) return head2;
    else if (head2 == null) return head1;
    else {
      ListNode head;
      if (head1.data < head2.data) {
        head = head1;
        head.next = sortedMerge(head1.next, head2);
      } else {
        head = head2;
        head.next = sortedMerge(head1, head2.next);
      }
      return head;
    }
  }

  /**
   * 28.
   * Problem: Identical Linked Lists.
   * Solution:
   */
  /**
   * 29.
   * Problem: Merge Sort for Linked Lists
   * Solution:
   */
  /**
   * 30.
   * Problem: Reverse a Linked List in groups of given size
   * Solution:
   */
  /**
   * 31.
   * Problem: Linked List vs Array
   * Solution: Both Arrays and Linked List can be used to store linear
   * data of similar types, but they both have some advantages and
   * disadvantages over each other.
   * (1)	The size of the arrays is fixed:
   * 2)	Inserting a new element in an array of elements is expensive
   * Linked list provides following two advantages over arrays
   * 1)	Dynamic size
   * 2)	Ease of insertion/deletion
   *
   * Linked lists have following drawbacks:
   * 1)	Random access is not allowed.
   * 2)	Extra memory space for a pointer is required with each element of
   * the list.
   * 3) Arrays have better cache locality that can make a pretty big
   * difference in performance.
   */

  /**
   * 32.
   * Problem: Sorted insert for circular linked list
   * Solution:
   */


  /**
   * 33.
   * Problem: Reverse alternate K nodes in a Singly Linked List
   * Solution:
   */

  /**
   * 34.
   * Problem: Delete nodes which have a greater value on right side.
   * The list 12->15->10->11->5->6->2->3->NULL should be changed to
   * 15->11->6->3->NULL
   * Solution:
   * 1. Reverse the list.
   * 2. Traverse the reversed list. Keep max till now. If next node < max,
   * then delete the next node, otherwise max = next node. 3. Reverse the
   * list again to retain the original order.
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
   * 35.
   * Problem: Segregate even and odd nodes in a Linked List
   * Given a Linked List of integers, write a function to modify the
   * linked list such that all even numbers appear before all the odd
   * numbers in the modified linked list. Also, keep the order of even
   * and odd numbers same.
   * Input: 17->15->8->12->10->5->4->1->7->6->NULL
   * Output: 8->12->10->4->6->17->15->5->1->7->NULL
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
   * 36.
   * Problem: Detect and Remove Loop in a Linked List.
   * Solution:1) Detect Loop using Floyd’s Cycle detection algo and get
   * the pointer to a loop node.
   * 2) Count the number of nodes in loop. Let the count be k.
   * 3) Fix one pointer to the head and another to kth node from head.
   * 4) Move both pointers at the same pace, they will meet at loop
   * starting node.
   * 5) Get pointer to the last node of loop and make next of it as NULL.
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
   * 37.
   * Problem: XOR Linked List – A Memory Efficient Doubly Linked List | Set 1.
   * Solution:
   */
  /**
   * 38.
   * Problem: Add two numbers represented by linked lists | Set 1.
   * Solution:
   */
  /**
   * 39.
   * Problem: How to write C functions that modify head pointer of a Linked List?.
   * Solution:
   */

  /**
   * 40.
   * Problem: Delete a given node in Linked List under given constraints.
   * Solution:
   */

  /**
   * 41.
   * Problem: Sorted Linked List to Balanced BST.
   * Given a Singly Linked List which has data members sorted in
   * ascending order. Construct a Balanced Binary Search Tree which has
   * same data members as the given Linked List.
   * Solution:Method 1 (Simple)
   * 1) Get the Middle of the linked list and make it root.
   * 2) Recursively do same for left half and right half.
   * a) Get the middle of left half and make it left child of the root
   * created in step 1.
   * b) Get the middle of right half and make it right child of the
   * root created in step 1.
   * Time complexity: O(nLogn) where n is the number of nodes in LinkedList.
   */
  TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    else {
      ListNode mid = getMid(head, head);
      TreeNode root = new TreeNode(mid.data);
      root.left = sortedListToBST(head);
      root.right = sortedListToBST(mid.next);
      return root;
    }
  }

  ListNode getMid(ListNode fast, ListNode slow) {
    if (fast == null || fast.next == null) return slow;
    else return getMid(fast.next.next, slow.next);
  }

  //Method 2 (Tricky)(O(n) time)


  /**
   * 42.
   * Problem: In-place conversion of Sorted DLL to Balanced BST
   * Solution:
   */
  /**
   * 43.
   * Problem: Union and Intersection of two Linked Lists
   * Solution:
   */
  /**
   * 44.
   * Problem: XOR Linked List – A Memory Efficient Doubly Linked List | Set 2.
   * Solution:
   */
  /**
   * 45.
   * Problem: Find a triplet from three linked lists with sum equal to a given number
   * Solution:
   */
  /**
   * 46.
   * Problem: Rotate a Linked List
   * Given a singly linked list, rotate the linked list counter-clockwise by k
   * nodes. Where k is a given positive integer. For example, if the given
   * linked list is 10->20->30->40->50->60 and k is 4, the list should be
   * modified to 50->60->10->20->30->40. Assume that k is smaller than the count
   * of nodes in linked lis
   * Solution:To rotate the linked list, we need to change next of kth node to
   * NULL, next of last node to previous head node, and finally change head to
   * (k+1)th node. So we need to get hold of three nodes: kth node, (k+1)th node
   * and last node.
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

  /**
   * 47.
   * Problem: Flattening a Linked List
   * Solution:
   */
  /**
   * 48.
   * Problem: Add two numbers represented by linked lists | Set 2
   * Solution:
   */

  /**
   * 49.
   * Problem: Sort a linked list of 0s, 1s and 2s
   * Solution:
   * 1) Traverse the list and count the number of 0s, 1s and 2s. Let the
   * counts be n1, n2 and n3 respectively.
   * 2) Traverse the list again, fill the first n1 nodes with 0, then n2
   * nodes with 1 and finally n3 nodes with 2.
   */
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

  /**
   * 50.
   * Problem: Flatten a multilevel linked list
   * Solution:
   */

  /**
   * 51.
   * Problem: Linked List | Set 1 (Introduction)
   * Solution: Like arrays, Linked List is a linear data structure. Unlike arrays, linked list elements are not stored
   * at contiguous location; the elements are linked using pointers.
   *
   * Why Linked List?
   * Arrays can be used to store linear data of similar types, but arrays have following limitations.
   * 1) The size of the arrays is fixed: So we must know the upper limit on the number of elements in advance. Also,
   * generally, the allocated memory is equal to the upper limit irrespective of the usage.
   * 2) Inserting a new element in an array of elements is expensive, because room has to be created for the new elements
   * and to create room existing elements have to shifted.
   *
   * Advantages over arrays
   * 1) Dynamic size
   * 2) Ease of insertion/deletion
   *
   * Drawbacks:
   * 1) Random access is not allowed. We have to access elements sequentially starting from the first node. So we cannot
   * do binary search with linked lists.
   * 2) Extra memory space for a pointer is required with each element of the list.
   */

  /**
   * 52.
   * Problem: Linked List | Set 2 (Inserting a node)
   * Solution: A node can be added in three ways
   * 1) At the front of the linked list
   * 2) After a given node.
   * 3) At the end of the linked list.
   */


  /**
   * 53.
   * Problem: QuickSort on Doubly Linked List
   * Solution:
   */
  /**
   * 54.
   * Problem: Swap Kth node from beginning with Kth node from end in a Linked List
   * Solution:
   */
  /**
   * 55.
   * Problem: Delete N nodes after M nodes of a linked list.
   * Solution:
   */
  /**
   * 56.
   * Problem: QuickSort on Singly Linked List
   * Solution:
   */

  /**
   * 57.
   * Problem: Merge a linked list into another linked list at alternate positions.
   * Solution:
   */

  /**
   * 58.
   * Problem: Pairwise swap elements of a given linked list by changing links
   */
  ListNode pairwiseSwap(ListNode head) {
    if (head == null || head.next == null) return head;
    else {
      ListNode thirdNode = head.next.next;
      head.next.next = null;
      head = reverseList(head);
      head.next.next = pairwiseSwap(thirdNode);
      return head;
    }
  }


  /**
   * 59.
   * Problem: C Program for Bubble Sort on Linked List.
   * Solution:
   */


  /**
   * 60.
   * Problem: Queue | Set 2 (Linked List Implementation).
   * Solution:
   */

  /**
   * 61.
   * Problem: Given a linked list, reverse alternate nodes and append at the end.
   * Solution:
   */
  /**
   * 62.
   * Problem: Doubly Linked List | Set 1 (Introduction and Insertion).
   * Solution:
   */
  /**
   * 63.
   * Problem: Circular Linked List | Set 1 (Introduction and Applications).
   * Solution:
   */
  /**
   * 64.
   * Problem: Circular Linked List | Set 2 (Traversal).
   * Solution:
   */
  /**
   * 65.
   * Problem: Linked List | Set 3 (Deleting a node).
   * Solution:
   */
  /**
   * 66.
   * Problem: A Programmer’s approach of looking at Array vs. Linked List.
   * Solution:
   */
  /**
   * 67.
   * Problem: Can we reverse a linked list in less than O(n)?
   * Solution:
   */
  /**
   * 68.
   * Problem: Delete all occurrences of a given key in a linked list
   * Solution:
   */
  /**
   * 69.
   * Problem: Construct a Maximum Sum Linked List out of two Sorted Linked Lists having some Common nodes.
   * Solution:
   */
  /**
   * 70.
   * Problem: Given a linked list of line segments, remove middle points
   * Solution:
   */
  /**
   * 71.
   * Problem: Clone a linked list with next and random pointer | Set 2
   * Solution:
   */
  /**
   * 72.
   * Problem: Find Length of a Linked List (Iterative and Recursive)
   * Solution:
   */
  /**
   * 73.
   * Problem: Search an element in a Linked List (Iterative and Recursive).
   * Solution:
   */
  /**
   * 74.
   * Problem: Generic Linked List in C.
   * Solution:
   */
  /**
   * 75.
   * Problem: Swap nodes in a linked list without swapping data.
   * Solution:
   */
  /**
   * 76.
   * Problem: Point to next higher value node in a linked list with an arbitrary pointer
   * Solution:
   */
  /**
   * 77.
   * Problem: Merge Sort for Doubly Linked List.
   * Solution:
   */
  /**
   * 78.
   * Problem: Insertion Sort for Singly Linked List
   * Solution:
   */
  /**
   * 79.
   * Problem: Select a Random Node from a Singly Linked List.
   * Solution:
   */
  /**
   * 80.
   * Problem: Sort a linked list that is sorted alternating ascending and descending orders?
   * Solution:
   */
  /**
   * 81.
   * Problem: Rearrange a given linked list in-place.
   * Solution:
   */
  /**
   * 82.
   * Problem: Compare two strings represented as linked lists.
   * Solution:
   */

  /**
   * 83.
   * Problem: Delete a Linked List node at a given position.
   * Given a singly linked list and a position, delete a linked list
   * node at the given position.
   * Example:
   * Input: position = 1, Linked List = 8->2->3->1->7
   * Output: Linked List =  8->3->1->7
   * Solution:
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
   * 84.
   * Problem: Merge two sorted linked lists such that merged list is in reverse order.
   * Given two linked lists sorted in increasing order. Merge them such
   * a way that the result list is in decreasing order (reverse order).
   * Solution:A Simple Solution is to do following.
   * 1) Reverse first list ‘a’.
   * 2) Reverse second list ‘b’.
   * 3) Merge two reversed lists.
   * <p>
   * How to solve without reverse, O(1) auxiliary space (in-place) and
   * only one traversal of both lists?
   * The idea is to follow merge style process. Initialize result list
   * as empty. Traverse both lists from beginning to end. Compare
   * current nodes of both lists and insert smaller of two at the
   * beginning of the result list
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

  /**
   * 85.
   * Problem: LinkedList in java.
   * Solution:
   */

  /**
   * 86.
   * Problem: Delete last occurrence of an item from linked list
   * Given a liked list and a key to be deleted. Delete last occurrence
   * of key from linked. The list may have duplicates.
   * Examples:
   * Input:   1->2->3->5->2->10, key = 2
   * Output:  1->2->3->5->10
   * Solution:
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
   * 87.
   * Problem: Rearrange a linked list such that all even and odd
   * positioned nodes are together.
   * Input:   1->2->3->4
   * Output:  1->3->2->4
   * Solution:
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
   * 88.
   * Problem: Rearrange a Linked List in Zig-Zag fashion.
   * Solution:
   */

  /**
   * 89.
   * Problem: Add 1 to a number represented as linked list.
   * Solution:
   */

  /**
   * 90.
   * Problem: Point arbit pointer to greatest value right side node in a linked list.
   * Solution:
   */


  /**
   * 91.
   * Problem: Check if a linked list of strings forms a palindrome.
   * Solution:
   */

  /**
   * 92.
   * Problem: Convert a given Binary Tree to Doubly Linked List | Set 4.
   * Solution:
   */


  /**
   * 93.
   * Problem: Sort linked list which is already sorted on absolute values.
   * Solution:
   */

  /**
   * 94.
   * Problem: Create a Doubly Linked List from a Ternary Tree.
   * Solution:
   */


  /**
   * 95.
   * Problem: In-place Merge two linked lists without changing links of first list.
   * Solution:
   */

  /**
   * 96.
   * Problem: Delete middle of linked list.
   * Given a singly linked list, delete middle of the linked list. For
   * example, if given linked list is 1->2->3->4->5 then linked list should
   * be modified to 1->2->4->5
   * If there are even nodes, then there would be two middle nodes, we need
   * to delete the second middle element. For example, if given linked list
   * is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
   * Solution:
   */
  void deleteMidNode(ListNode head) {
    if (head != null && head.next != null) {
      ListNode prevOfMidNode = getPrevOfMidNode(head, head, null);
      prevOfMidNode.next = prevOfMidNode.next.next;
    }
  }

  ListNode getPrevOfMidNode(ListNode fast, ListNode slow, ListNode prev) {
    if (fast == null || fast.next == null) return prev;
    else return getPrevOfMidNode(fast.next.next, slow.next, slow);
  }

  /**
   * 97.
   * Problem: Check if a linked list is Circular Linked List.
   * Solution:
   */
  boolean isCircular(ListNode head) {
    if (head == null) return false;
    else return isCircularList(head.next, head);
  }

  private boolean isCircularList(ListNode fast, ListNode slow) {
    return (fast == null || fast.next == null) && (fast == slow || isCircularList(fast.next.next, slow.next));
  }

  /**
   * 98.
   * Problem: Merge K sorted linked lists.
   * Given K sorted linked lists of size N each, merge them and print the
   * sorted output.
   * Input: k = 3, n =  4
   * list1 = 1->3->5->7->NULL
   * list2 = 2->4->6->8->NULL
   * list3 = 0->9->10->11
   * Output:
   * 0->1->2->3->4->5->6->7->8->9->10->11
   * Solution:
   *
   * Method 1(Using Min Heap)
   * A Better solution is to use Min Heap based solution
   * Time complexity of this solution would be O(nk Log k)
   *
   * Method 2 (Using Divide and Conquer))
   * Divide and Conquer approach is discussed. This approach doesn’t
   * require extra space for heap and works in O(nk Log k)
   */


  /**
   * 99.
   * Problem: Decimal Equivalent of Binary Linked List.
   * Solution:
   */

  /**
   * 100.
   * Problem: Flatten a multi-level linked list | Set 2 (Depth wise).
   * Solution:
   */


  /**
   * 101.
   * Problem: Rearrange a given list such that it consists of alternating minimum maximum elements.
   * Solution:
   */

  /**
   * 102.
   * Problem: Subtract Two Numbers represented as Linked Lists.
   * Solution:
   */


  /**
   * 103.
   * Problem: Convert a Binary Tree to a Circular Doubly Link List
   * Solution:
   */

  void convertBTreeToCDLL(TreeNode root) {
    if (root != null) {
    }
  }

  /**
   * 104.
   * Problem: Unrolled Linked List | Set 1 (Introduction).
   * Solution:
   */


  /**
   * 105.
   * Problem: Find pairs with given sum in doubly linked list.
   * Solution:
   */

  /**
   * 106.
   * Problem: Find pair for given sum in a sorted singly linked without extra space
   * Solution:
   */
  /**
   * 107.
   * Problem: Iteratively Reverse a linked list using only 2 pointers (An Interesting Method).
   * Solution:
   */

  /**
   * 108.
   * Problem: Partitioning a linked list around a given value and keeping the original order.
   * Solution:
   */

  /**
   * 109.
   * Problem: Sublist Search (Search a linked list in another list).
   * Solution:
   */

  /**
   * 110.
   * Problem: Check linked list with a loop is palindrome or not.
   * Solution:
   */


  /**
   * 112.
   * Problem: Clone a linked list with next and random pointer in O(1) space.
   * Solution:
   */

  /**
   * 113.
   * Problem: Length of longest palindrome list in a linked list using O(1) extra space
   * Solution:
   */


  /**
   * 114.
   * Problem: Adding two polynomials using Linked List.
   * Solution:
   */

  /**
   * 115.
   * Problem: Circular Singly Linked List | Insertion
   * Solution:
   */


  /**
   * 116.
   * Problem: Implementing Iterator pattern of a single Linked List.
   * Solution:
   */

  /**
   * 117.
   * Problem: Move all occurrences of an element to end in a linked list.
   * Solution:
   */
  /**
   * 118.
   * Problem: How to insert elements in C++ STL List ?
   * Solution:
   */

  /**
   * 119.
   * Problem: Deletion from a Circular Linked List.
   * Solution:
   */

  /**
   * 120.
   * Problem: Doubly Circular Linked List | Set 1 (Introduction and Insertion).
   * Solution:
   */

  /**
   * 121.
   * Problem: Doubly Circular Linked List | Set 2 (Deletion)
   * Solution:
   */


  /**
   * 122.
   * Problem: Circular Queue | Set 2 (Circular Linked List Implementation).
   * Solution:
   */

  /**
   * 123.
   * Problem: Remove all occurrences of duplicates from a sorted Linked List
   * Given a sorted linked list, delete all nodes that have duplicate
   * numbers (all occurrences), leaving only numbers that appear once in
   * the original list.
   * Input : 23->28->28->35->49->49->53->53
   * Output : 23->35
   * Input : 11->11->11->11->75->75
   * Output : empty List
   * Solution:
   */
  ListNode removeDuplicateOcc(ListNode prevNode, ListNode currNode) {
    if (currNode != null) {
      while (currNode.next != null && prevNode.next.data == currNode.next.data) currNode = currNode.next;
      if (prevNode.next == currNode) prevNode = prevNode.next;
      else prevNode.next = currNode.next;
      removeDuplicateOcc(prevNode, currNode.next);
    }
    return prevNode.next;
  }

  /**
   * 124.
   * Problem: Partitioning a linked list around a given value and If we don’t care about making the elements of the list “stable”
   * Solution:
   */

  /**
   * 125.
   * Problem: Remove every k-th node of the linked list.
   * Given a singly linked list, Your task is to remove every K-th node of
   * the linked list.
   * Input : 1->2->3->4->5->6->7->8
   * k = 3
   * Output : 1->2->4->5->7->8
   * Solution:
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


  /**
   * 126.
   * Problem: Linked List representation of Disjoint Set Data Structures.
   * Solution:
   */
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


}
