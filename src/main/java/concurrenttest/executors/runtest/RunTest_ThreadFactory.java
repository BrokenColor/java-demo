package concurrenttest.executors.runtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrenttest.executors.threaddemo.ThreadFactoryTest;

/**
 * 描述：通过 newCachedThreadPool(ThreadFactory) 定制线程工厂
 * 
 * @author BrokenColor
 * @date 2018年10月12日
 */
public class RunTest_ThreadFactory {

	public static void main(String[] args) {
		ThreadFactoryTest factory = new ThreadFactoryTest();
		//创建一个根据需要创建新线程的线程池，但在可用时将重新使用以前构造的线程，并在需要时使用提供的ThreadFactory创建新线程。
		ExecutorService executorService = Executors.newCachedThreadPool(factory);
		executorService.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("开始：" + System.currentTimeMillis() + " " + Thread.currentThread().getName());

			}
		});
	}

}
