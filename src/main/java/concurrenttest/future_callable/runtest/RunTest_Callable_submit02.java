package concurrenttest.future_callable.runtest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 描述：Callable中submit()方法 测试
 *  submit()中也可以是Runnable
 *
 * @author BrokenColor
 * @date 2018年11月21日
 */
public class RunTest_Callable_submit02 {

    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("马克西姆-克罗地亚狂想曲");
            }
        };
        ExecutorService service = Executors.newCachedThreadPool();
        //runnable 没有返回值
        Future future = service.submit(runnable);
        try {
            System.out.println(future.get()+" "+future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main end " + System.currentTimeMillis());
    }

}
