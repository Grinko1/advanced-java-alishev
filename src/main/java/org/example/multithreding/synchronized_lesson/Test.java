package org.example.multithreding.synchronized_lesson;

public class Test {
    private  int count;
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.doWork();
    }
    public synchronized void increment(){
        count++;
    }
    public void doWork() throws InterruptedException {
        Thread tr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        Thread tr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        tr1.start();
        tr2.start();
        tr1.join();
        tr2.join();

        System.out.println(count +" count");
    }
}
