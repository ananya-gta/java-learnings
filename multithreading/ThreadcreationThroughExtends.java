package multithreading;

// to crate a thread there are two ways - 
// 2. Extending Thread Class

// Step - 1 Creat a class that extends 'Theead' class and override the run()
class MultithreadingLearning extends Thread {
    @Override
    public void run() {
        System.out.println("code executed by thread" + Thread.currentThread().getName());
    }
}

public class ThreadcreationThroughExtends {
    public static void main(String[] args) {
        System.out.println("Going inside main method: " + Thread.currentThread().getName());
        // Step-2 create an instance of the subclass of Thread class
        MultithreadingLearning tobj = new MultithreadingLearning();
        
        // Step-3 start the thread
        tobj.start(); // this will invoke the subclass' run method 
        System.out.println("Finish main method: " + Thread.currentThread().getName());
    }
}
