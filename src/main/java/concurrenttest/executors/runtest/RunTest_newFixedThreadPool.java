package concurrenttest.executors.runtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrenttest.executors.threaddemo.RunnableTest;

/**
 * 描述：
 * 
 * @author BrokenColor
 * @date 2018年10月12日
 */
public class RunTest_newFixedThreadPool {

	public static void main(String[] args) {
		// 创建一个线程池，该线程池重用固定数量的从共享无界队列中运行的线程
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			executorService.execute(new RunnableTest(" " + (i + 1)));
		}

		for (int j = 0; j < 3; j++) {
			executorService.execute(new RunnableTest(" " + (j + 1)));
		}
	}

}
