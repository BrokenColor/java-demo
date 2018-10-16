package concurrenttest.threadpoolexecutor.runtest;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest03;

/**
 * 描述：ThreadPoolExecutor类方法测试
 * 测试shutdownNow时，正在等待执行的任务是否执行
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunTest_ShutdownNow01 {

	public static void main(String[] args) throws InterruptedException {
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 99, 99L, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < 4; i++) {
			RunnableTest03 runnable = new RunnableTest03("A" + i);
			executor.execute(runnable);
		}
		Thread.sleep(100);
		//尝试停止所有主动执行的任务，停止等待任务的处理，并返回正在等待执行的任务列表。
		//如果Runnable中使用了if (Thread.currentThread().isInterrupted())，将中断所有的任务（包括正在执行和还未执行的任务）
		//如果Runnable中未使用，正在执行的任务将执行完，未执行的任务将不再执行
		List<Runnable> list = executor.shutdownNow();
		for (int i = 0; i < list.size(); i++) {
			RunnableTest03 threadTest = (RunnableTest03) list.get(i);
			System.out.println(threadTest.getName()+" 任务被取消");
		}
		System.out.println("main end");
	}

}
