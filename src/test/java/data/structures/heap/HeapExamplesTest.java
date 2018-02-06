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
    Object object = new Object();


//    lists[0] = new ListNode(1);
//    lists[1] = new ListNode(2);
//    lists[2] = new ListNode(3);
    new HeapExamples().mergeKLists(lists);
  }

  @Test
  public void mergeTwoMaxHeaps() throws Exception {
    int[] a={10, 5 , 6 , 2};
    int[] b={12 , 7 , 9};
    new HeapExamples().mergeTwoMaxHeaps(a, b);
  }

}