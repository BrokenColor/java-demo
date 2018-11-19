package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest00;

/**
 * 描述：线程池允许核心线程超时并终止 
 * allowCoreThreadTimeOut(true)
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_allowCoreThreadTimeOut {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableTest00 runnable = new RunnableTest00();
		/**
		 * 	corePoolSize - 即使空闲时仍保留在池中的线程数，除非设置 allowCoreThreadTimeOut
		 * 	maximumPoolSize - 池中允许的最大线程数
		 *	keepAliveTime - 当线程数大于核心时，这是多余的空闲线程在终止之前等待新任务的最大时间。
		 *	unit - keepAliveTime参数的时间单位
		 *	workQueue - 在执行任务之前用于保存任务的队列。 该队列将仅保存execute方法提交的Runnable任务。
		 */
		ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 5, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		//如果此池允许核心线程超时并终止，如果没有任务在keepAlive时间内到达，则返回true，如果新任务到达时需要更换。
//		System.out.println(executor.allowsCoreThreadTimeOut());
		executor.allowCoreThreadTimeOut(true);
		System.out.println(executor.allowsCoreThreadTimeOut());
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);	
		Thread.sleep(8000);
		System.out.println(executor.getCorePoolSize());
	}

}
