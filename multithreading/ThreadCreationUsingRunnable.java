package multithreading;

// to crate a thread there are two ways - 
// 1. Implementing Runnable interface

// Step - 1 Creat a class that implements Runnable interface which will implement the run() to tell the thread what task to do
class MultithreadingLearning implements Runnable {
    @Override
    public void run() {
        System.out.println("code executed by thread" + Thread.currentThread().getName());
    }
}

public class ThreadCreationUsingRunnable {
    public static void main(String[] args) {
        System.out.println("Going inside main method: " + Thread.currentThread().getName());
        // Step-2 create an instance of the class that implements the Runnable interface
        MultithreadingLearning obj = new MultithreadingLearning();
        // Step-3 create a thread object passing the object of the class that implements the Runnable interface
        Thread t = new Thread(obj);
        // Step-4 start the thread
        t.start(); 
        System.out.println("Finish main method: " + Thread.currentThread().getName());
    }
}
