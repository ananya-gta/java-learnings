package locks;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    boolean isAvailable = false;

    public void read(ReentrantReadWriteLock  lock) {
        try {
            lock.readLock().lock();
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {
        } finally {
            lock.readLock().unlock();
            System.out.println("Read Lock released by: " + Thread.currentThread().getName());
        }
    }

    public void write(ReentrantReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
        } finally {
            lock.writeLock().unlock();
            System.out.println("Write Lock released by: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ReadWriteLock obj = new ReadWriteLock();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(()->{
            obj.read(lock);
        });
        Thread t2 = new Thread(() -> {
            obj.read(lock);
        });
        ReadWriteLock obj1 = new ReadWriteLock();
        Thread t3 = new Thread(() -> {
            obj1.write(lock);
        });

        t1.start();
        t2.start();
        t3.start();

        // write lock will be acquried by t3 only after t1 and t2 release the read lock
    }
}
