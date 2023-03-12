package multithreading.practice.parking;


import java.util.Arrays;
import java.util.LinkedList;

public class Parking {
    private static final int PARKING_SPACES_COUNT = 10;

    public static void main(String[] args) {
        LinkedList<Integer> parkingSpaces = new LinkedList<>();

        for (int i = 1; i <= PARKING_SPACES_COUNT; i++) {
            parkingSpaces.add(i);
        }

        ParkingSpace parkingSpace = new ParkingSpace(parkingSpaces);

        for (int i = 0; i < 20; i++) {
            new Car("Honda "+i, parkingSpace).start();
        }
    }
}
