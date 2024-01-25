package org.example.multithreding.volatile_example;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        myThread.shutDown();

    }
}

class MyThread extends Thread{

    // volatile - дает понять что значение изменчивое, поток будет брать данные не из кеша а из гланой памяти
    private volatile boolean running = true;
    public void run(){
        while (running){
            System.out.println("Hello");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutDown() {
        this.running = false;
    }
}