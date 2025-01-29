package locks;

import java.util.concurrent.Semaphore;

public class Semaphore1 {
    boolean isAvailable = false;
    // permits mean ki at a time how many threads can access a critical section
    Semaphore lock = new Semaphore(2);
    public void method(int number) {
        try {
            lock.acquire();
            System.out.println("Lock acquired by: t"+  number);
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {
        } finally {
            lock.release();
            System.out.println("Lock released by: t" + number);
        }
    }
    public static void main(String[] args) {
        Semaphore1 obj = new Semaphore1();
        Thread t1 = new Thread(()->{obj.method(1);});
        Thread t2 = new Thread(()->{obj.method(2);});
        Thread t3 = new Thread(()->{obj.method(3);});
        Thread t4 = new Thread(()->{obj.method(4);});

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
