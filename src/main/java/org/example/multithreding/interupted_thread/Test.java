package org.example.multithreding.interupted_thread;

import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("thread was interapted");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });
        long start = System.currentTimeMillis();
        System.out.println("start");
            thread.start();

            Thread.sleep(1000);
            thread.interrupt();
        thread.join();
        long end = System.currentTimeMillis();
        System.out.println("end. it takes " + (end-start) +" ms");
    }
}
