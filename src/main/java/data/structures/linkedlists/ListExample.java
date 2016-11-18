package data.structures.linkedlists;

import utilities.ListNode;


class ListExample {

    /**
     * 11. Get nth node in linked list.
     */
    ListNode getNthNode(ListNode head, int n) {
        ListNode current = head;
        while (current != null && n > 1) {
            current = current.next;
            n--;
        }
        return current;
    }

    ListNode getNthNodeRec(ListNode head, int n) {
        if (head == null || n == 1) return head;
        else return getNthNodeRec(head.next, n-1);
    }

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
