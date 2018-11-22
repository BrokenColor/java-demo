package concurrenttest.future_callable.runtest;

import concurrenttest.future_callable.callabledemo.Callable_Test;

import java.util.concurrent.*;

/**
 * 描述：Callable中submit()方法 测试
 *
 * @author BrokenColor
 * @date 2018年11月21日
 */
public class RunTest_Callable_submit {

    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO Auto-generated method stub
        Callable_Test callable = new Callable_Test(18);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        Future<String> future = pool.submit(callable);
        System.out.println("main begin " + System.currentTimeMillis());
        System.out.println(future.get());
        System.out.println("main end " + System.currentTimeMillis());
    }

}
