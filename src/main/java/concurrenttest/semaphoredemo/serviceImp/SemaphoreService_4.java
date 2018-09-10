package concurrenttest.semaphoredemo.serviceImp;

import concurrenttest.semaphoredemo.service.SemaphoreService;

import java.util.concurrent.Semaphore;

/**
 * getQueueLength() 取得等待许可线程个数
 * hasQueuedThreads() 是否有线程在等待这个许可
 *
 * @author bc
 * @data 2018年9月9日
 */
public class SemaphoreService_4 implements SemaphoreService {

	//类Semaphore的参数代表同一时间内，最多允许多少个线程执行
	private Semaphore semaphore = new Semaphore(1);
	
	public void testMethod() {
		try {
			semaphore.acquire();//参数表示每次调用1次此方法，就是用x个许可
			Thread.sleep(1000);
			System.out.println("还有大约"+semaphore.getQueueLength()+"线程在等待");
			System.out.println("是否有线程在等待信号量:"+semaphore.hasQueuedThreads());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}
}
