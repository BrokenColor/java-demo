package concurrenttest.future_callable.runtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述：execute与submit比较之有无返回值
 * 
 * @author BrokenColor
 * @date 2018年11月30日
 */
public class RunTest_execute_submit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		pool.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("execute,执行了，但是没有返回值！");
				
			}
		});
		Future<String> future = pool.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("submit,执行了，有返回值！");
				return "我是返回值";
			}
			
		});
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
