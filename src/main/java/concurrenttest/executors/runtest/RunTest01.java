package concurrenttest.executors.runtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors类测试
 * newCachedThreadPool() 创建一个根据需要创建新线程的线程池，但在可用时将重新使用以前构造的线程。
 * @author BrokenColor
 * @date 2018年10月9日
 */
public class RunTest01 {

	public static void main(String[] args) {
		//创建一个根据需要创建新线程的线程池，但在可用时将重新使用以前构造的线程。
		ExecutorService executorService = Executors.newCachedThreadPool();
		//在将来的某个时间执行给定的命令。 该命令可以在一个新线程，一个合并的线程中或在调用线程中执行，由Executor实现。
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("Runable1 begin "+System.currentTimeMillis());
					Thread.sleep(1000);
					System.out.println("A");
					System.out.println("Runnable end "+System.currentTimeMillis());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});

		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("Runable2 begin "+System.currentTimeMillis());
					Thread.sleep(1000);
					System.out.println("B");
					System.out.println("Runnable2 end "+System.currentTimeMillis());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		
	}

}
