package data.structures.queue;

public class QueueExamples {

  /**
   * 1.
   * Problem: Introduction and Array Implementation
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
   * 2.
   * Problem: Linked List Implementation.
   */

  /**
   * 3.
   * Problem: Priority Queue.
   * Solution: Priority Queue is an extension of queue with following properties.
   * 1) Every item has a priority associated with it.
   * 2) An element with high priority is dequeued before an element with low priority.
   * 3) If two elements have the same priority, they are served according to their order in the queue.
   * A typical priority queue supports following operations.
   * insert(item, priority): Inserts an item with given priority.
   * getHighestPriority(): Returns the highest priority item.
   * deleteHighestPriority(): Removes the highest priority item.
   * It can be implemented using array, linked list or heap.
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 6.
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

}
