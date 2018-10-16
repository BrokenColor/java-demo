package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest00;

/**
 * 描述：ThreadPoolExecutor类方法测试
 * isTerminated方法  如果所有任务在关闭后完成，则返回 true 。
 * isTerminating 判断线程是否正在关闭中，即如果此执行者在 shutdown()或 shutdownNow()之后 终止 ，但尚未完全终止，则返回true。
 * 
 * @author BrokenColor
 * @date 2018年10月16日
 */
public class RunTest_isTerminated {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		RunnableTest00 runnable = new RunnableTest00();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 999, 999, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		pool.execute(runnable);
		pool.execute(runnable);
		pool.execute(runnable);
		pool.execute(runnable);
		// isTerminating 判断线程是否正在关闭中，即如果此执行者在 shutdown()或 shutdownNow()之后 终止 ，但尚未完全终止，则返回true。
		// isTerminated:如果所有任务在关闭后完成，则返回 true 。
		System.out.println("pool.isTerminating:" + pool.isTerminating() + " pool.isTerminated:" + pool.isTerminated());
		pool.shutdown();
		Thread.sleep(1000);
		System.out.println("pool.isTerminating:" + pool.isTerminating() + " pool.isTerminated:" + pool.isTerminated());
		Thread.sleep(1000);
		System.out.println("pool.isTerminating:" + pool.isTerminating() + " pool.isTerminated:" + pool.isTerminated());
		Thread.sleep(1000);
		System.out.println("pool.isTerminating:" + pool.isTerminating() + " pool.isTerminated:" + pool.isTerminated());
		Thread.sleep(1000);
		System.out.println("pool.isTerminating:" + pool.isTerminating() + " pool.isTerminated:" + pool.isTerminated());
		Thread.sleep(1000);
		System.out.println("pool.isTerminating:" + pool.isTerminating() + " pool.isTerminated:" + pool.isTerminated());
	}

}
