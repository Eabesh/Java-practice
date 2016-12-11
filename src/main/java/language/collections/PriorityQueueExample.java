package language.collections;


import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue = new PriorityQueue<String>(10, comparator);
        queue.add("short");
        queue.add("very long indeed");
        queue.add("medium");
        while (queue.size() != 0) {
            System.out.println(queue.remove());
        }

        PriorityQueue<String> queue2 = new PriorityQueue<String>();
        queue2.add("short");
        queue2.add("very long indeed");
        queue2.add("medium");
        while (queue2.size() != 0) {
            System.out.println(queue2.remove());
        }

        PriorityQueue<Integer> queue3 = new PriorityQueue<Integer>();
        queue3.add(2);
        queue3.add(3);
        queue3.add(1);
        while (queue3.size() != 0) {
            System.out.println(queue3.remove());
        }
    }

}


