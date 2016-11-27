package data.structures.linkedlists;

import org.junit.Test;
import utilities.ListNode;

import static org.junit.Assert.assertEquals;

public class ListExampleTest {

    ListNode head;

    @Test
    public void getNthNodeTest() {
        getList(10);
        assertEquals(5,new ListExample().getNthNode(head,5).data);
    }

    @Test
    public void getNthNodeRecTest() {
        getList(10);
        assertEquals(5,new ListExample().getNthNodeRec(head,5).data);
    }

    @Test
    public void reverseListTest() {
        getList(10);
        assertEquals(10,new ListExample().reverseList(head).data);
    }

    @Test
    public void reverseListRecTest() {
        getList(20);
        assertEquals(20,new ListExample().reverseListRec(head).data);
    }

    private void getList(int n) {
        ListNode current = head;
        for (int i = 1; i <= n; i++) {
            ListNode node = new ListNode(i);
            if (i == 1) {
                head = node;
                current = node;
            }
            else {
                current.next = node;
                current = current.next;
            }

        }
    }

}
