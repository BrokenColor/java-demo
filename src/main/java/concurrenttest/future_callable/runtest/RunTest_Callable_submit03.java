package concurrenttest.future_callable.runtest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.future_callable.callabledemo.Runnable_Test;
import concurrenttest.future_callable.entity.Userinfo;

/**
 * 描述： 测试 submit(Runnable task, T result)
 *
 * @author BrokenColor
 * @date 2018年11月21日
 */
public class RunTest_Callable_submit03 {

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		Userinfo userinfo = new Userinfo();
		Runnable_Test runnable = new Runnable_Test(userinfo);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		// result the result to return
		Future<Userinfo> future = pool.submit(runnable, userinfo);
		System.out.println("begin time" + System.currentTimeMillis());
		try {
			userinfo = future.get();
			System.out.println("future.get():" + userinfo.getUsername()+" "+ userinfo.getPassword());
			System.out.println("end time "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("main end " + System.currentTimeMillis());
	}

}
