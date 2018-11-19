package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.exceptiondemo.RejectedExecutionHandlerDemo;
import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest04;

/**
 * 描述：设置自定义异常处理 
 * setRejectedExecutionHandler
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_ThreadPoolExecutor03 {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableTest04 runnable1 = new RunnableTest04("中国1");
		RunnableTest04 runnable2 = new RunnableTest04("中国2");
		RunnableTest04 runnable3 = new RunnableTest04("中国3");
		RunnableTest04 runnable4 = new RunnableTest04("中国4");
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
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		//设置自定义异常  （被拒绝任务日志化）
		executor.setRejectedExecutionHandler(new RejectedExecutionHandlerDemo());
		//线程数>maximumPoolSize
		executor.execute(runnable1);
		executor.execute(runnable2);
		executor.execute(runnable3);
		executor.execute(runnable4);	
	}

}
