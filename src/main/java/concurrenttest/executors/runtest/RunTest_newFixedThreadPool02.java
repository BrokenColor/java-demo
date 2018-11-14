package concurrenttest.executors.runtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrenttest.executors.threaddemo.ThreadFactoryTest;

/**
 * 描述：创建一个线程池，重用固定数量的线程，从共享无界队列中运行，使用提供的ThreadFactory在需要时创建新线程。
 * newFixedThreadPool(2, factory)
 * 
 * @author BrokenColor
 * @date 2018年10月12日
 */
public class RunTest_newFixedThreadPool02 {

	public static void main(String[] args) {
		ThreadFactoryTest factory = new ThreadFactoryTest();
		// 创建一个线程池，重用固定数量的线程，从共享无界队列中运行，使用提供的ThreadFactory在需要时创建新线程。
		ExecutorService executorService = Executors.newFixedThreadPool(2, factory);

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("begin 运行" + System.currentTimeMillis() + " " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("end 运行" + System.currentTimeMillis() + " " + Thread.currentThread().getName());

			}
		};

		executorService.execute(runnable);
		executorService.execute(runnable);
		executorService.execute(runnable);

	}

}
