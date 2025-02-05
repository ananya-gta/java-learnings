package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutor1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(), new CustomRejectHandler());

        // create 4 tasks;
        // for (int i = 1; i <= 4; i++) {
        for (int i = 1; i <= 7; i++) {
            // submit task-> accepts runnable
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Task is processed by : " + Thread.currentThread().getName());
                } catch (Exception e) {
                }
            });
        }

        // after submitting, shutdown the executor -> means stop accepting tasks
        executor.shutdown();

        /* till here how the code should work ?
        - 4 tasks hai
        - 2 idle threads, threadPool m task ka wait krrhe hai
        - loop chalega task submit krege, th1 task1 lelega th2 task2 lelega, 
        - task 3 and task 4 queue m wait krrhe hai apni bari aane ka until th1 and th2 finish krte hai task1 and task2 respectively
        - fir th3 and th4 task ko execute krrhe hai
        - now we have to implemment ki agar task5 ya more tasks  ate h toh -- 
        - queue m add kr ni skte queue full h, but, maxPoolSize 4 hai toh yes we can create 2 more threads
        - now there are 7 tasks, and max tasks our threads from threadpool can execute is 6 
        = 4 threads will execute 4 tasks respectively from threadPool then, as soon as 2 threads become free they will pick 1-1 task from queue
        - task7 should be rejected and rest will be processed
         */


    }
}

// creating custom ThreadFactory
class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        // th.setName("MyThread");
        return th;
    }
}

// creating custom reject handler
class CustomRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Rejected task: " + r.toString());
    }
}