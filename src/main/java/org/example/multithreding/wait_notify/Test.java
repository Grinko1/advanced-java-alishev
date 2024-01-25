package org.example.multithreding.wait_notify;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn = new WaitAndNotify();
        Thread tr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread tr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consumer();
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
class WaitAndNotify{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("producer thread started");
            wait();
            System.out.println("producer thread resume");
        }
    }
    public void consumer() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);
        synchronized (this){
            System.out.println("waiting for return key pressed");
            scanner.nextLine();
            notify();
        }
    }
}