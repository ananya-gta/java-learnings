package multithreading;

import java.util.Queue;

public class ProducerConsumer {
    private Queue<Integer> queue;
    private int bufferSize;

    public ProducerConsumer(int bufferSize) {
        queue = new java.util.LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception{
        while (queue.size() == bufferSize) {
            System.out.println("producer will wait till the buffer  is empty");
            wait();
        }

        queue.add(item);
        System.out.println("producer added item: " + item + " to the buffer");
        // notify the consumer that there is no space in buffer now
        notify();
    }

    public synchronized int consume() throws Exception{
        while (queue.isEmpty()) {
            System.out.println("consumer will wait till the buffer is not empty");
            wait();
        }
        int consumedItem = queue.poll();
        // notify the producer that there is space in buffer now
        notify();
        System.out.println("Consumer consumed this item: " + consumedItem);
        return consumedItem;
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer(5);
        Thread producer = new Thread(()->{
            try {
                for (int i = 0; i < 6; i++) {
                    producerConsumer.produce(i);
                }
            } catch (Exception e) {}
        });

        Thread consumer = new Thread(()->{
            try {
                for (int i = 0; i < 6; i++) {
                    producerConsumer.consume();
                }
            } catch (Exception e) {}
        });

        producer.start();
        consumer.start();
    }
    
}