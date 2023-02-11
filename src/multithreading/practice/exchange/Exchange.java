package multithreading.practice.exchange;

import lombok.Data;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Exchange extends Thread {

    private static final double MIN_VALUE = 1.0;
    private static final double MAX_VALUE = 5.0;
    private int count_deal = 3;

    private double index;
    private List<Thread> brokers;
    private List<Stock> stocks;
    private Lock lock = new ReentrantLock();

    public Exchange(double index, List<Thread> brokers, List<Stock> stocks) {
        this.index = index;
        this.brokers = brokers;
        this.stocks = stocks;
    }

    @Override
    public void run() {
        System.out.println("Exchange start work");
        while (!Thread.currentThread().isInterrupted() ) {
            try {
                Thread.sleep(2000);
                if (index < 0) {
                    stoppedTrading();
                }
                changeIndexDueStocksSale();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }  stoppedTrading();

    }

    public void startBrokersWork (){
        for (Thread broker : brokers) {
            broker.start();
        }
    }


    private void stoppedTrading() {
        System.out.println("Exchange index fell");
        for (Thread broker : brokers) {
            broker.interrupt();
            System.out.println(broker.getName() + " is stopped");
        }
        Thread.currentThread().interrupt();
        System.out.println("Trading stopped");
    }

    private void changeIndexDueStocksSale() throws InterruptedException {
        if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
            count_deal -= 1;
            try {
                for (Stock stock : stocks) {
                    Random random = new Random();
                    double randomDouble = MAX_VALUE + (MAX_VALUE - MIN_VALUE) * random.nextDouble();
                   if(stock.getPrice() >= stock.getStartPrice()){
                       index += randomDouble;
                       System.out.println("Exchange index is increased");
                   } else {
                       index -= randomDouble;
                       System.out.println("Exchange index is downgraded");
                   }
                }
            } finally {
                lock.unlock();
            }
        }

    }
}
