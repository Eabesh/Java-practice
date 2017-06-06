package data.structures.linkedlists;

import org.junit.Test;
import utilities.ListNode;

import static org.junit.Assert.assertEquals;

public class ListExampleTest {

  @Test
  public void getNthNodeTest() {
    ListNode head = createList(10);
    assertEquals(0, new ListExample().getNthNode(head,0).data);
    assertEquals(5, new ListExample().getNthNode(head,5).data);
    assertEquals(9, new ListExample().getNthNode(head,9).data);
    assertEquals(null, new ListExample().getNthNode(head,20));
  }

  @Test
  public void getNthNodeRecTest() {
    ListNode head = createList(10);
    assertEquals(0, new ListExample().getNthNodeRec(head,0).data);
    assertEquals(5, new ListExample().getNthNodeRec(head,5).data);
    assertEquals(9, new ListExample().getNthNodeRec(head,9).data);
    assertEquals(null, new ListExample().getNthNodeRec(head,20));
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

  @Test
  public void printReverse() {
    ListNode head = createList(20);
    new ListExample().printReverse(head);
  }

  @Test
  public void removeDuplicatesUnsorted() {
    ListNode head = createList(20);
    //ListNode head2 = createList(10);
    ListNode newNode = createList(1);
    newNode.next = head;
    head = newNode;

    printList(head);
    ListNode newHead = new ListExample().removeDuplicatesUnsorted(head);
    printList(newHead);
  }
  void printList(ListNode head) {
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }
  private ListNode createList(int n) {
    ListNode head = null;
    ListNode current = null;
    for (int i = 0; i < n; i++) {
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
    return listNode.data == 0;
  }

  private ListNode getNode(int data) {
    return new ListNode(data);
  }

}
