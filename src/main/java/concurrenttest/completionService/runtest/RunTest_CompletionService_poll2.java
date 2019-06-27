package concurrenttest.completionService.runtest;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 描述：CompletionService.poll(long timeout, TimeUnit unit)
 * 检索并删除表示下一个完成的任务的未来，如果还没有，则等待必要时直到指定的等待时间。
 * 不阻塞
 * 
 * @author BrokenColor
 * @date 2018年12月1日
 */
public class RunTest_CompletionService_poll2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletionService completionService = new ExecutorCompletionService<>(executorService);
		for (int i = 0; i < 10; i++) {
			completionService.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					long sleepValue = (int) (Math.random() * 10000);
					System.out.println("sleep=" + sleepValue + " " + Thread.currentThread().getName());
					Thread.sleep(sleepValue);
					return "angel:" + sleepValue + " " + Thread.currentThread().getName();
				}
			});
		}
		try {
			for (int i = 0; i < 10; i++) {
				//检索并删除表示下一个完成的任务的未来，如果还没有，则等待必要时直到指定的等待时间。
				//timeout的时间如果小于任务执行的时间，则就会返回null
				System.out.println(completionService.poll(1,TimeUnit.SECONDS));
			}
			System.out.println("main end");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
