package concurrenttest.semaphoredemo.serviceImp;

import concurrenttest.semaphoredemo.service.SemaphoreService;

import java.util.concurrent.Semaphore;

/**
 * drainPermits() 返回可用的许可，并将可用许可数清零
 * @author bc
 * @data 2018年9月9日
 */
public class Semaphore_DrainPermits implements SemaphoreService {

	//类Semaphore的参数代表同一时间内，最多允许多少个线程执行
	private Semaphore semaphore = new Semaphore(10);
	
	public void testMethod() {
		try {
			semaphore.acquire();//参数表示每次调用1次此方法，就是用x个许可
			System.out.println(semaphore.availablePermits());
			System.out.println(semaphore.drainPermits()+"--"+semaphore.availablePermits());
			System.out.println(semaphore.drainPermits()+"--"+semaphore.availablePermits());
			System.out.println(semaphore.drainPermits()+"--"+semaphore.availablePermits());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}
}
