package locks;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrant2 {
    boolean isAvailable = false;

    public void method(ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {
        } finally {
            lock.unlock();
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        
        Reentrant2 obj1 = new Reentrant2();
        Thread t1 = new Thread(()-> {
            obj1.method(lock);
        });
        Reentrant2 obj2 = new Reentrant2();
        Thread t2 = new Thread(() -> {
            obj2.method(lock);
        });

        t1.start();
        t2.start();
    }
}
