package concurrenttest.future_callable.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述：execute-runnable 直接抛出异常
 * 
 * @author BrokenColor
 * @date 2018年11月30日
 */
public class RunTest_RC_execute01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		pool.execute(new Runnable() {
			
			@Override
			public void run() {
				//直接抛出异常
				Integer.parseInt("a");
			}
		});
	}

}
