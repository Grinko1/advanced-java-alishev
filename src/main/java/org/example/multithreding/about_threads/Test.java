package org.example.multithreding.about_threads;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        Thread myThread3 = new Thread(new Runner());


        myThread.start();
        myThread2.start();
        myThread3.start();
        System.out.println(" main thread");

    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("my thread " + i);
        }
    }
}
class Runner implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("runner " + i);
        }
    }
}