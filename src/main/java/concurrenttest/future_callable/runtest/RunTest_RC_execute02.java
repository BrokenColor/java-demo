package concurrenttest.future_callable.runtest;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述：execute()方法通过使用自定义ThreadFactory也能捕获异常
 * 
 * @author BrokenColor
 * @date 2018年11月30日
 */
public class RunTest_RC_execute02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		pool.setThreadFactory(new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
					
					@Override
					public void uncaughtException(Thread t, Throwable e) {
						System.out.println("execute()方法通过使用自定义ThreadFactory也能捕获异常");
						e.getStackTrace();
					}
				});
				return t;
			}
		});
		pool.execute(new Runnable() {
			
			@Override
			public void run() {
				//直接抛出异常
				Integer.parseInt("a");
			}
		});
	}

}
