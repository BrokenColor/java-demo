package concurrenttest.executors.runtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrenttest.executors.threaddemo.RunnableTest;
import concurrenttest.executors.threaddemo.ThreadFactoryTest;

/**
 * 描述：	newSingleThreadExecutor
 * 创建一个使用从无界队列运行的单个工作线程的执行程序。
 * @author BrokenColor
 * @date 2018年10月12日
 */
public class RunTest_newSingleThreadExecutor {

	public static void main(String[] args) {
		ThreadFactoryTest factory = new ThreadFactoryTest();
		//创建一个使用从无界队列运行的单个工作线程的执行程序。
		ExecutorService executorService = Executors.newSingleThreadExecutor(factory);
		for (int i = 0; i < 3; i++) {
			executorService.execute(new RunnableTest(""+(i+1)));
		}

	}

}
