package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest;

/**
 * 描述：ThreadPoolExecutor test awaitTermination
 * 阻止所有任务在关闭请求完成后执行，或发生超时，或当前线程中断，以先到者为准。
 * 判断指定时间内线程池是否已经终止工作
 * 
 * true：如果这个执行者终止了， false：如果在终止之前超时了
 * 
 * @author BrokenColor
 * @date 2018年10月19日
 */
public class RunTest_awaitTermination02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RunnableTest runnable = new RunnableTest();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 99, 99, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		pool.execute(runnable);
		pool.execute(runnable);
		pool.execute(runnable);
		pool.execute(runnable);
		pool.shutdown();
		//验证：任务完成，则取消阻塞继续执行后面的代码
		System.out.println(pool.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS)+ " "
				+ System.currentTimeMillis());
		System.out.println("全部完成");

	}

}
