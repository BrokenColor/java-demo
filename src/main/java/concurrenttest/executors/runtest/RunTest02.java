package concurrenttest.executors.runtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors类测试
 * newCachedThreadPool() 创建一个根据需要创建新线程的线程池，但在可用时将重新使用以前构造的线程。
 * @author BrokenColor
 * @date 2018年10月9日
 */
public class RunTest02 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+" run! ");
				}
			});
		}
	}

}
