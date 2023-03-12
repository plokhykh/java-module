package multithreading.practice.phaser;

import multithreading.cyclicBarrier.Racing.RacingSimulator;

import java.util.Random;
import java.util.concurrent.Phaser;

public class Worker implements Runnable {
    private final Phaser ps;
    private final String name;
    int currentPhase;

    public Worker(Phaser ps, String name) {
        this.ps = ps;
        this.name = name;
        this.ps.register();
    }

    @Override
    public void run() {
        Random random = new Random();

        currentPhase = ps.getPhase();
        System.out.println(name + ": " + currentPhase + " start");
        loadFile(random.nextInt(10) * 1000+1);
        ps.arriveAndAwaitAdvance();
        System.out.println(name + ": " + currentPhase + " finished");

        currentPhase = ps.getPhase();
        System.out.println(name + ": " + currentPhase + " start");
        convertFile(random.nextInt(10) * 1000+1);
        ps.arriveAndAwaitAdvance();
        System.out.println(name + ": " + currentPhase + " finished");

        currentPhase = ps.getPhase();
        System.out.println(name + ": " + currentPhase + " start");
        saveFile(random.nextInt(10) * 1000+1);
        ps.arriveAndDeregister();
        System.out.println(name + ": " + currentPhase + " finished");
    }

    private void loadFile(int execTime) {
        System.out.println(name + " load file start");
        try {
            Thread.sleep(new Random().nextInt(execTime));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " load file stop");

    }

    private void convertFile(int execTime) {
        System.out.println(name + " convert file start");
        try {
            Thread.sleep(new Random().nextInt(execTime));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " convert file stop");

    }

    private void saveFile(int execTime) {
        System.out.println(name + " save file start");
        try {
            Thread.sleep(new Random().nextInt(execTime));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " save file stop");

    }
}
