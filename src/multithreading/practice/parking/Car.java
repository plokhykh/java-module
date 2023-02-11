package multithreading.practice.parking;

public class Car extends Thread {

    private static final int WAIT_PARKING_LOT = 1500;
    private String name;

    public Car(String name) {

        this.name = name;
    }

    @Override
    public void run() {
        try {
            final int freeParkingLot = Parking.getFreeParkingLot();
            if (freeParkingLot == 0) {
                System.out.println("All parking lot occupied");
                Thread.sleep(WAIT_PARKING_LOT);
                int newParkingLot = Parking.getFreeParkingLot();
                if (newParkingLot == 0) {
                    System.out.println("I`m leaving");
                } else {
                    Parking.parking.put(newParkingLot, this);
                    System.out.println(this.toString() + " occupied " + newParkingLot + " parking lot");
                }

            } else {
                Parking.parking.put(freeParkingLot, this);
                System.out.println(this.toString() + " occupied " + freeParkingLot + " parking lot");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
