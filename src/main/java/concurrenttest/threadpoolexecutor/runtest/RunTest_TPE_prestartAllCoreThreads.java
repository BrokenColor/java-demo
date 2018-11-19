package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest00;

/**
 * 描述：启动核心线程，使其无法等待工作。 prestartCoreThread()
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_prestartAllCoreThreads {

	public static void main(String[] args) throws InterruptedException {

		RunnableTest00 runnable = new RunnableTest00();
		/**
		 * corePoolSize - 即使空闲时仍保留在池中的线程数，除非设置 allowCoreThreadTimeOut maximumPoolSize -
		 * 池中允许的最大线程数 keepAliveTime - 当线程数大于核心时，这是多余的空闲线程在终止之前等待新任务的最大时间。 unit -
		 * keepAliveTime参数的时间单位 workQueue - 在执行任务之前用于保存任务的队列。
		 * 该队列将仅保存execute方法提交的Runnable任务。
		 */
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		System.out.println("线程池中的A数：" + executor.getPoolSize());
		// 启动一个核心线程
		System.out.println("A1:" + executor.prestartCoreThread());
		System.out.println("线程池中的B数：" + executor.getPoolSize());
		System.out.println("B1:" + executor.prestartCoreThread());
		System.out.println("线程池中的C数：" + executor.getPoolSize());
		System.out.println("C1:" + executor.prestartCoreThread());
		System.out.println("C2:" + executor.prestartCoreThread());
		System.out.println("C3:" + executor.prestartCoreThread());
		System.out.println("C4:" + executor.prestartCoreThread());
		System.out.println("线程池中的D数：" + executor.getPoolSize());
	}

}
