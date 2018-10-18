package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest;

/**
 * 描述：ThreadPoolExecutor 构造方法test
 * 队列使用得了LinkedBlockingQueue类
 * 线程数<=corePoolSize
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunTest_Constructor {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableTest runnable = new RunnableTest();
		/**
		 * 	corePoolSize - 即使空闲时仍保留在池中的线程数，除非设置 allowCoreThreadTimeOut
		 * 	maximumPoolSize - 池中允许的最大线程数
		 *	keepAliveTime - 当线程数大于核心时，这是多余的空闲线程在终止之前等待新任务的最大时间。
		 *	unit - keepAliveTime参数的时间单位
		 *	workQueue - 在执行任务之前用于保存任务的队列。 该队列将仅保存execute方法提交的Runnable任务。
		 *
		 */
		//----LinkedBlockingQueue----
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		//线程数<=corePoolSize
		for (int i = 0; i < 7; i++) {
			executor.execute(runnable);
		}
		Thread.sleep(1000);
		System.out.println("A.CorePoolSize:"+executor.getCorePoolSize());
		System.out.println("A.PoolSize:"+executor.getPoolSize());
		System.out.println("A.Queue.size:"+executor.getQueue().size());
		Thread.sleep(3000);
		System.out.println("B.CorePoolSize:"+executor.getCorePoolSize());
		System.out.println("B.PoolSize:"+executor.getPoolSize());
		System.out.println("B.Queue.size:"+executor.getQueue().size());
		
	}

}
