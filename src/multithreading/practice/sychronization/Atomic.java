package multithreading.practice.sychronization;

import com.sun.org.glassfish.external.statistics.RangeStatistic;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Atomic {

    static private AtomicLong atomicLong = new AtomicLong();

    public static void main(String[] args) {
        atomicLong.addAndGet(8);
        atomicLong.incrementAndGet();

        long oldValue;
        long newValue;

        do {
            oldValue = atomicLong.get();
            newValue = Math.max(oldValue, getRandomLong());
        } while (!atomicLong.compareAndSet(oldValue, newValue));

        atomicLong.updateAndGet((value) -> Math.max(value, getRandomLong()));
        atomicLong.accumulateAndGet(getRandomLong(), Math::max);

        LongAdder longAdder = new LongAdder();
        longAdder.increment();
    }

    private static Long getRandomLong() {
        return new Random().nextLong();
    }
}
