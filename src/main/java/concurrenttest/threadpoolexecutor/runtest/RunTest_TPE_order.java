package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest04;

/**
 * 描述：ThreadPoolExecutor 
 * 接口Runnable在ThreadPoolExecutor的队列中是顺序取出的，执行确实乱序的
 * 
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunTest_TPE_order {

	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * 	corePoolSize - 即使空闲时仍保留在池中的线程数，除非设置 allowCoreThreadTimeOut
		 * 	maximumPoolSize - 池中允许的最大线程数
		 *	keepAliveTime - 当线程数大于核心时，这是多余的空闲线程在终止之前等待新任务的最大时间。
		 *	unit - keepAliveTime参数的时间单位
		 *	workQueue - 在执行任务之前用于保存任务的队列。 该队列将仅保存execute方法提交的Runnable任务。
		 *
		 */
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < 50; i++) {
			RunnableTest04 runnable = new RunnableTest04("userName:" + (i + 1));
			executor.execute(runnable);
		}
		
	}

}
