package recursion;

import utilities.ListNode;

/**
 *  1 -> 2 -> 3 -> NULL
 */
public class ReverseLinkedList {

    ListNode reverseList(ListNode current) {
        if (current == null || current.next == null) return current;
        else {
            ListNode head = reverseList(current.next);
            current.next.next = current;
            current.next = null;
            return head;
        }
    }

}
