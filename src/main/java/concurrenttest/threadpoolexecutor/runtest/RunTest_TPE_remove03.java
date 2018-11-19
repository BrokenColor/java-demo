package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest00;

/**
 * 描述：如果此任务存在，则从执行程序的内部队列中删除此任务，从而导致该任务尚未运行。
 * remove(runnable)
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_remove03 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		RunnableTest00 runnable = new RunnableTest00();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 9999, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		//使用submit提交的任务无法删除
		pool.submit(runnable);
		pool.submit(runnable);
		Thread.sleep(10);
		pool.remove(runnable);
	}

}
