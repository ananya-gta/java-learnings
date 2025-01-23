package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int MAX_SIZE = 10;

    public synchronized void produce(int item) {
        while (queue.size() == MAX_SIZE) {
            try {
                System.out.println("Queue " + Thread.currentThread().getName() + " is waiting because the queue is full, cannot add item");
                wait(); // it releases the monitor lock
            } catch (Exception e) {
            }
        }

        queue.add(item);
        System.out.println("Produced item: " + item);

        // notify consumer that there is new data, make the consumer thread runnable again;
        notifyAll();
    }

    public synchronized int consumer() {
        while (queue.isEmpty()) {
            try {
                System.out.println("Queue " + Thread.currentThread().getName()
                        + " is waiting because the queue is empty, cannot remove item");
                wait(); // it releases the monitor lock
            } catch (Exception e) {
            }}
        // Remove item from the buffer
        int item = queue.poll();
        System.out.println("Consumed: " + item);

        // Notify producer that there is space in the buffer
        notifyAll();

        return item;
    }
}
