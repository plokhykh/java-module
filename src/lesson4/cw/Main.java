package lesson4.cw;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "audi", 350, new Owner("Max", 34, 10), 15000, 2019));
        cars.add(new Car(2, "mazda", 200, new Owner("Kolya", 27, 3), 9000, 2012));
        cars.add(new Car(3, "honda", 290, new Owner("Valya", 39, 18), 12500, 2017));
        cars.add(new Car(4, "bmw", 320, new Owner("Bogdan", 22, 2), 14500, 2020));
        cars.add(new Car(5, "renault", 270, new Owner("Vasya", 24, 5), 11000, 2016));
        cars.add(new Car(6, "toyota", 310, new Owner("Ivan", 30, 8), 17000, 2021));
        cars.add(new Car(7, "nissan", 250, new Owner("Katya", 33, 11), 9000, 2015));
        cars.add(new Car(8, "ford", 280, new Owner("Igor", 26, 4), 10500, 2018));

        List<Owner> newDrivers = new ArrayList<>();
        newDrivers.add(new Owner("Vitya", 26, 7));
        newDrivers.add(new Owner("Jenya", 30, 9));
        newDrivers.add(new Owner("Kostya", 37, 19));
        newDrivers.add(new Owner("Lesha", 29, 3));


        List<Car> improvedCars = cars.stream()
                .peek(car -> {
                    if (car.getId() % 2 == 0) {
                        double tenPercentOfPower = car.getPower() * 0.1;
                        car.setPower((int) (car.getPower() + tenPercentOfPower));
                    }
                })
                .peek(car -> {
                    if (car.getOwner().getAge() > 25 || car.getOwner().getDrivingExperience() < 5)
                        car.getOwner().setDrivingExperience(car.getOwner().getDrivingExperience() + 1);
                })
                .collect(Collectors.toList());


        int priceAllCars = cars.stream()
                .reduce(0, (subtotal, element) -> subtotal + element.getPrice(), Integer::sum);

        final int[] index = {newDrivers.size()-1};
        List<Car> updateNewDrivers = cars.stream()
                .filter(car -> car.getId() % 2 == 0)
                .peek(car -> {
                    car.setOwner(newDrivers.get(index[0]));
                    index[0] = index[0]-1;
                })
                .collect(Collectors.toList());


        System.out.println(improvedCars);
        System.out.println(priceAllCars);
        System.out.println(updateNewDrivers);


    }
}
