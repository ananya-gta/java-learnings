package multithreading;

public class SharedResource {
    boolean itemAvailable = false;

    // synchonized put monitor lock
    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item added by : " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("ConsumeItem method invoke by: " + Thread.currentThread().getName());

        // using while loop to avoid "spurious wake-up", sometimes because of system
        // noises
        while (!itemAvailable) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting");
                wait(); // it release the monitor lock
            } catch (Exception e) {
            }
        }

        System.out.println("Item consumed by:" + Thread.currentThread().getName());
        itemAvailable = false;
    }

    public static void main(String[] args) {
        System.out.println("Main method is started...");
        SharedResource sharedResource = new SharedResource();
        Thread producer = new Thread(() -> {
            System.out.println("Producer thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000l);
            } catch (Exception e) {
            }
            sharedResource.addItem();
        });

        Thread consumer = new Thread(() -> {
            System.out.println("Consumer thread: " + Thread.currentThread().getName());
            sharedResource.consumeItem();
        });

        producer.start();
        consumer.start();
        System.out.println("Main method is ended.");
    }
}
