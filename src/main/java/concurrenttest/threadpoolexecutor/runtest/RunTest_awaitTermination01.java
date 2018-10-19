package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest;

/**
 * 描述：ThreadPoolExecutor test awaitTermination
 * 阻止所有任务在关闭请求完成后执行，或发生超时，或当前线程中断，以先到者为准。
 * 判断指定时间内线程池是否已经终止工作
 * 
 * true：如果这个执行者终止了， false：如果在终止之前超时了
 * 
 * @author BrokenColor
 * @date 2018年10月19日
 */
public class RunTest_awaitTermination01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RunnableTest runnable = new RunnableTest();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 99, 99, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		pool.execute(runnable);
		pool.execute(runnable);
		pool.execute(runnable);
		pool.execute(runnable);
		pool.shutdown();
		//验证：如果池中有任务在被执行，则出现阻塞，等待指定时间，如果没有任务则不阻塞
		System.out.println("A=" +pool.awaitTermination(1, TimeUnit.SECONDS)+ " "+ System.currentTimeMillis());
		System.out.println("B=" +pool.awaitTermination(1, TimeUnit.SECONDS)+ " "+ System.currentTimeMillis());
		System.out.println("C=" +pool.awaitTermination(1, TimeUnit.SECONDS)+ " "+ System.currentTimeMillis());
		System.out.println("D=" +pool.awaitTermination(1, TimeUnit.SECONDS)+ " "+ System.currentTimeMillis());
		System.out.println("E=" +pool.awaitTermination(1, TimeUnit.SECONDS)+ " "+ System.currentTimeMillis());
		System.out.println("F=" +pool.awaitTermination(1, TimeUnit.SECONDS)+ " "+ System.currentTimeMillis());
		System.out.println("G=" +pool.awaitTermination(1, TimeUnit.SECONDS)+ " "+ System.currentTimeMillis());

	}

}
