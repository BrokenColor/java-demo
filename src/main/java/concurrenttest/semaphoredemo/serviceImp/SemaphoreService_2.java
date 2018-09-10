package concurrenttest.semaphoredemo.serviceImp;

import concurrenttest.semaphoredemo.service.SemaphoreService;

import java.util.concurrent.Semaphore;

/**
 * acquireUninterruptibly() 在等待进入acquire()方法的线程 不允许被中断
 * @author bc
 * @data 2018年9月7日
 */
public class SemaphoreService_2 implements SemaphoreService {

	//类Semaphore的参数代表同一时间内，最多允许多少个线程执行
	private Semaphore semaphore = new Semaphore(1);
	
	public void testMethod() {
		try {
//			semaphore.acquire();//参数表示每次调用1次此方法，就是用x个许可
			semaphore.acquireUninterruptibly();//在等待许可的情况下不允许中断
			System.out.println(Thread.currentThread().getName()+" begin timer="+System.currentTimeMillis());
			for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
				String newString = new String();
				Math.random();
			}
			System.out.println(Thread.currentThread().getName()+" end timer="+System.currentTimeMillis());
			semaphore.release();
		} catch (Exception e) {
			System.out.println("线程"+Thread.currentThread().getName()+"进入catch");
			e.printStackTrace();
		}
	}
}
