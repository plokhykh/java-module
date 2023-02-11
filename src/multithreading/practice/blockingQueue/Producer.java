package multithreading.practice.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10; i++) {
                queue.put(i);
                System.out.println("Producer " + Thread.currentThread().getName() + " value:" + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
