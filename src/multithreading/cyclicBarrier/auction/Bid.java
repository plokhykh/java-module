package multithreading.cyclicBarrier.auction;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Bid extends Thread {
    private Integer bidId;
    private int price;
    private CyclicBarrier barrier;

    public Bid(Integer bidId, int price, CyclicBarrier barrier) {
        this.bidId = bidId;
        this.price = price;
        this.barrier = barrier;
    }

    public Integer getBidId() {
        return bidId;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client " + this.bidId + " specifies a price.");
            Thread.sleep(new Random().nextInt(3000));
            int delta = new Random().nextInt(50);
            price += delta;
            System.out.println("Bid " + this.bidId + " : " + price);
            this.barrier.await();
            System.out.println("Continue to work...");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
