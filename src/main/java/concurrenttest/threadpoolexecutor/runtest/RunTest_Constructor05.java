package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest;

/**
 * 描述：ThreadPoolExecutor 构造方法test
 * 队列使用得了SynchronousQueue类  	
 * 线程数>maximumPoolSize
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunTest_Constructor05 {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableTest runnable = new RunnableTest();
		/**
		 * 	corePoolSize - 即使空闲时仍保留在池中的线程数，除非设置 allowCoreThreadTimeOut
		 * 	maximumPoolSize - 池中允许的最大线程数
		 *	keepAliveTime - 当线程数大于核心时，这是多余的空闲线程在终止之前等待新任务的最大时间。
		 *	unit - keepAliveTime参数的时间单位
		 *	workQueue - 在执行任务之前用于保存任务的队列。 该队列将仅保存execute方法提交的Runnable任务。
		 *------------------------------------------------------------------
		 *	队列使用得了SynchronousQueue类  
		 *	线程数（9）>maximumPoolSize（8）,处理maximumPoolSize任务，其他的任务不再处理抛出异常
		 *	如果使用了SynchronousQueue类  则maximumPoolSize参数的作用有效
		 */
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		//线程数>maximumPoolSize
		for (int i = 0; i < 9; i++) {
			executor.execute(runnable);
		}
		Thread.sleep(100);
		System.out.println("A.CorePoolSize:"+executor.getCorePoolSize());
		System.out.println("A.PoolSize:"+executor.getPoolSize());
		System.out.println("A.Queue.size:"+executor.getQueue().size());
		Thread.sleep(10000);
		System.out.println("B.CorePoolSize:"+executor.getCorePoolSize());
		System.out.println("B.PoolSize:"+executor.getPoolSize());
		System.out.println("B.Queue.size:"+executor.getQueue().size());
	}

}
