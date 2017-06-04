package data.structures.linkedlists;

import utilities.ListNode;


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
   * 16. Problem: Reverse linked list.
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

  /**
   * 22. Function to check if a singly linked list is palindrome.
   *
   * Solution: 1. Use a stack to store all elements and compare with all elements.
   * 2. Find mid using fast, slow pointer approach. Compare to first half and reverse of second half.
   */

  /**
   * 18. Merge two sorted linked lists.
   */
  ListNode merge(ListNode head1, ListNode head2) {
    ListNode head;
    if (head1 == null) return head2;
    else if (head2 == null) return head1;
    else if (head1.data < head2.data) {
      head = head1;
      head.next = merge(head1.next,head2);
    }
    else {
      head = head2;
      head.next = merge(head1,head2.next);
    }
    return head;
  }

  /**
   *
   * @param head
   * @return
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

}
