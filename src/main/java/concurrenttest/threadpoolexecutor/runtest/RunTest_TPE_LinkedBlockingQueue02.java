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
public class RunTest_TPE_LinkedBlockingQueue02 {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableTest runnable = new RunnableTest();
		//初始化大小
		//队列容量不够，有一个任务出现异常
		LinkedBlockingQueue link = new LinkedBlockingQueue<Runnable>(2);
		System.out.println(link.size());
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, link);
		executor.execute(runnable);//1
		executor.execute(runnable);//2
		executor.execute(runnable);//3
		executor.execute(runnable);//4
		executor.execute(runnable);//5
		executor.execute(runnable);//6
		//3个任务放入队列中，2个正在执行的任务
		//有一个任务被拒绝
		Thread.sleep(1000);
		System.out.println(executor.getPoolSize()+" "+link.size());
	}

}
