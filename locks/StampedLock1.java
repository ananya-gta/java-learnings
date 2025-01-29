package locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLock1 {
    boolean isAvailable = false;
    StampedLock lock = new StampedLock();
    public void read() {
        // stores the state of the lock 
        long stamp = lock.readLock();
        try {
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {
        } finally {
            lock.unlockRead(stamp);
            System.out.println("Read Lock released by: " + Thread.currentThread().getName());
        }
    }

    public void write() {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write Lock released by: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        StampedLock1 obj = new StampedLock1();

        Thread t1 = new Thread(()->{
            obj.read();
        });
        Thread t2 = new Thread(() -> {
            obj.read();
        });
        StampedLock1 obj1 = new StampedLock1();
        Thread t3 = new Thread(() -> {
            obj1.write();
        });

        t1.start();
        t2.start();
        t3.start();

        // write lock will be acquried by t3 only after t1 and t2 release the read lock
    }
}
