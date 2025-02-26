package threadpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class WorkStealingPool1 {
    public static void main (String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> future = pool.submit(new ComputeSumTask(1, 100));
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ComputeSumTask extends RecursiveTask<Integer> {
    int start, end;
     ComputeSumTask (int start, int end) {
        this.start = start;
        this.end = end;
     }
     @Override
     protected Integer compute() {
        if (end - start <= 4) {
              int sum = 0;
              for (int i = start; i <= end; i++) {
                  sum += i;
              }
              return sum;
          } else {
              int mid = start + (end - start) / 2;
              ComputeSumTask left = new ComputeSumTask(start, mid);
              ComputeSumTask right = new ComputeSumTask(mid + 1, end);
              // fork the tasks for parallel execution
              left.fork();
              right.fork();
              // join waits for all the subtasks to complete and then returns the result
              int rightAns = right.join();
              int leftAns = left.join();
              return leftAns + rightAns;
        }
     }
}