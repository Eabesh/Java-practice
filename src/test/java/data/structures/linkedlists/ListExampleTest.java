package data.structures.linkedlists;

import org.junit.Assert;
import org.junit.Test;
import utilities.FlattenListNode;
import utilities.ListNode;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListExampleTest {
  @Test
  public void reverseKNodes() throws Exception {
    ListNode head = createList(10);
    ListNode h = new ListExample().reverseKNodes(head, 3);
    printList(h);
  }

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
  void printList1(ListNode head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
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
    for (int i = 1; i < n; i++) {
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
    ListNode newHead = new ListExample().intersectionOfListRec(head, head1);
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
    ListNode newHead = new ListExample().swapPairs(head);
    printList(newHead);
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

  @Test
  public void deleteLastOcc() throws Exception {
    ListNode head = createList(10);
    printList(head);
    new ListExample().deleteLastOcc(head, 7);
    printList(head);
  }

  @Test
  public void mergeReverseOrder() throws Exception {
    ListNode head1 = createList(3);
    ListNode head = new ListNode(10);
    head.next = new ListNode(13);
    head.next.next = new ListNode(14);
    ListNode mergeList = null;
    mergeList = new ListExample().mergeReverseOrder(head1, head, mergeList);
    printList(mergeList);
  }
  private boolean isFirstNode(ListNode listNode) {
    return listNode.data == 1;
  }

  private ListNode getNode(int data) {
    return new ListNode(data);
  }

  @Test
  public void sortKNodes() {
    ListNode head2 = new ListNode(5);
    head2.next = new ListNode(3);
    head2.next.next = new ListNode(2);
    head2.next.next.next = new ListNode(4);
    head2.next.next.next.next = new ListNode(1);
    head2.next.next.next.next.next = new ListNode(2);
    head2.next.next.next.next.next.next = new ListNode(8);
    head2.next.next.next.next.next.next.next = new ListNode(2);
    head2.next.next.next.next.next.next.next.next = new ListNode(1);
//    head2.next.next.next.next.next.next.next.next.next = new ListNode(10);
//    head2.next.next.next.next.next.next.next.next.next.next = new ListNode(22);
//    head2.next.next.next.next.next.next.next.next.next.next.next = new ListNode(3);
//    head2.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(4);
//   ListNode head1 = new ListExample().mergeSort(head2);
    printList1(head2);
    ListNode head1 = new ListExample().sortKNodes(head2, 3);
    printList(head1);

  }

  @Test
  public void mergeLists() {
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(3);
    head2.next.next = new ListNode(5);
    head2.next.next.next = new ListNode(9);
    head2.next.next.next.next = new ListNode(10);

    ListNode head = new ListNode(2);
    head.next = new ListNode(6);

    ListNode newHead = new ListExample().mergeLists(head, head2);
    printList(newHead);
  }

  @Test
  public void deleteNodeWithRef() {
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(3);
    head2.next.next = new ListNode(5);
    head2.next.next.next = new ListNode(9);

    new ListExample().deleteNodeWithRef(head2.next.next);
    printList(head2);
  }

  @Test
  public void midNode() {
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(3);
    head2.next.next = new ListNode(5);
    head2.next.next.next = new ListNode(9);
//    head2.next.next.next.next = new ListNode(10);
    assertEquals(5, new ListExample().midNode(head2).data);
  }

  @Test
  public void nthNodeFromEnd() {
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(3);
    head2.next.next = new ListNode(5);
    head2.next.next.next = new ListNode(9);
    assertEquals(3, new ListExample().nthNodeFromEnd(head2, 3).data);

  }

  @Test
  public void countOccurrence() {

    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(5);
    head2.next.next = new ListNode(5);
    head2.next.next.next = new ListNode(9);
    head2.next.next.next.next = new ListNode(1);
    head2.next.next.next.next.next = new ListNode(5);
    assertEquals(3, new ListExample().countOccurrences(head2, 5));

  }

  @Test
  public void containsLoop() {
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(5);
    head2.next.next = head2;
    assertTrue(new ListExample().containsLoop(head2));

  }

  @Test
  public void isPalindrome() {
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(2);
    head2.next.next = new ListNode(1);
//    head2.next.next.next = new ListNode(1);
    assertTrue(new ListExample().isPalindrome(head2));

  }

  @Test
  public void findIntersectionOfLists() {
    ListNode first = new ListNode(3);
    first.next = new ListNode(6);
    first.next.next = new ListNode(9);
    first.next.next.next = new ListNode(15);
    first.next.next.next.next = new ListNode(30);

    ListNode second = new ListNode(10);
//    second.next = first.next.next.next;

    System.out.println(new ListExample().findIntersectionOfLists(first, second));

  }

  @Test
  public void addSameSize() {
    ListNode first = new ListNode(5);
    first.next = new ListNode(6);
    first.next.next = new ListNode(3);
    ListNode second = new ListNode(8);
    second.next = new ListNode(4);
    second.next.next = new ListNode(2);
    ListNode sumList = new ListExample().addLists(first, second);
    printList(sumList);
  }

  @Test
  public void flatten() {
    FlattenListNode head = new FlattenListNode(5);
    head.next = new FlattenListNode(10);
    head.next.next = new FlattenListNode(19);
    head.next.next.next = new FlattenListNode(28);

    head.down = new FlattenListNode(7);
    head.down.down = new FlattenListNode(8);
    head.down.down.down = new FlattenListNode(30);

    head.next.down = new FlattenListNode(20);

    head.next.next.down = new FlattenListNode(22);
    head.next.next.down.down = new FlattenListNode(50);

    head.next.next.next.down = new FlattenListNode(35);
    head.next.next.next.down.down = new FlattenListNode(40);
    head.next.next.next.down.down.down = new FlattenListNode(45);

    FlattenListNode temp = new ListExample().flatten(head);
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.down;
    }
  }

  @Test
  public void sortedInsert() {
    ListNode first = new ListNode(3);
    first.next = new ListNode(6);
    first.next.next = new ListNode(9);
    first.next.next.next = new ListNode(15);
    first.next.next.next.next = new ListNode(30);

    ListNode node = new ListNode(10);
    ListNode newHead = new ListExample().sortedInsertRec(first, node);
    printList(newHead);
  }



  @Test
  public void insertSortList() {
    ListNode head2 = new ListNode(4);
    head2.next = new ListNode(8);
    head2.next.next = new ListNode(3);
    head2.next.next.next = new ListNode(9);
    head2.next.next.next.next = new ListNode(1);
    ListNode newHead = new ListExample().insertSortList(head2);
    printList(newHead);
  }

  @Test
  public void partition() {
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(4);
    head2.next.next = new ListNode(3);
    head2.next.next.next = new ListNode(2);
    head2.next.next.next.next = new ListNode(5);
    head2.next.next.next.next.next = new ListNode(2);
//    ListNode newHead = new ListExample().partitin1(head2, 3);
//    printList(newHead);

  }
}
