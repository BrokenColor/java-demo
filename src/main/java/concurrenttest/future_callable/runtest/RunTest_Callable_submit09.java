package concurrenttest.future_callable.runtest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.future_callable.callabledemo.Callable_Test04;

/**
 * 描述：测试 submit()
 * 异常的处理	
 * 
 * @author BrokenColor
 * @date 2018年11月26日
 */
public class RunTest_Callable_submit09 {

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		Callable_Test04 callable = new Callable_Test04(100);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		//
		Future<String> future = pool.submit(callable);
		System.out.println("begin time" + System.currentTimeMillis());
		// 等待计算完成，然后检索其结果。(阻塞)
		try {
			// 如果Callable_Test04出现异常，则进入catch中，不再继续执行future.get()方法
			System.out.println("返回值：" + future.get());
			System.out.println("end ");
		} catch (InterruptedException e) {
			System.out.println("报错：InterruptedException");
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("报错：ExecutionException");
			e.printStackTrace();
		}
		System.out.println("end time " + System.currentTimeMillis());
	}

}
