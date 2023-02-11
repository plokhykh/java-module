package multithreading.practice.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class Test {


    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> ints = new CopyOnWriteArrayList<>();
        CountDownLatch downLatch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            threads.add(new Thread(new Worker(downLatch, ints, i)));
        }

        for (Thread thread : threads) {
            thread.start();
        }
        downLatch.await();
        System.out.println(ints);
        int sumInts = ints.stream().mapToInt(i -> i).sum();
        System.out.println(sumInts);
    }

}

class Worker implements Runnable {
    private final CountDownLatch countDownLatch;
    private final List<Integer> ints;
    private final int value;

    public Worker(CountDownLatch countDownLatch, List<Integer> ints, int value) {
        this.countDownLatch = countDownLatch;
        this.value = value;
        this.ints = ints;
    }

    @Override
    public void run() {
        doHardWork();
        ints.add(value);
        countDownLatch.countDown();
    }

    private void doHardWork() {
        try {
            Thread.sleep(new Random().nextInt(9) * 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
