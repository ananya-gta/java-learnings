package collections.queues;

import java.util.PriorityQueue;

public class MinPq {
    public static void main(String[] args) {
        // by default it will be min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(15);
        pq.add(5);
        pq.forEach(val -> System.out.println(val));
        System.out.println("Polling elements from the queue");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
