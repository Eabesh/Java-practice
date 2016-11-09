package data.structures.linkedlists;

import utilities.ListNode;


public class ListExample {

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
