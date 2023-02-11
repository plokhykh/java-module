package multithreading.cyclicBarrier.Racing;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@AllArgsConstructor
public class Car extends Thread {
    private final String name;
    private final double speed;
    private final CyclicBarrier barrier;
    private Track track;

    @Override
    public void run() {
        try {
            final double timeRace = calculateTimeRace();
            final int random = new Random().nextInt(2);
            System.out.println(name + " started");
            if (random == 1) {
                track.setFinishTime(getName(), Double.MAX_VALUE);
                System.out.println(name + " was crushed");
            } else {
                Thread.sleep((long) timeRace);
                track.setFinishTime(getName(), timeRace);
                System.out.println(name + " finished with time"+ timeRace);
            }
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public double calculateTimeRace() throws InterruptedException {
        final double length = track.getLength();
        return length / speed;
    }


    public String getCarName() {
        return name;
    }
}
