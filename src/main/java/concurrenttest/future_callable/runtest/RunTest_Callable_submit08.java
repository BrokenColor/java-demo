package concurrenttest.future_callable.runtest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import concurrenttest.future_callable.callabledemo.Callable_Test;


/**
 * 描述：测试 submit() 
 * 
 * @author BrokenColor
 * @date 2018年11月26日
 */
public class RunTest_Callable_submit08 {

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		Callable_Test callable = new Callable_Test(100);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		//
		Future<String> future = pool.submit(callable);
		System.out.println("begin time" + System.currentTimeMillis());
		// 等待计算完成，然后检索其结果。(阻塞)
		 try {
			System.out.println("返回值："+future.get(5,TimeUnit.SECONDS));
			System.out.println("end ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end time " + System.currentTimeMillis());
	}

}
