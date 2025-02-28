package threadpool;

import java.util.concurrent.*;

public class ThreadLocal1 {
// each thread has its own ThreadLocal class and class has ThreadLocal variables which hold the value for particular thread
    public static void main(String[] args){
        ThreadLocal<String> threadLocalObj = new ThreadLocal<>();
        // we need only one object of ThreadLocal class for all threads
        // each thread can use the same object to set and get its own threadLocal variable.
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(()->{
            threadLocalObj.set(Thread.currentThread().getName());
            // my task is completed, perform cleanup
            threadLocalObj.remove();
        });
        for (int i = 0; i< 15; i++) {
            executor.submit(()->{
                System.out.println(threadLocalObj.get());
            });
        }
        
    }
}
