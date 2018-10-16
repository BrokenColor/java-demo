package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest00;

/**
 * 描述：ThreadPoolExecutor类方法测试
 * isShutdown方法 判断线程池是否关闭
 * 
 * @author BrokenColor
 * @date 2018年10月16日
 */
public class RunTest_isShutdown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunnableTest00 runnable = new RunnableTest00();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		pool.execute(runnable);
		//如果此执行者已关闭，则返回 true 。
		System.out.println("A="+pool.isShutdown());
		pool.shutdown();
		System.out.println("B="+pool.isShutdown());
	}

}
