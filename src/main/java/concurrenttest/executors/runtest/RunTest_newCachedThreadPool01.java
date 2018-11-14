package concurrenttest.executors.runtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrenttest.executors.threaddemo.RunnableTest;

/**
 * 描述：newCachedThreadPool 线程复用
 * 
 * @author BrokenColor
 * @date 2018年10月11日
 */
public class RunTest_newCachedThreadPool01 {

	public static void main(String[] args) throws InterruptedException {
		// 创建一个根据需要创建新线程的线程池，但在可用时将重新使用以前构造的线程。
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new RunnableTest("" + (i + 1)));
		}
		Thread.sleep(5000);
		System.out.println("");
		System.out.println("");
		for (int i = 0; i < 5; i++) {
			executorService.execute(new RunnableTest("" + (i + 1)));
		}
	}

}
