package multithreading.practice.exchange;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Stock {
    private String name;
    private final double startPrice;
    private double price;
    private final int total;
    private int available;
    private double quote;
    private Lock lock = new ReentrantLock();


    public Stock(String name, double startPrice, double price, int total, int available, double quote) {
        this.name = name;
        this.startPrice = startPrice;
        this.price = price;
        this.total = total;
        this.available = available;
        this.quote = quote;
    }

    public void setNewPriceAndQuote(int numberSoldStocks) {
        int random = new Random().nextInt(5);
        this.setAvailable(this.getAvailable() - numberSoldStocks);
        this.setPrice(this.getPrice() + random);
        this.setQuote((this.getQuote() * random) + this.getQuote());
        System.out.println(name + ": new price " + this.getPrice() + ", new quote " + this.getQuote() + ". Available stocks " + this.getAvailable());
    }

    public void setNewPriceAndQuote() {
        int random = new Random().nextInt(200);
        this.setPrice(this.getPrice() - random);
        this.setQuote(this.getQuote() - (this.getQuote() * random));
        System.out.println(name + ": new price " + this.getPrice() + ", new quote " + this.getQuote() + ". Available stocks " + this.getAvailable());

    }

}
