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
public class RunTest_Shutdown01 {

	public static void main(String[] args) throws InterruptedException {
		RunnableTest00 runnable = new RunnableTest00();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 99, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < 4; i++) {
			executor.execute(runnable);
		}
		Thread.sleep(1000);
		//启动有序关闭，其中先前提交的任务将被执行，但不会接受任何新任务。
		executor.shutdown();
		//因为执行了shutdown方法，当前程序被销毁
		executor.execute(runnable);
		System.out.println("main end");
	}

}
