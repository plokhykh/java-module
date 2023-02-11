package multithreading.practice.exchanger;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class Producer extends Thread {
    private final Exchanger<Queue<Integer>> exchanger;

    public Producer(Exchanger<Queue<Integer>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        Queue<Integer> integers = new ArrayDeque<>();
        while (integers.isEmpty()) {
            int randomInt = new Random().nextInt(9) + 1;
            for (int i = 1; i <= randomInt; i++) {
                integers.add(i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " Producer before exchanger:" + integers);
                Queue<Integer> exchange = exchanger.exchange(integers);
                integers = exchange;
                System.out.println(Thread.currentThread().getName() + "Producer after exchanger: " + exchange);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
