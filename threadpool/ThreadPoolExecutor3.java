package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutor3 {
     public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

                /*----------------------USE CASE 1--------------------------- */
        // new thread will be created and it will execute the task
        Future<?> futureObj = executor.submit(() -> { // return type of submit() is future which will return null- object's default value
            System.out.println("Task1 with Runnable");
        }); // this thread is not returning anything toh it will call runnable

        try {
            Object obj = futureObj.get();
            System.out.println(obj == null); // in Runnable output value is set as null, if you check submit() implementation you will se it has put void and ? means anything
        } catch (Exception e) {}


        /*----------------------USING MY OWN RUNNABLE IMPLEMENTATION--------------------------- */
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObj1 = executor.submit(new MyRunnable(output), output);
        // either use lambda or Create a class and then implement Runnable
        Future<List<Integer>> futureObj2 = executor.submit (() -> {
            output.add(100);
            System.out.println("Task2 with Runnable and Return object");
        }, output);
        try {
            futureObj1.get();
            // 1 way if you have access to output
            System.out.println(output.get(0));
            // 2 way if somehow you have no access
            List<Integer> result = futureObj2.get();
            System.out.println(result.get(0));

        } catch (Exception e) {
        }

        /*----------------------USE CASE 3--------------------------- */
        Future<List<Integer>> futureObj3 = executor.submit(() -> {
            System.out.println("Task3 with Callable");
            List<Integer> output2 = new ArrayList<>();
            output2.add(101);
            return output2;
        });

        try {
            List<Integer> result = futureObj3.get();
            System.out.println(result.get(0));
        } catch (Exception e) {}

        executor.shutdown();
    }

}

// I don't want null as output for futureObj, so I created my own implementation
class MyRunnable implements Runnable {
    List<Integer> list; 
    MyRunnable(List<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        list.add(100);
    }
}
