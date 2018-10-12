package concurrenttest.executors.runtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrenttest.executors.threaddemo.RunnableTest;

/**
 * 描述：newCachedThreadPool
 * @author BrokenColor
 * @date 2018年10月11日
 */
public class RunTest_newCachedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			executorService.execute(new RunnableTest(""+(i+1)));
		}
	}

}
