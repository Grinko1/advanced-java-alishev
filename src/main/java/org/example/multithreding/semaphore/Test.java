package org.example.multithreding.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        Semaphore semaphore = new Semaphore(3);
//        -----------------------------------------
//        semaphore.release(); - возвращиет разрешение (2 + 1)
//        semaphore.acquire(); - дает разрешение (3 -1)
//        semaphore.availablePermits() - возвращает кол-во разрешений
//        -----------------------------------------

        ExecutorService executor = Executors.newFixedThreadPool(200);
        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);




}
}

class Connection{
    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);
    private Connection(){}

    public static Connection getConnection(){
        return  connection;
    }
    public void work() throws InterruptedException {
        semaphore.acquire();
        try{
            doWork();
        }finally {
            semaphore.release();
        }
    }
    private void doWork() throws InterruptedException {
        synchronized (this){
            connectionsCount++;
            System.out.println(connectionsCount);
        }
        Thread.sleep(5000);
        synchronized (this){
            connectionsCount--;
            System.out.println(connectionsCount);
        }

    }
}