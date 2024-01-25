package org.example.multithreding.synchronized_lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        new Worker().main();
    }
}

class Worker {
    Random random = new Random();
    Object lock1 = new Object();
    Object lock2 = new Object();


    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {
        synchronized (lock1) {
          addToList(list1);
        }
    }

    public void addToList2() {
        synchronized (lock2) {
        addToList(list2);
        }
    }
    public void addToList(List<Integer> list){
        for (int i = 0; i < 2000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add(random.nextInt(100));
        }
    }

    public void main() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                addToList1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                addToList2();
            }
        });

        thread1.start();
        thread2.start();
        thread2.join();
        thread1.join();

        long end = System.currentTimeMillis();
        System.out.println("Method took: " + (end - start));
        System.out.println(list1.size());
        System.out.println(list2.size());


    }
}