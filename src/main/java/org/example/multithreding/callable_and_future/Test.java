package org.example.multithreding.callable_and_future;

import java.util.Random;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
         Future<Integer> future = executorService.submit(() -> {
            System.out.println("start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("end");
            Random random = new Random();

            return random.nextInt(10);
        });
        executorService.shutdown();
        System.out.println(future.get());
    }
    public static int calc(){
        return 5;
    }
}
