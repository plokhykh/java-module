package multithreading.practice.sychronization;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bank {

    private final double[] accounts;

    //private final Object lock = new Object();

    //private final Lock lock;
    private final Lock readLock;
    private final Lock writeLock;

    private final Condition condition;

    /*
    public Bank(double[] accounts) {
        this.accounts = accounts;
    }

     */

    public Bank(int count, double initBalance) {
        this.accounts = new double[count];
        Arrays.fill(this.accounts, initBalance);
        //this.lock = new ReentrantLock();
        //this.condition = lock.newCondition();
        ReentrantReadWriteLock l = new ReentrantReadWriteLock();
        this.readLock = l.readLock();
        this.writeLock = l.writeLock();
        this.condition = writeLock.newCondition();

    }

    public /*synchronized*/ void transfer(int from, int to, double amount) throws InterruptedException {

        //lock.lock();
        writeLock.lock();
        try {

           /*
            if (accounts[from] < amount) {
                System.out.println(Thread.currentThread().getName() + " not enough money for transfer");
                return;
            }


            */
            // synchronized (lock) {


            while (accounts[from] < amount) {
                //lock.wait();
                condition.await();
            }


            accounts[from] -= amount;

        /*
        try {
            Thread.sleep(new Random().nextInt(500) + 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

            accounts[to] += amount;

            System.out.printf(Thread.currentThread().getName() + " %10.2f from %d to %d", amount, from, to);
            System.out.printf(Thread.currentThread().getName() + " Total Balance: %10.2f%n", getTotalBalance());
            condition.signalAll();

        } finally {
            //lock.unlock();
            writeLock.unlock();
        }


        //notifyAll();
        //lock.notifyAll();
        // }
    }

    public /*synchronized*/ double getTotalBalance() {
        // synchronized (this) {

        // lock.lock();
        readLock.lock();
        try {

            //synchronized (lock) {
            return Arrays.stream(accounts).sum();
            //}
            //}
        } finally {
            //lock.unlock();
            readLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }
}

