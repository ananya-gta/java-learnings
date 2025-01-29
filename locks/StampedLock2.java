package locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLock2 {
    int a = 10;
    StampedLock lock = new StampedLock();

    public void read() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Taken optimistic read");
            a = 11;
            Thread.sleep(4000);
            // checks that if the value of 'a' has been changed, the read will fail and it will be rollbacked
            if (lock.validate(stamp)) {
                System.out.println("Update a value successfully");
            } else {
                System.out.println("rollback...");
                a = 10;
            }
        } catch (Exception e) {
        }
    }

    public void write() {
        long stamp = lock.writeLock();
        System.out.println("write lock acquired by: " + Thread.currentThread().getName());
        try {
            System.out.println("performing work");
            a = 9;
        }  finally {
            lock.unlockWrite(stamp); // If the lock state matches the stamp returned by a write-lock operation, release the exclusive lock.
            System.out.println("write lock released by: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        StampedLock2 obj = new StampedLock2();

        Thread t1 = new Thread(() -> {
            obj.read();
        });
        Thread t2 = new Thread(() -> {
            obj.write();
        });
        

        t1.start();
        t2.start();
   
        
    }

}
