package concurrenttest.future_callable.runtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述：submit可以直接捕获异常
 * 
 * @author BrokenColor
 * @date 2018年11月30日
 */
public class RunTest_RC_submit01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		Future<String> future = pool.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("submit,执行了，有返回值！");
				Integer.parseInt("a");
				return "我是返回值";
			}
			
		});
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("异常捕获");
			e.printStackTrace();
		}
	}

}
