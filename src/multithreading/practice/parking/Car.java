package multithreading.practice.parking;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Car extends Thread {
    private String name;
    private ParkingSpace parkingSpace;

    public Car(String name, ParkingSpace parkingSpace) {
        this.name = name;
        this.parkingSpace = parkingSpace;
    }

    @Override
    public void run() {
        Integer freeParkingSpace = null;

        try {
            System.out.println(name+ " waiting parking space");
            freeParkingSpace = parkingSpace.getParkingSpace(name, 1000);
            final int parkingTime = (ThreadLocalRandom.current().nextInt(500, 2000)) ;
            Thread.sleep(parkingTime);
        } catch (RuntimeException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (freeParkingSpace != null) {
                System.out.println(name + " vacated parking space: " + freeParkingSpace);
                parkingSpace.returnParkingSpace(freeParkingSpace);
            }

        }
    }


}
