package concurrenttest.threadpoolexecutor.threadpoolexecutordemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest04;

/**
 * 描述：自定义ThreadPoolExecutor类
 * beforeExecute
 * afterExecute
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class ThreadPoolExecutorDemo extends ThreadPoolExecutor {

	/**
	 * @param corePoolSize
	 * @param maximumPoolSize
	 * @param keepAliveTime
	 * @param unit
	 * @param workQueue
	 */
	public ThreadPoolExecutorDemo(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
		System.out.println(((RunnableTest04) r).getUsername() + "：准备执行");
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		System.out.println(((RunnableTest04) r).getUsername() + "：执行完了");
	}

}
