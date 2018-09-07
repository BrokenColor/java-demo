package concurrenttest.semaphoredemo;

import java.util.concurrent.Semaphore;

/**
 * Semaphore实现限制线程并发数
 * @author bc
 * @data 2018年9月7日
 */
public class SemaphoreService {
	//类Semaphore的参数代表同一时间内，最多允许多少个线程执行
	private Semaphore semaphore = new Semaphore(1);
	
	public void testMethod() {
		try {
			semaphore.acquire();//无参表示使用1个许可
			System.out.println(Thread.currentThread().getName()+" begin timer="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName()+" end timer+"+System.currentTimeMillis());
			semaphore.release();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
