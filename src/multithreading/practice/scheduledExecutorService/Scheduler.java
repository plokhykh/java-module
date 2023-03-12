package multithreading.practice.scheduledExecutorService;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);
//
//        scheduledExecutor.scheduleWithFixedDelay(() -> {
//            System.out.println("start scheduleWithFixedDelay "+ LocalDateTime.now());
//            Integer integer = calculateData();
//            System.out.println(integer);
//            System.out.println("stop scheduleWithFixedDelay "+ LocalDateTime.now());
//        }, 1000, 500, TimeUnit.MILLISECONDS );

        scheduledExecutor.scheduleAtFixedRate(() -> {
            System.out.println("start scheduleAtFixedRate " + LocalDateTime.now());
            try {
                Integer integer = calculateData();
                System.out.println(integer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);

    }


    private static List<Integer> getDataFromDB() {
        try {
            System.out.println(Thread.currentThread().getName() + " getDataFromDB  start");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        if ((random.nextInt(2) + 1) % 2 != 0) {
            throw new RuntimeException("error");
        }
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < random.nextInt(15) + 1; i++) {

            integers.add(i);
        }
        System.out.println(Thread.currentThread().getName() + "getDataFromDB  stop. List: " + integers);
        return integers;
    }

    private static Integer calculateData() {
        System.out.println(Thread.currentThread().getName() + " calculateData  start");
        return getDataFromDB().stream().mapToInt((i) -> i).sum();
    }
}
