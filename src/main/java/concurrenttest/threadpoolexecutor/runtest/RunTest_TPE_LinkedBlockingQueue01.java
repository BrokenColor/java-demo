package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest;

/**
 * 描述：LinkedBlockingQueue
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_LinkedBlockingQueue01 {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableTest runnable = new RunnableTest();
		//初始化大小
		LinkedBlockingQueue link = new LinkedBlockingQueue<>(2);
		System.out.println(link.size());
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, link);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		
		Thread.sleep(1000);
		System.out.println(executor.getPoolSize()+" "+link.size());
	}

}
