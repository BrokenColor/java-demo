package concurrenttest.semaphoredemo.serviceImp;

import concurrenttest.semaphoredemo.service.SemaphoreService;

import java.util.concurrent.Semaphore;

/**
 * Semaphore实现限制线程并发数
 * 没调用一次acquire()，就使用x个许可
 * @author bc
 * @data 2018年9月7日
 */
public class Semaphore_Acquire implements SemaphoreService {

	//类Semaphore的参数代表同一时间内，最多允许多少个线程执行
	private Semaphore semaphore = new Semaphore(10);
	
	public void testMethod() {
		try {
			semaphore.acquire(2);//参数表示每次调用1次此方法，就是用x个许可
			System.out.println(Thread.currentThread().getName()+" begin timer="+System.currentTimeMillis());
			int sleepValue = ((int)(Math.random() * 10000));
			System.out.println(Thread.currentThread().getName()+" 停止了"+(sleepValue / 1000) +"秒");
			Thread.sleep(sleepValue);
			System.out.println(Thread.currentThread().getName()+" end timer="+System.currentTimeMillis());
			semaphore.release(2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
