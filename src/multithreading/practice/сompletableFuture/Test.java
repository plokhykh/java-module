package multithreading.practice.сompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args)  {
//        ThreadGroup threadGroup = new ThreadGroup("my thread group");
//        ExecutorService service = Executors.newFixedThreadPool(5);

//        List<Future<Integer>> futures = new ArrayList<>();
//
//
//        for (int i = 0; i < 20; i++) {
//            int index = i;
//            futures.add(service.submit(new Callable<Integer>() {
//                @Override
//                public Integer call() {
//                    System.out.println(Thread.currentThread().getName() + " " + index + " start");
//                    int random = new Random().nextInt(10);
//                    System.out.println(Thread.currentThread().getName() + " " + index + " stop");
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    if(random%2!=0){
//                        throw new RuntimeException("Number odd");
//                    }
//
//                    return random;
//                }
//            }));
//        }
//        service.shutdown();
//
//        List<Integer> integers = new ArrayList<>();
//        for (Future<Integer> future : futures) {
//            Integer value = null;
//            try {
//                 value = future.get();
//            } catch (InterruptedException | ExecutionException e) {
//               e.printStackTrace();
//            }
//
//            integers.add(value);
//        }
//
//        System.out.println("Result "+integers);
        final CompletableFuture<String> completable = CompletableFuture.completedFuture("string");
        System.out.println(completable.join());
        final CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "hello");

//        System.out.println(stringCompletableFuture.thenCompose((s) -> CompletableFuture.supplyAsync(() -> s + " world")).join());
        System.out.println(CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(()-> " World"), (s1, s2)-> s1+s2)
                .join());


        final CompletableFuture<String> stringCompletableFuture0 = CompletableFuture.supplyAsync(() -> getString(1));
        final CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(() -> getString(2));
        final CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(() -> getString(3));

//    CompletableFuture.allOf(stringCompletableFuture0, stringCompletableFuture1, stringCompletableFuture2).get();
//        System.out.println(stringCompletableFuture1.get());
//        System.out.println(stringCompletableFuture2.get());

        List<CompletableFuture<String>> completableFutures = new ArrayList<>();
        List<String> list = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            int index = i;
            completableFutures.add(
                    CompletableFuture
                            .supplyAsync(() -> getString(index))
                            .exceptionally((ex) -> "-1")
                            .thenApplyAsync(Test::modifyString));

        }

        for (CompletableFuture<String> completableFuture : completableFutures) {
            list.add(completableFuture.join());
        }
        System.out.println(list);

    }

    private static String getString(int i) {
//        int random = new Random().nextInt(2);
//        if (random == 1) {
//            throw new RuntimeException("error");
//        }
//        System.out.println(Thread.currentThread().getName() + " start");
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(Thread.currentThread().getName() + " stop");
//        return "hello " + i;
        if(true){
            throw new RuntimeException("new exception");
        }
        return "1";
    }

    ;

    private static String modifyString(String str) {
        System.out.println(Thread.currentThread().getName() + " start");
        String string = "hello " + str;
        System.out.println(Thread.currentThread().getName() + " stop");

        return string;
    }
}
