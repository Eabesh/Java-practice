package data.structures.linkedlists;

import org.junit.Assert;
import org.junit.Test;
import utilities.ListNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
   ListNode head;
   ListNode newNode = new ListNode(1);
   head = newNode;
   newNode.next = new ListNode(2);
   newNode.next.next = new ListNode(1);
   newNode.next.next.next = new ListNode(2);

    printList(head);
    ListNode newHead = new ListExample().removeDuplicatesUnsorted(head);
    printList(newHead);
  }
  void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
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

  @Test
  public void intersectionOfLists() {
    ListNode head = createList(7);
    printList(head);
    ListNode head1 = new ListNode(2);
    head1.next = new ListNode(4);
    head1.next.next = new ListNode(6);
    head1.next.next.next = new ListNode(8);
    printList(head1);
    ListNode newHead = new ListExample().intersectionOfLists(head, head1);
    printList(newHead);
    assertEquals(2, newHead.data);
  }

  @Test
  public void deleteAlternate() throws Exception {
    ListNode head = createList(10);
    printList(head);
    printList(new ListExample().deleteAlternate(head));
  }
  @Test
  public void sortedMerge() throws Exception {
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(3);
    ListNode head2 = new ListNode(2);
    head2.next = new ListNode(4);
    ListNode head = new ListExample().sortedMerge(head1, head2);
    printList(head);
  }


  @Test
  public void rotateList() throws Exception {
    ListNode head = createList(7);
    printList(head);
    ListNode newHead = new ListExample().rotateList(head, 4);
    printList(newHead);
  }

  @Test
  public void pairwiseSwapData() throws Exception {
    ListNode head = createList(7);
    printList(head);
    new ListExample().pairwiseSwapData(head);
    printList(head);
  }

  @Test
  public void pairwiseSwap() throws Exception {
    ListNode head = createList(7);
    printList(head);
    ListNode newHead = new ListExample().pairwiseSwap(head);
    printList(newHead);
  }

  @Test
  public void deleteMidNode() throws Exception {
    ListNode head = createList(7);
    printList(head);
    new ListExample().deleteMidNode(head);
    printList(head);
  }
  @Test
  public void isCircular() throws Exception {
    ListNode head = createList(7);
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(2);
    head1.next.next = head1;
    assertFalse(new ListExample().isCircular(head));
    assertTrue(new ListExample().isCircular(head1));
  }
  @Test
  public void removeEveryKNode() throws Exception {
    ListNode head = createList(1);
    printList(head);
    ListNode result = new ListExample().removeEveryKNode(head, 2);
    printList(result);
  }

  @Test
  public void removeDuplicateOcc() throws Exception {
    ListNode head;
    ListNode newNode = new ListNode(28);
    head = newNode;
    newNode.next = new ListNode(28);
    newNode.next.next = new ListNode(1);
    newNode.next.next.next = new ListNode(1);
    printList(head);
    ListNode prevNode = new ListNode(1);
    prevNode.next = head;
    ListNode result = new ListExample().removeDuplicateOcc(prevNode, head);
    printList(result);
  }

  @Test
  public void sortList() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(1);
    head.next.next.next.next = new ListNode(0);
    head.next.next.next.next.next = new ListNode(0);
    new ListExample().sortList(head);
    printList(head);
  }

  @Test
  public void rearrange() throws Exception {
    ListNode head = createList(10);
    printList(head);
    new ListExample().rearrage(head);
    printList(head);
  }
  private boolean isFirstNode(ListNode listNode) {
    return listNode.data == 0;
  }

  private ListNode getNode(int data) {
    return new ListNode(data);
  }

}
