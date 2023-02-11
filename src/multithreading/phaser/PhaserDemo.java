package multithreading.phaser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        List<Item> listGood = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            listGood.add(new Item(i));
        }

        Storage storageA = Storage.createStorage(listGood.size(), listGood);
        Storage storageB = Storage.createStorage(listGood.size());

        Phaser phaser = new Phaser();
        phaser.register();
        int currentPhase;

        Thread tr1 = new Thread(new Truck(phaser, "tr1", 5, storageA, storageB));
        Thread tr2 = new Thread(new Truck(phaser, "tr2", 6, storageA, storageB));
        Thread tr3 = new Thread(new Truck(phaser, "tr3", 7, storageA, storageB));

        printGoodsToConsole("Товары на складе A", storageA);
        printGoodsToConsole("Товары на складе B", storageB);

        tr1.start();
        tr2.start();
        tr3.start();

        // синхронизация загрузки
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Загрузка колонны завершена. Фаза " + currentPhase
                + " завершена.");
// синхронизация поездки
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Поездка колонны завершена. Фаза " + currentPhase
                + " завершена.");
// синхронизация разгрузки
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Разгрузка колонны завершена. Фаза " + currentPhase
                + " завершена.");
        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) {
            System.out.println("Фазы синхронизированы и завершены.");
        }
        printGoodsToConsole("Товары на складе A", storageA);
        printGoodsToConsole("Товары на складе B", storageB);
    }

    public static void printGoodsToConsole(String title, Storage storage) {
        System.out.println(title);
        Iterator<Item> goodsIterator = storage.iterator();
        while (goodsIterator.hasNext()) {
            System.out.print(goodsIterator.next().getRegistrationNumber() + " ");
        }
        System.out.println();
    }
}
