package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest00;

/**
 * 描述：CallerRunsPolicy 一个被拒绝的任务的处理程序，直接在
 * execute方法的调用线程中运行被拒绝的任务，除非执行程序已被关闭，否则这个任务被丢弃。
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_Policy_CallerRunsPolicy {

	public static void main(String[] args) throws InterruptedException {

		RunnableTest00 runnable = new RunnableTest00();
		// 默认初始化大小2
		LinkedBlockingQueue link = new LinkedBlockingQueue<>(2);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, link,
				new ThreadPoolExecutor.CallerRunsPolicy());
		executor.execute(runnable);// 1
		executor.execute(runnable);// 2
		executor.execute(runnable);// 3
		executor.execute(runnable);// 4
		executor.execute(runnable);// 5
		executor.execute(runnable);// 6
		// 4个任务放入队列中，2个正在执行的任务
		Thread.sleep(1000);
		System.out.println(executor.getPoolSize() + " " + link.size());
	}

}
