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
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Queue<HttpClient> clients = new LinkedList<>();


    HttpPool(Queue<HttpClient> clients) {
        this.clients.addAll(clients);
    }

    public HttpClient getClient() {
        HttpClient ret = null;
        try {
            semaphore.acquire();
            System.out.println(semaphore.hasQueuedThreads() + " " + semaphore.getQueueLength());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return clients.poll();

    }

    public void returnClient(HttpClient client) {
        if (client == null) throw new IllegalArgumentException("another err");
        clients.add(client);
        semaphore.release();
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

        Queue<HttpClient> clients = new ArrayDeque<HttpClient>() {
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

