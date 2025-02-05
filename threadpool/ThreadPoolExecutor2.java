package threadpool;

// FUTURE, CALABLE & COMPLETABLE FUTURE
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadPoolExecutor2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // new thread will be created and it will execute the task
        Future<?> futureObj = executor.submit(() -> { // return type of submit() is future
            try {
                Thread.sleep(7000);
            } catch (Exception e) {
            } // let the task require 7 sec to complete
            System.out.println("Task is processed / executed by : " + Thread.currentThread().getName());
        });

        executor.shutdown();

        // main thread will continue processing
        // --> Now, what if caller (main thread) wants to know the status of the thread, whether its completed or failed, etc.
        System.out.println(futureObj.isDone());
        try {
            System.out.println(futureObj.get(2, TimeUnit.SECONDS)); // wait for only 2 seconds for the task to be completed
        } catch (TimeoutException e) {
            System.out.println("TimeoutException happened");
        }

        try {
            System.out.println(futureObj.get()); // wait for the task to be completed
        } catch (Exception e) {
        }

        System.out.println(futureObj.isDone());
        System.out.println(futureObj.isCancelled());
    }
}
