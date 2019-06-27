package concurrenttest.completionService.runtest;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述：CompletionServiced的poll的方法测试
 * 检索并移除未来表示下一个已完成的任务，如果不存在,则返回 null 。
 * 不阻塞
 * 
 * @author BrokenColor
 * @date 2018年12月1日
 */
public class RunTest_CompletionService_poll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
		for (int i = 0; i < 10; i++) {
			completionService.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					long sleepValue = (int) (Math.random() * 1000);
					System.out.println("sleep=" + sleepValue + " " + Thread.currentThread().getName());
					Thread.sleep(sleepValue);
					return "angel:" + sleepValue + " " + Thread.currentThread().getName();
				}
			});
		}
		try {
			for (int i = 0; i < 10; i++) {
				//检索并移除未来表示下一个已完成的任务，如果不存在,则返回 null 。
				System.out.println(completionService.poll());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
