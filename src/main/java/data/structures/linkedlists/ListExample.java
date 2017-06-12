package data.structures.linkedlists;

import utilities.ListNode;

import java.util.HashSet;
import java.util.List;


class ListExample {

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
  ListNode removeDuplicates(ListNode head) {
    if (head != null || head.next != null) {
      ListNode previous = head, current = head.next;
      while (previous.next != null) {
        if (previous.data == current.data) previous.next = current.next;
        previous = previous.next;
        if (previous.next != null) current = previous.next;
      }
    }
    return head;
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
  void moveLastToFront(ListNode head) {
    ListNode current = head, prevOfLast = null;
    while (current.next != null) {
      prevOfLast = current;
      current = current.next;
    }
    prevOfLast.next = null;
    current.next = head;
  }

  /**
   * 22.
   * Problem: Pairwise swap elements of a given linked list.
   * Given a singly linked list, write a function to swap elements pairwise.
   * For example, if the linked list is 1->2->3->4->5 then the function should
   * change it to 2->1->4->3->5, and if the linked list is 1->2->3->4->5->6
   * then the function should change it to 2->1->4->3->6->5.
   * Solution: Swap data of first two nodes and recur the rest.
   */
  void pairwiseSwapData(ListNode head) {
    if (head != null && head.next != null) {
      swapTwoNodeData(head, head.next);
      pairwiseSwapData(head.next.next);
    }
  }
  void swapTwoNodeData(ListNode node1, ListNode node2){
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
        }
        else tail = insertAtEnd(tail, current1.data);
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

  /**
   * 25.
   * Problem: Delete alternate nodes of a Linked List.
   * Given a Singly Linked List, starting from the second node delete all alternate nodes of it.
   * For example, if the given linked list is 1->2->3->4->5 then your function should convert it to
   * 1->3->5, and if the given linked list is 1->2->3->4 then convert it to 1->3.
   * Solution:
   */
  ListNode deleteAlternate(ListNode head) {
    if(head == null || head.next == null) return head;
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
   * Solution:
   */
  ListNode sortedMerge(ListNode head1, ListNode head2) {
    ListNode head = null, tail = null;
    while (head1 != null && head2 != null) {
        if (head1.data < head2.data) {
          if (head == null) {
            head = head1;
            tail = head1;
          }
          else tail = insertAtLast(tail, head1);
          head1 = head1.next;
        }else {
          if (head == null) {
            head = head2;
            tail = head2;
          }
          else tail = insertAtLast(tail, head2);
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
    else if(head2 == null) return head1;
    else {
      ListNode head;
      if (head1.data < head2.data){
        head = head1;
        head.next = sortedMerge(head1.next, head2);
      }else {
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
   * Solution:
   */

  /**
   * 35.
   * Problem: Segregate even and odd nodes in a Linked List
   * Solution:
   */

  /**
   * 36.
   * Problem: Detect and Remove Loop in a Linked List.
   * Solution:1) Detect Loop using Floyd’s Cycle detection algo and get
   * the pointer to a loop node.
   * 2) Count the number of nodes in loop. Let the count be k.
   * 3) Fix one pointer to the head and another to kth node from head.
   * 4) Move both pointers at the same pace, they will meet at loop
   * starting node.
   5) Get pointer to the last node of loop and make next of it as NULL.
   */



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
   * Solution:
   */

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
   */

  /**
   * 50.
   * Problem: Flatten a multilevel linked list
   * Solution:
   */

  /**
   * 51.
   * Problem: Linked List | Set 1 (Introduction)
   * Solution:
   */

  /**
   * 52.
   * Problem: Linked List | Set 2 (Inserting a node)
   * Solution:
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
   * Solution:
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
   * Solution:
   */
  /**
   * 84.
   * Problem: Merge two sorted linked lists such that merged list is in reverse order.
   * Solution:
   */
  /**
   * 85.
   * Problem: LinkedList in java.
   * Solution:
   */
  /**
   * 86.
   * Problem: Delete last occurrence of an item from linked list
   * Solution:
   */

  /**
   * 87.
   * Problem: Rearrange a linked list such that all even and odd positioned nodes are together.
   * Solution:
   */

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
   return isCircularList(head.next, head);
  }
  boolean isCircularList(ListNode fast, ListNode slow) {
    if(fast == null || fast.next == null) return false;
    else if (fast == slow) return true;
    else return isCircularList(fast.next.next, slow.next);
  }

  /**
   * 98.
   * Problem: Merge K sorted linked lists.
   * Solution:
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
   *Input : 11->11->11->11->75->75
   * Output : empty List
   * Solution:
   */
  ListNode removeDuplicateOcc(ListNode prevNode, ListNode currNode) {
    if(currNode == null) return currNode;
    else {
      ListNode nextNode = currNode.next;
      while (nextNode != null && currNode.data == nextNode.data) {
        prevNode.next = nextNode.next;
        nextNode = prevNode.next;
      }
      removeDuplicateOcc( prevNode.next, nextNode);
      return prevNode.next;
    }
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
    else if(k == 2) return head;
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
  HeadTail reverseKNode(ListNode head, int k ){
    HeadTail headTail  = new HeadTail();
    ListNode current= head;
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
