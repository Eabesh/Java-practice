package data.structures.queue;

import java.util.LinkedList;
import java.util.Queue;

class QueueExamples {

  /**
   * 1.
   * Problem: Level Order Tree Traversal.
   * Solution:
   */

  /**
   * 2.
   * Problem: Level order traversal in spiral form.
   * Solution:
   */

  /**
   * 3.
   * Problem: Implement Queue using Stacks.
   * Solution:
   * By making deQueue operation costly:
   * enQueue(q,  x)
   *   1) Push x to stack1 (assuming size of stacks is unlimited).
   * deQueue(q)
   *   1) If both stacks are empty then error.
   *   2) If stack2 is empty
   *      While stack1 is not empty, push everything from stack1 to stack2.
   *   3) Pop the element from stack2 and return it.
   */

  /**
   * 4.
   * Problem: Applications of Queue Data Structure.
   * Solution:
   */

  /**
   * 5.
   * Problem: Sliding Window Maximum (Maximum of all subarrays of size k).
   * Solution:
   */

  /**
   * 6.
   * Problem: Breadth First Traversal or BFS for a Graph.
   * Solution:
   */

  /**
   * 7.
   * Problem: Check whether a given Binary Tree is Complete or not | Set 1 (Iterative Solution).
   * Solution:
   */

  /**
   * 8.
   * Problem: Implement LRU Cache.
   * Solution:
   */

  /**
   * 9.
   * Problem: Find the largest multiple of 3 | Set 1 (Using Queue).
   * Solution:
   */

  /**
   * 10.
   * Problem: Implement Stack using Queues.
   * Solution:
   */

  /**
   * 11.
   * Problem: Find the first circular tour that visits all petrol pumps.
   * Solution:
   */

  /**
   * 12.
   * Problem: Construct Complete Binary Tree from its Linked List Representation.
   * Solution:
   */

  /**
   * 13.
   * Problem: Iterative Method to find Height of Binary Tree.
   * Solution:
   */

  /**
   * 14.
   * Problem: Queue | Set 1 (Introduction and Array Implementation).
   * Solution:  Queue is a linear structure which follows a particular order in which the operations are performed. The
   * order is First In First Out (FIFO).
   * Mainly the following four basic operations are performed on queue:
   * 1. Enqueue: Adds an item to the queue. If the queue is full, then it is said to be an Overflow condition.
   * 2. Dequeue: Removes an item from the queue. The items are popped in the same order in which they are pushed. If
   * the queue is empty, then it is said to be an Underflow condition.
   * 3. Front: Get the front item from queue.
   * 4. Rear: Get the last item from queue.
   * Applications:
   * Queue is used when things don’t have to be processed immediately, but have to be processed in First InFirst Out
   * order like Breadth First Search. This property of Queue makes it also useful in following kind of scenarios.
   * 1) When a resource is shared among multiple consumers. Examples include CPU scheduling, Disk Scheduling.
   * 2) When data is transferred asynchronously (data not necessarily received at same rate as sent) between two
   * processes. Examples include IO Buffers, pipes, file IO, etc.
   */

  /**
   * 15.
   * Problem: Queue | Set 2 (Linked List Implementation).
   * Solution:
   */

  /**
   * 16.
   * Problem: Priority Queue | Set 1 (Introduction).
   * Solution: Priority Queue is an extension of queue with following properties.
   * 1) Every item has a priority associated with it.
   * 2) An element with high priority is dequeued before an element with low priority.
   * 3) If two elements have the same priority, they are served according to their order in the queue.
   * A typical priority queue supports following operations.
   * insert(item, priority): Inserts an item with given priority.
   * getHighestPriority(): Returns the highest priority item.
   * deleteHighestPriority(): Removes the highest priority item.
   * It can be implemented using array, linked list or heap.
   * Applications of Priority Queue:
   * 1) CPU Scheduling
   * 2) Graph algorithms like Dijkstra’s shortest path algorithm, Prim’s Minimum Spanning Tree, etc
   * 3) All queue applications where priority is involved.
   */

  /**
   * 17.
   * Problem: An Interesting Method to Generate Binary Numbers from 1 to n.
   * Solution: Do a BFS over the binary strings up to n.
   */
  void printBinaryNumbers(int n) {
    Queue<String> queue = new LinkedList<>();
    if (n > 0) {
      queue.add("1");
      for (int i = 0; i < n; i++) {
        String current = queue.remove();
        System.out.println(current);
        queue.add(current + "0");
        queue.add(current + "1");
      }
    }
  }

  /**
   * 18.
   * Problem: How to efficiently implement k Queues in a single array?.
   * Solution:
   */

  /**
   * 19.
   * Problem: Deque | Set 1 (Introduction and Applications).
   * Solution:
   */

  /**
   * 20.
   * Problem: Minimum time required to rot all oranges.
   * Solution:
   */

  /**
   * 21.
   * Problem: Implement a stack using single queue.
   * Solution:
   */

  /**
   * 22.
   * Problem: Find maximum level sum in Binary Tree.
   * Solution:
   */

  /**
   * 23.
   * Problem: Sum of minimum and maximum elements of all subarrays of size k..
   * Solution:
   */

  /**
   * 24.
   * Problem: Distance of nearest cell having 1 in a binary matrix.
   * Solution:
   */

  /**
   * 25.
   * Problem: Implementation of Deque using circular array.
   * Solution:
   */

  /**
   * 26.
   * Problem: Circular Queue | Set 1 (Introduction and Array Implementation).
   * Solution:
   */

  /**
   * 27.
   * Problem: Circular Queue | Set 2 (Circular Linked List Implementation).
   * Solution:
   */

  /**
   * 28.
   * Problem: Applications of Priority Queue.
   * Solution:
   */

  /**
   * 29.
   * Problem: Level order traversal line by line | Set 2 (Using Two Queues).
   * Solution:
   */

  /**
   * 30.
   * Problem: First negative integer in every window of size k.
   * Solution:
   */

  /**
   * 31.
   * Problem: Minimum sum of squares of character counts in a given string after removing k characters.
   * Solution:
   */

  /**
   * 32.
   * Problem: Program for Page Replacement Algorithms | Set 2 (FIFO).
   * Solution:
   */

}
