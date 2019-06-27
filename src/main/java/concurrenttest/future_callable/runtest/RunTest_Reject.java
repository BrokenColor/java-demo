package concurrenttest.future_callable.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.future_callable.callabledemo.Runnable_Test01;
import concurrenttest.future_callable.executionHandler.RejectedExecutionHandlerDemo;

/**
 * 描述：自定义拒绝策略
 * 
 * @author BrokenColor
 * @date 2018年11月26日
 */
public class RunTest_Reject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 4, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		//添加自定义拒绝策略
		pool.setRejectedExecutionHandler(new RejectedExecutionHandlerDemo());
		pool.submit(new Runnable_Test01("A"));
		pool.submit(new Runnable_Test01("B"));
		pool.submit(new Runnable_Test01("C"));
		pool.shutdown();
		pool.submit(new Runnable_Test01("D"));
	}

}
