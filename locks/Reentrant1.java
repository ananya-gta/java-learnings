package locks;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrant1 {

    boolean isAvailable = false;
    // It is part of the java.util.concurrent.locks package
    ReentrantLock lock = new ReentrantLock();

    public void method() {
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
        Reentrant1 obj = new Reentrant1();
        Thread t1 = new Thread(()-> {
            System.out.println("Thread name is: " + Thread.currentThread().getName());
            obj.method();
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread name is: " + Thread.currentThread().getName());
            obj.method();
        });

        t1.start();
        t2.start();
    }
}
