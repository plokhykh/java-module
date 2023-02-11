package multithreading.practice.semaphore;

import java.util.*;
import java.util.concurrent.Semaphore;

class HttpClient {

    public String execute(String some) {
        int pause = new Random().nextInt(500);
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return some + " " + pause;
    }
}

class HttpPool {

    private static final int POOL_SIZE = 5;
    private int countAvailableClients = 3;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Queue<HttpClient> clients = new ArrayDeque<>();
    private final Queue<HttpClient> availableClients = new ArrayDeque<>();

    HttpPool(List<HttpClient> clients) {
        if (clients == null || clients.size() != POOL_SIZE) {
            throw new IllegalArgumentException("some err");
        }
        this.clients.addAll(clients);
        this.availableClients.add(clients.remove(0));
        this.availableClients.add(clients.remove(1));
        this.availableClients.add(clients.remove(2));
    }

    public HttpClient getClient() {
        if (countAvailableClients == 3 && availableClients.poll() == null) {
            while (clients.peek() != null) {
                availableClients.add(clients.poll());
            }
        }
        System.out.println("Available clients before use - "+ availableClients.size());
        HttpClient ret = null;
        try {
            semaphore.acquire();
            System.out.println(semaphore.hasQueuedThreads() + " " + semaphore.getQueueLength());
            ret = availableClients.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return ret;
    }

    public void returnClient(HttpClient client) {
        if (client == null) throw new IllegalArgumentException("another err");
        clients.add(client);
        semaphore.release();
    }

    private void addAvailableClients (int countClients){

    }

}

class ClientRunner extends Thread {

    private final HttpPool pool;

    ClientRunner(HttpPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        HttpClient cl = null;
        try {
            cl = pool.getClient();
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " get " + cl.execute("text"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (cl != null) pool.returnClient(cl);
        }
    }
}

public class SomeTask {

    public static void main(String[] args) {

        // if no 1, normal 3, max 5
        // if >30 sec = go away

        List<HttpClient> clients = new ArrayList<HttpClient>() {
            {
                add(new HttpClient());
                add(new HttpClient());
                add(new HttpClient());
                add(new HttpClient());
                add(new HttpClient());
            }
        };


        HttpPool pool = new HttpPool(clients);

        for (int i = 0; i < 50; i++) {
            new ClientRunner(pool).start();
        }

    }
}

