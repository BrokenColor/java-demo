package concurrenttest.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:CompletableFuture测试类
 * <p>
 * Author: GWL
 * Date: Create in 10:43 2020/7/24
 */
public class test {
    static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start..");

        //无返回值--默认线程池
//        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
//            System.out.println("run runAsync: " + Thread.currentThread().getName());
//        });
        //无返回值--使用自己定义的线程池
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("run runAsync: " + Thread.currentThread().getName());
        }, executor);
        //有返回值----默认线程池
//        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
//            System.out.println("run supplyAsync: " + Thread.currentThread().getName());
//            return "return supplyAsync";
//        });
        //有返回值----使用自己定义的线程池
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("run supplyAsync: " + Thread.currentThread().getName());
            return "return supplyAsync";
        }, executor);

        CompletableFuture<String> supplyAsync1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("run supplyAsync1: " + Thread.currentThread().getName());
            return "return supplyAsync1";
        }, executor).thenApply((res) -> {
            System.out.println("thenRunAsync:" + res);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "return thenApply";
        }).thenApplyAsync((res) -> {
            System.out.println("thenApplyAsync:" + res);
            return "return thenApplyAsync";
        });

//        supplyAsync.thenCombineAsync(supplyAsync1, null, executor);

        System.out.println("::" + supplyAsync1.get());

//        runAsync.thenCombineAsync();
        System.out.println("main end..");
    }
}
