package multithreading.cyclicBarrier.Racing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Track {
    private final String name;
    private final double length;
    private final List<Car> cars = new ArrayList<>();
    private final Map<String, Double> table = new ConcurrentHashMap<>();


    public void setFinishTime(String name, double time) {
        table.put(name, time);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car findWinner() {
        LinkedHashMap<String, Double> collect = table.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Car car = (Car) collect.entrySet().stream().findFirst().orElse(null);

        return findCarByName(car.getCarName());
    }

    private Car findCarByName(String name) {
        return cars.stream().filter(car -> name.equals(car.getName())).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public void startRace() {
        cars.forEach(Thread::start);
    }
}
