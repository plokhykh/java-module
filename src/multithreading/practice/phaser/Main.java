package multithreading.practice.phaser;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser ph = new Phaser();
        ph.register();
        int currentPhase;

        Worker a = new Worker(ph,"a");
        Worker b = new Worker(ph,"b");
        Worker c = new Worker(ph,"c");

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();


        currentPhase = ph.getPhase();
        System.out.println("Main phase "+ currentPhase + " start");
        ph.arriveAndAwaitAdvance();
        System.out.println("Main phase "+ currentPhase + " stop");

        currentPhase = ph.getPhase();
        System.out.println("Main phase "+ currentPhase + " start");
        ph.arriveAndAwaitAdvance();
        System.out.println("Main phase "+ currentPhase + " stop");

        currentPhase = ph.getPhase();
        System.out.println("Main phase "+ currentPhase + " start");
        ph.arriveAndAwaitAdvance();
        System.out.println("Main phase "+ currentPhase + " stop");

        ph.arriveAndDeregister();
        if(ph.isTerminated()){
            System.out.println("All phases done");
        }

    }

}
