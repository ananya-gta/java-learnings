package locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// demonstrate await() and signal()
public class ConditionInLocks {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void producer() {
        try{
            lock.lock();
            System.out.println("P Lock acquired by thread: " + Thread.currentThread().getName());
            if (isAvailable) {
                // thread has to wait for consumer
                condition.await();
            }
            isAvailable = true;
            condition.signal();

        } catch(Exception e) {} finally{
            lock.unlock();
            System.out.println("P Lock released by thread: " + Thread.currentThread().getName());
        }
    }
    public void consumer() {
        try {
            Thread.sleep(1000);
            lock.lock();
            System.out.println("C Lock acquired by thread: " + Thread.currentThread().getName());
            System.out.println(isAvailable);
            if (!isAvailable) {
                // thread has to wait for producer
                System.out.println("Consumer thread is waiting...");
                condition.await();
            }
            isAvailable = true;
            condition.signal();

        } catch (Exception e) {
        } finally {
            lock.unlock();
            System.out.println("C Lock released by thread: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ConditionInLocks obj = new ConditionInLocks();
        Thread t1 = new Thread(()->{obj.producer();});
        Thread t2 = new Thread(()->{obj.consumer();});
        t1.start();
        t2.start();
    }
}
