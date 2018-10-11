package concurrenttest.executors.runtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrenttest.executors.runnable.RunnableTest;

/**
 * 描述：newCachedThreadPool
 * 线程复用
 * @author BrokenColor
 * @date 2018年10月11日
 */
public class RunTest_newCachedThreadPool01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new RunnableTest(""+(i+1)));
		}
		Thread.sleep(5000);
		System.out.println("");
		System.out.println("");
		for (int i = 0; i < 5; i++) {
			executorService.execute(new RunnableTest(""+(i+1)));
		}
	}

}
