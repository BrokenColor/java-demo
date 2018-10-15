package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest00;

/**
 * 描述：ThreadPoolExecutor类方法测试
 * shutdown
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunTest_Shutdown {

	public static void main(String[] args) {
		RunnableTest00 runnable = new RunnableTest00();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		executor.execute(runnable);
		executor.shutdown();
		System.out.println("main end");
	}

}
