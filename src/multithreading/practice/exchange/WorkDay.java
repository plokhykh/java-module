package multithreading.practice.exchange;

import java.util.ArrayList;
import java.util.List;


public class WorkDay {

    public static void main(String[] args) {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("Super Company", 10.6, 10.6, 20, 20, 12.5));
        stocks.add(new Stock("Day Company", 12.2, 12.2, 10, 10, 17.5));

        List<Thread> brokers = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Thread broker = new Thread(new Broker("Broker " + i, stocks));
            brokers.add(broker);
        }

        Exchange exchange = new Exchange(5, brokers, stocks);
        exchange.start();
        exchange.startBrokersWork();
    }
}
