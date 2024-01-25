package org.example.multithreding.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();
        Thread tr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread tr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tr1.start();
        tr2.start();
        tr1.join();
        tr2.join();


    }
}
class ProducerConsumer{
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object();
    public void produce() throws InterruptedException {
        int value= 0;
        while (true){
            synchronized (lock){
                while (queue.size() == LIMIT){
                    lock.wait();
                }
               queue.offer(value++);
                lock.notify();


            }
        }


    }
    public void consumer() throws InterruptedException {
        while(true){
            synchronized (lock){
                while(queue.size() == 0) {
                    lock.wait();
                }

                int value = queue.poll();

                System.out.println(value);
                System.out.println("queue size is: " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}
