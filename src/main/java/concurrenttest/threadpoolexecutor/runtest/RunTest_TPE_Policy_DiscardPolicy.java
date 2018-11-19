package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest;

/**
 * 描述：DiscardPolicy 被拒绝的任务的处理程序静默地丢弃被拒绝的任务。
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_Policy_DiscardPolicy {

	public static void main(String[] args) throws InterruptedException {

		RunnableTest runnable = new RunnableTest();
		// 默认初始化大小2
		LinkedBlockingQueue link = new LinkedBlockingQueue<>(2);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, link,
				new ThreadPoolExecutor.DiscardPolicy());
		executor.execute(runnable);// 1
		executor.execute(runnable);// 2
		executor.execute(runnable);// 3
		executor.execute(runnable);// 4
		executor.execute(runnable);// 5
		executor.execute(runnable);// 6
		executor.execute(runnable);// 7
		executor.execute(runnable);// 8
		// 多余的任务被丢弃
		Thread.sleep(10000);
		System.out.println(executor.getPoolSize() + " " + link.size());
	}

}
