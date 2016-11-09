package recursion;

import org.junit.Test;
import utilities.ListNode;

import static org.junit.Assert.assertEquals;

public class ReverseLinkedListTest {

    @Test
    public void reverseTest() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode head = node1;
        node1.next = node2;
        node2.next = node3;

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        head = reverseLinkedList.reverseList(head);
        assertEquals(head.data,3);

    }
}
