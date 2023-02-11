package multithreading.practice.exchanger;

import java.util.Queue;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start main");
        Exchanger<Queue<Integer>> exchanger = new Exchanger<>();

        Producer producer = new Producer(exchanger);
        Producer producer1 = new Producer(exchanger);
        Consumer consumer = new Consumer(exchanger);

        producer.start();
        consumer.start();


        System.out.println("Stop main");
    }
}
