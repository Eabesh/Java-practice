package data.structures.queue;

public class QueueExamples {

    /**
     * 6.
     * Problem: Implement Queue using Stacks.
     *
     * Solution:
     * By making deQueue operation costly
     * enQueue(q,  x)
     * 1) Push x to stack1 (assuming size of stacks is unlimited).
     *
     * deQueue(q)
     *      1) If both stacks are empty then error.
     *      2) If stack2 is empty
     *          While stack1 is not empty, push everything from stack1 to stack2.
     *      3) Pop the element from stack2 and return it.
     */


}
