package multithreading.practice.exchange;

import lombok.Data;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Broker implements Runnable {
    private String name;
    private List<Stock> stocks;
    private Lock lock = new ReentrantLock();

    public Broker(String name, List<Stock> stocks) {
        this.name = name;
        this.stocks = stocks;
    }

    @Override
    public void run() {
        System.out.println(getName() + " start work");
        while (!Thread.currentThread().isInterrupted()) {
            int randomInt = ThreadLocalRandom.current().nextInt();
            try {
                lock.lock();
                final Stock stock = getAvailableStock();
                int randomNumberStocks = new Random().nextInt(stock.getAvailable());
                if (randomInt % 2 == 0) {
                    System.out.println(this.getName() + " has new deal. Sold " + randomNumberStocks + " " + stock.getName());
                    stock.setNewPriceAndQuote(randomNumberStocks);
                } else {
                    System.out.println(this.getName() + " deal fell through");
                    stock.setNewPriceAndQuote();
                }
            }
            catch (Exception e) {
                System.out.println("Stocks ended. " + name + " go home");
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    private Stock getAvailableStock() throws Exception {
//        int randomStock = new Random().nextInt(stocks.size());
//        Stock stock = stocks.get(randomStock);

        for (Stock stock : stocks) {
            if (stock.getAvailable() > 0) return stock;
        }
        throw new Exception("Not available stocks");
    }
}
