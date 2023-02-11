package multithreading.practice.exchanger;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Exchanger;

public class Consumer extends Thread {
    private final Exchanger<Queue<Integer>> exchanger;

    public Consumer(Exchanger<Queue<Integer>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        Queue<Integer> integers = new ArrayDeque<>();
        while (integers.isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName() + " Consumer before exchanger:" + integers);
                Queue<Integer> exchange = exchanger.exchange(integers);
                integers = exchange;
                pollAllElements(integers);
                System.out.println(Thread.currentThread().getName() + " Consumer after exchanger:" + integers);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void pollAllElements(Queue<Integer> integers) {
        while (integers.size() > 0) {
            System.out.println(Thread.currentThread().getName() + "Consumer remove element " + integers.poll());
        }
    }
}
