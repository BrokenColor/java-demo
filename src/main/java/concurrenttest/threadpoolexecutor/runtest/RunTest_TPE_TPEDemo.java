package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest04;
import concurrenttest.threadpoolexecutor.threadpoolexecutordemo.ThreadPoolExecutorDemo;

/**
 * 描述：自定义ThreadPoolExecutor类
 * beforeExecute 在给定的线程中执行给定的Runnable之前调用方法。
 * afterExecute 完成指定Runnable的执行后调用方法。
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_TPEDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolExecutorDemo pool = new ThreadPoolExecutorDemo(2, 2, 999, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		pool.execute(new RunnableTest04("EASON1"));
		pool.execute(new RunnableTest04("EASON2"));
		pool.execute(new RunnableTest04("EASON3"));
		pool.execute(new RunnableTest04("EASON4"));
	}

}
