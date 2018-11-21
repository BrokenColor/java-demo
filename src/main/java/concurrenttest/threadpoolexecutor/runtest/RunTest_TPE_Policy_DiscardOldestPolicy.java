package concurrenttest.threadpoolexecutor.runtest;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest04;

/**
 * 描述：DiscardOldestPolicy
 * 被拒绝的任务的处理程序，丢弃最旧的未处理请求，然后重试 execute ，除非执行程序被关闭，在这种情况下，任务被丢弃。
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_Policy_DiscardOldestPolicy {

	public static void main(String[] args) throws InterruptedException {
		
		ArrayBlockingQueue queue = new ArrayBlockingQueue<Runnable>(2);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, queue, new ThreadPoolExecutor.DiscardOldestPolicy());
		for (int i = 0; i < 5; i++) {
			RunnableTest04 runnable = new RunnableTest04("eason:"+(i+1));
			pool.execute(runnable);
		}
		Thread.sleep(50);
		Iterator iterator = queue.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			System.out.println(((RunnableTest04) object).getUsername());
		}
		pool.execute(new RunnableTest04("eason:6"));
		pool.execute(new RunnableTest04("eason:7"));
		iterator = queue.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			System.out.println(((RunnableTest04)object).getUsername());
		}
	}

}
