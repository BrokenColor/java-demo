package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest00;

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
public class RunTest_awaitTermination {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RunnableTest00 runnable = new RunnableTest00();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		pool.execute(runnable);
		pool.shutdown();
		System.out.println("main begin:" + System.currentTimeMillis());
		// 如果池中有任务在被执行，则出现阻塞，等待指定时间，如果没有任务则不阻塞
		System.out.println(pool.awaitTermination(10, TimeUnit.SECONDS));
		System.out.println("main end:" + System.currentTimeMillis());
	}

}
