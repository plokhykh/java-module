package multithreading.practice.sychronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {
//        FutureTask<Integer> tasks = new FutureTask<>(() -> {
//            Thread.sleep(2000);
//            return 1;
//        });
//
//        final Thread thread = new Thread(tasks);
//        thread.start();
//        try{
//            final Integer integer = tasks.get();
//            System.out.println(integer);
//        } catch (InterruptedException  | ExecutionException ex){
//            ex.printStackTrace();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<String> service = new ExecutorCompletionService<>(executorService);
        List<Callable<String>> callableList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            callableList.add((createTask("string " + i)));
        }

        callableList.forEach(service::submit);

        for (int i = 0; i < callableList.size(); i++) {
            try {
                String processedStr = processString(service.take().get());
                System.out.println(processedStr);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown();
    }

    private static String processString(String str) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

    private static Callable<String> createTask(String str) {
        int random = (new Random().nextInt(5) + 1) * 1000;
        System.out.println(str + " random " + random);
        return () -> {
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return str;
        };

    }


    private static class TestAtomic {
        private volatile boolean done;


        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }

        public void flipDone (){
            this.done = !done;
        }
    }
}
