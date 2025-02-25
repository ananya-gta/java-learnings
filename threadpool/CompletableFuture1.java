package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFuture1 {
    public static void main(String[] args) {
        try {
            // cReat emy own poolExecutor
            ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            // Completable future has 5 main functions
            // 1. supplyAsync()
            CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync(() -> {
                return "task completed using completableFuture";
            }, executor);
            // since completable futre is a child of futre so its get method can be used
            System.out.println(asyncTask.get());

            // 2. thenApply()
            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                return "task completed using completableFuture";
            }, executor)
                    .thenApply((String val) -> {
                        return val + ", also used thenApply()";
                    });

            // since completable futre is a child of futre so its get method can be used
            System.out.println(asyncTask1.get());
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
