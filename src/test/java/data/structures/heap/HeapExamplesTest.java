package data.structures.heap;

import org.junit.Test;
import utilities.ListNode;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by abhay on 27/01/18.
 */
public class HeapExamplesTest {
  @Test
  public void mergeKLists() throws Exception {
    ListNode[] lists = new ListNode[3];
    lists[0] = new ListNode(1);
    lists[1] = new ListNode(6);
    lists[1].next = new ListNode(8);
    lists[2] = new ListNode(4);
    ListNode mergeList =  new HeapExamples().mergeKLists(lists);
    while (mergeList != null) {
      System.out.println(mergeList.data);
      mergeList = mergeList.next;
    }
  }

  @Test
  public void mergeTwoMaxHeaps() throws Exception {
    int[] a={10, 5 , 6 , 2};
    int[] b={12 , 7 , 9};
    new HeapExamples().mergeTwoMaxHeaps(a, b);
  }

  @Test
  public void stackp(){
    HeapExamples.StackPriority stackPriority= new HeapExamples().new StackPriority();
    stackPriority.push(1);
    stackPriority.push(2);
    stackPriority.push(3);

    while (!stackPriority.isEmpty()) {
      System.out.println(stackPriority.top());
      stackPriority.pop();
    }
  }

  @Test
  public void minKProduct() {
    int[] array = {198, 76, 544, 123, 154, 675};
    assertEquals(9348, new HeapExamples().minKProduct(array, 2));

  }

  @Test
  public void tripletProduct() {
    int[] array =  {1, 2, 3, 4, 5};
    new HeapExamples().tripletProduct(array, 3);
  }
}