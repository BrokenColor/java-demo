package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threadFactorydemo.ThreadFactoryB;
import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest2;

/**
 * 描述：对线程池中的线程进行定制
 * setThreadFactory()
 * @author BrokenColor
 * @date 2018年11月17日
 */
public class RunTest_ThreadPoolExecutor02 {

	public static void main(String[] args) {
		RunnableTest2 runnable = new RunnableTest2();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 999, 999, TimeUnit.SECONDS, 
				new LinkedBlockingQueue<Runnable>());
		
		//也可通过以下方式设置自定义的ThreadFactory
		pool.setThreadFactory(new ThreadFactoryB());
		
		pool.execute(runnable);
	}

}
