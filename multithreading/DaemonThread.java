package multithreading;

public class DaemonThread {
        public static void main(String[] args) {
            Thread daemonThread = new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("Daemon thread running...");
                        Thread.sleep(1000); // Simulate some work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            // Set the thread as a daemon thread
            daemonThread.setDaemon(true);

            // Start the daemon thread
            daemonThread.start();

            // Main thread will sleep for 3 seconds, then exit
            try {
                Thread.sleep(3000); // Main thread sleeps for 3 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Main thread finished. Daemon thread will be terminated.");
        }
    

}
