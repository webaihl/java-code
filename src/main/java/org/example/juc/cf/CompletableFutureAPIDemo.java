package org.example.juc.cf;

import java.util.concurrent.*;

/**
 * @auther zzyy
 * @create 2021-03-02 17:54
 */
public class CompletableFutureAPIDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException
    {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        System.out.println(CompletableFuture.supplyAsync(() -> 1).thenApply(f -> f + 2).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("0-------result: " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        }).join());




        threadPoolExecutor.shutdown();
    }

    /**
     * thenCombine
     */
    public static void m5()
    {
        System.out.println(CompletableFuture.supplyAsync(() -> 10).thenCombine(CompletableFuture.supplyAsync(() -> 20), Integer::sum).join());
    }

    /**
     * 对计算速度进行选用
     */
    public static void m4()
    {
        System.out.println(CompletableFuture.supplyAsync(() -> {
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        }), r -> r).join());

        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    /**
     * 对计算结果进行消费
     */
    public static void m3()
    {
        CompletableFuture.supplyAsync(() -> 1).thenApply(f -> f+2).thenApply(f -> f+3).thenAccept(System.out::println);


        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenRun(() -> {}).join());


        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenAccept(resultA -> {}).join());


        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenApply(resultA -> resultA + " resultB").join());
    }

    /**
     * 对计算结果进行处理
     */
    public static void m2()
    {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        System.out.println(CompletableFuture.supplyAsync(() -> 1).handle((f, e) -> {
            System.out.println("-----1");
            return f + 2;
        }).handle((f,e) -> {
            System.out.println("-----2");
            return f + 3;
        }).handle((f,e) -> {
            System.out.println("-----3");
            return f + 4;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("----result: " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        }).join());


        threadPoolExecutor.shutdown();
    }

    /**
     * 获得结果和触发计算
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void m1() throws InterruptedException, ExecutionException
    {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            //暂停几秒钟线程
            //暂停几秒钟线程
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            return 1;
        },threadPoolExecutor);

        //System.out.println(future.get());
        //System.out.println(future.get(2L,TimeUnit.SECONDS));
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        //System.out.println(future.getNow(9999));

        System.out.println(future.complete(-44)+"\t"+future.get());


        threadPoolExecutor.shutdown();
    }
}
