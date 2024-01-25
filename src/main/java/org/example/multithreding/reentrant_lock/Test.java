package org.example.multithreding.reentrant_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
    Thread tr1 = new Thread(new Runnable() {
        @Override
        public void run() {
            task.firstThread();
        }
    });
        Thread tr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });
        tr1.start();
        tr2.start();
        tr1.join();
        tr2.join();
        System.out.println(task.getCount());
    }

}

class Task{
    private Lock lock = new ReentrantLock();
    private int count;
    private void increment(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
    public  void firstThread(){
        lock.lock();
        increment();
        lock.unlock();
    }
    public void secondThread(){
        lock.lock();
        increment();
        lock.unlock();
    }

    public int getCount() {
        return count;
    }
}