package multithreading.practice.blockingQueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        for (int i = 0; i < 4; i++) {
            new Thread(new Producer(queue)).start();
            
        }

        for (int i = 0; i < 2; i++) {
            new Thread(new Consumer(queue)).start();

        }


        System.out.println(queue);
    }

}
