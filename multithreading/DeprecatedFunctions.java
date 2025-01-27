package multithreading;

// demonstrate why stop(), suspend(), resume() are deprecated
public class DeprecatedFunctions {
    boolean isResourceAvailable = false;

    public synchronized void method() {
        System.out.println("Lock acquired");
        isResourceAvailable = true;

        // keep the lock for 8 second
        try {
            Thread.sleep(8000);
        } catch (Exception e) {
        }

        System.out.println("Lock released");
    }

    public static void main(String[] args) throws InterruptedException {
        // the below object will be shared among threads
        DeprecatedFunctions obj = new DeprecatedFunctions();
        System.out.println("Main started");
        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 is calling method... lock is not acquired yet \n by the time t2 is started");
            obj.method();
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread2 will go to sleep so that t1 can acquire the lock first..");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println(
                    "After waking up from sleep Thread2 will call the same method...\nThread2 is trying to acquire the lock but T1 is waiting on it for 8s");
            obj.method();

        });

        t1.start();
        t2.start();

        // System.out.println("Let main go in sleep for 3 seconds");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        System.out.println("Now main will suspend t1, t1 is suspending");
        t1.suspend();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        System.out.println("Now main will resume t1, t1 is resuming...");
        t1.resume();

        // if you want thread1 and thread2 to finish before main thread finishes
        t1.join();

        System.out.println("Main thread is finishing its work");


    }
}
