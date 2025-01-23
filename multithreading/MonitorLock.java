package multithreading;

public class MonitorLock {

    public synchronized void task1() {
        try {
            System.out.println("Task 1 started");
            Thread.sleep(10000);
            System.out.println("Task 1 finished");
        } catch (Exception e) {
        }
    }

    public void task2() {
        System.out.println("Task 2 before entering synchornised block");
        synchronized (this) {
            System.out.println("Task 2 after entering synchornised block");
        }
    }

    public void task3() {
        System.out.println("task3");
    }

    public static void main(String[] args) {
        MonitorLock obj = new MonitorLock();
        Thread t1 = new Thread(() -> {
            obj.task1();
        });

        Thread t2 = new Thread(() -> {
            obj.task2();
        });

        Thread t3 = new Thread(() -> {
            obj.task3();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
