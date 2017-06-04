package data.structures.linkedlists;

import org.junit.Test;
import utilities.ListNode;

import static org.junit.Assert.assertEquals;

public class ListExampleTest {

  @Test
  public void getNthNodeTest() {
    ListNode head = createList(10);
    assertEquals(5, new ListExample().getNthNode(head,5).data);
  }

  @Test
  public void getNthNodeRecTest() {
    ListNode head = createList(10);
    assertEquals(5,new ListExample().getNthNodeRec(head,5).data);
  }

  @Test
  public void getReverseKNode() {
    ListNode head = createList(10);
    ListNode newHead = new ListExample().reverseKNodes(head, 5, 10);
    System.out.print(newHead.data);

  }

  @Test
  public void reverseListTest() {
    ListNode head = createList(10);
    assertEquals(10, new ListExample().reverseList(head).data);
  }

  @Test
  public void reverseListRecTest() {
    ListNode head = createList(20);
    assertEquals(20, new ListExample().reverseListRec(head).data);
  }

  private ListNode createList(int n) {
    ListNode head = null;
    ListNode current = null;
    for (int i = 1; i <= n; i++) {
      ListNode node = getNode(i);
      if (isFirstNode(node)) {
        head = node;
        current = node;
      }
      else if (current != null) {
        current.next = node;
        current = current.next;
      }
    }
    return head;
  }

  private boolean isFirstNode(ListNode listNode) {
    return listNode.data == 1;
  }

  private ListNode getNode(int data) {
    return new ListNode(data);
  }

}
