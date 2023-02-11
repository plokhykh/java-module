package multithreading.cyclicBarrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Auction {

    private ArrayList<Bid> bids;
    private CyclicBarrier barrier;
    public final int BIDS_NUMBER = 5;

    public Auction(){
        this.bids = new ArrayList<>();
        this.barrier = new CyclicBarrier(this.BIDS_NUMBER, () -> {
            Bid winner = this.defineWinner();
            System.out.println("Bid #" + winner.getBidId() + ", price:" + winner.getPrice() + " win!");
        });
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public boolean add (Bid e){
        return bids.add(e);
    }

    private Bid defineWinner() {
        return Collections.max(bids, Comparator.comparingInt(Bid::getPrice));
    }


}
