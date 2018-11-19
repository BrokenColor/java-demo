package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest;

/**
 * 描述：ThreadPoolExecutor getXXX方法测试
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunTest_TPE_getXXX {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableTest runnable = new RunnableTest();
		/**
		 * 	corePoolSize - 即使空闲时仍保留在池中的线程数，除非设置 allowCoreThreadTimeOut
		 * 	maximumPoolSize - 池中允许的最大线程数
		 *	keepAliveTime - 当线程数大于核心时，这是多余的空闲线程在终止之前等待新任务的最大时间。
		 *	unit - keepAliveTime参数的时间单位
		 *	workQueue - 在执行任务之前用于保存任务的队列。 该队列将仅保存execute方法提交的Runnable任务。
		 */
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 9, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		//线程数>maximumPoolSize
		for (int i = 0; i < 9; i++) {
			executor.execute(runnable);
		}
		Thread.sleep(100);
		//executor.getCorePoolSize() 返回核心线程数。
		System.out.println("A.CorePoolSize:"+executor.getCorePoolSize());
		//executor.getPoolSize() 返回池中当前的线程数。
		System.out.println("A.PoolSize:"+executor.getPoolSize());
		//executor.getQueue() 返回此执行程序使用的任务队列。
		System.out.println("A.Queue.size:"+executor.getQueue().size());
		//executor.getActiveCount() 返回正在执行任务的线程的大概数量。
		System.out.println("A.getActiveCount:"+executor.getActiveCount());
		//executor.getCompletedTaskCount() 返回完成执行的任务的大致总数。
		System.out.println("A.getCompletedTaskCount:"+executor.getCompletedTaskCount());
		//executor.getLargestPoolSize() 返回在池中同时进行的最大线程数。
		System.out.println("A.getLargestPoolSize:"+executor.getLargestPoolSize());
		//executor.getMaximumPoolSize() 返回允许的最大线程数。
		System.out.println("A.getMaximumPoolSize:"+executor.getMaximumPoolSize());
		//executor.getTaskCount() 返回计划执行的任务的总数。
		System.out.println("A.getTaskCount:"+executor.getTaskCount());
	}

}
