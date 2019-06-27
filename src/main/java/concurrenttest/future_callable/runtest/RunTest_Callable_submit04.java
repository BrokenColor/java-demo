package concurrenttest.future_callable.runtest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.future_callable.callabledemo.Callable_Test;
import concurrenttest.future_callable.callabledemo.Runnable_Test;
import concurrenttest.future_callable.entity.Userinfo;

/**
 * 描述： 测试 submit()
 * future.cancel(true):尝试取消执行此任务。 
 * future.isCancelled() 如果此任务在正常完成之前被取消，则返回 true
 *
 * @author BrokenColor
 * @date 2018年11月21日
 */
public class RunTest_Callable_submit04 {

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
		try {
			//等待计算完成，然后检索其结果。(阻塞)
			System.out.println(future.get());
			//future.cancel(true):尝试取消执行此任务。 false如果任务无法取消，通常是因为它已经正常完成; true否则
			//future.isCancelled() 如果此任务在正常完成之前被取消，则返回 true
			System.out.println(future.cancel(true)+" "+future.isCancelled());
			System.out.println("end time "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("main end " + System.currentTimeMillis());
	}

}
