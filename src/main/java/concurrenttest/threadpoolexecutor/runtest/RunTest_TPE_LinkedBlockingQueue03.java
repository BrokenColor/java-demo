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
public class RunTest_TPE_LinkedBlockingQueue03 {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableTest runnable = new RunnableTest();
		//默认初始化大小Integer.MAX_VALUE
		LinkedBlockingQueue link = new LinkedBlockingQueue<Runnable>();
		System.out.println(link.size());
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, link);
		executor.execute(runnable);//1
		executor.execute(runnable);//2
		executor.execute(runnable);//3
		executor.execute(runnable);//4
		executor.execute(runnable);//5
		executor.execute(runnable);//6
		//4个任务放入队列中，2个正在执行的任务
		Thread.sleep(1000);
		System.out.println(executor.getPoolSize()+" "+link.size());
	}

}
