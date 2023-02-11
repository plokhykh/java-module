package multithreading.practice.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Consumer " + Thread.currentThread().getName() + " value:" + queue.take());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
