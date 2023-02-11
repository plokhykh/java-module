package multithreading.cyclicBarrier.Racing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class RacingSimulator {


    public static void main(String[] args) {
        System.out.println("Start simulator");
        Track track = new Track("New York", 2006.6);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                final Car winner = track.findWinner();
                System.out.println("Winner " + winner.getCarName());

            }
        });

        track.addCar(new Car("Audi", 190, cyclicBarrier, track));
        track.addCar(new Car("Honda", 150, cyclicBarrier, track));
        track.addCar(new Car("Toyota", 120, cyclicBarrier, track));
        track.addCar(new Car("Mercedes", 170, cyclicBarrier, track));
        track.addCar(new Car("Hyndai", 180, cyclicBarrier, track));


        track.startRace();
        System.out.println("Stop simulator");
    }
}
