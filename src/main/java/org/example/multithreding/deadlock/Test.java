package org.example.multithreding.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread tr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread tr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tr1.start();
        tr2.start();
        tr1.join();
        tr2.join();
        runner.finished();

    }
}

class Runner {
    private final Account account1 = new Account();
    private final Account account2 = new Account();
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) throws InterruptedException {
        boolean firstLocktaken = false;
        boolean secondLocktaken = false;
        while (true) {
            try {
                firstLocktaken = lock1.tryLock();
                secondLocktaken = lock2.tryLock();
            } finally {
                if (firstLocktaken && secondLocktaken) {
                    return;
                }
                if (firstLocktaken) {
                    lock1.unlock();
                }
                if (secondLocktaken) {
                    lock2.unlock();
                }

            }
            Thread.sleep(1);
        }


    }

    public void firstThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock1, lock2);
            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
//        transferFromTo(account1, account2);
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock2, lock1);
            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
//        transferFromTo(account2, account1);
    }

    private void transferFromTo(Account from, Account to) {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            lock1.lock();
            lock2.lock();
            try {
                Account.transfer(from, to, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        int b1 = account1.getBalance();
        int b2 = account2.getBalance();
        System.out.println(b1);
        System.out.println(b2);
        System.out.println("Total balance " + (b1 + b2));
    }
}

class Account {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account ac1, Account ac2, int amount) {
        ac1.withdraw(amount);
        ac2.deposit(amount);
    }
}