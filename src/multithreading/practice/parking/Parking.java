package multithreading.practice.parking;

import java.util.concurrent.ConcurrentHashMap;

public class Parking {
    public static ConcurrentHashMap<Integer, Car> parking = new ConcurrentHashMap<Integer, Car>();


    public static void main(String[] args) {
        parking.put(1, null);
        parking.put(2, null);
        parking.put(3, null);
        System.out.println(parking);
        Car car1 = new Car("Mazda");
        Car car2 = new Car("Toyota");
        Car car3 = new Car ("Honda");
        car3.start();
        car1.start();
        car2.start();
        System.out.println(parking);
    }


    public static int getFreeParkingLot (){
        for (Integer key : parking.keySet()) {
            if(parking.get(key) == null){
                return key;
            }
        }
        return 0;
    }
}
