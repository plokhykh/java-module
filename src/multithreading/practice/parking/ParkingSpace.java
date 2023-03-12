package multithreading.practice.parking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ParkingSpace {
    private final Semaphore semaphore;
    private final Queue<Integer> parkingSpaces = new LinkedList<>();

    public ParkingSpace(Queue<Integer> parkingSpaces) {
        this.parkingSpaces.addAll(parkingSpaces);
        this.semaphore = new Semaphore(parkingSpaces.size());
    }

    public Integer getParkingSpace(String carName, int waitingTime) {
        try {
            if (semaphore.tryAcquire(waitingTime, TimeUnit.MILLISECONDS)) {
                final Integer parkingSpace = parkingSpaces.poll();
                System.out.println(carName + " took that place: "+ parkingSpace);
                return parkingSpace;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("There are no free parking space");
    }

    public void returnParkingSpace (Integer parkingSpace){
        this.parkingSpaces.add(parkingSpace);
        semaphore.release();
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "semaphore=" + semaphore +
                ", parkingSpaces=" + parkingSpaces +
                '}';
    }
}
