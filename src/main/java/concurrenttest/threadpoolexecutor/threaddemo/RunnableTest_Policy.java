package concurrenttest.threadpoolexecutor.threaddemo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述：线程
 * 
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunnableTest_Policy implements Runnable {

	@Override
	public void run() {
		RunnableTest00 runnable = new RunnableTest00();
		// 默认初始化大小2
		LinkedBlockingQueue link = new LinkedBlockingQueue<Runnable>(2);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, link,
				new ThreadPoolExecutor.CallerRunsPolicy());
		executor.execute(runnable);// 1
		executor.execute(runnable);// 2
		executor.execute(runnable);// 3
		executor.execute(runnable);// 4
		executor.execute(runnable);// 5
		executor.execute(runnable);// 6
	}

}
