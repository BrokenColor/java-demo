package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threadFactorydemo.ThreadFactoryA;
import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest00;

/**
 * 描述：对线程池中的线程进行定制
 * 
 * @author BrokenColor
 * @date 2018年11月17日
 */
public class RunTest_ThreadPoolExecutor {

	public static void main(String[] args) {
		RunnableTest00 runnable = new RunnableTest00();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 999, 999, TimeUnit.SECONDS, 
				new LinkedBlockingQueue<>(), new ThreadFactoryA());
		
		//也可通过以下方式设置自定义的ThreadFactory
//		pool.setThreadFactory(new ThreadFactoryA());
		
		pool.execute(runnable);
	}

}
