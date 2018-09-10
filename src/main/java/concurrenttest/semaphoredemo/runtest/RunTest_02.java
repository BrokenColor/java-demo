package concurrenttest.semaphoredemo.runtest;

import java.util.concurrent.Semaphore;

/**
 * Semaphore实现限制线程并发数
 * 多次得调用release() 可以动态的添加permits的个数
 * @author bc
 * @data 2018年9月10日
 */
public class RunTest_02 {

	public static void main(String[] args) {
		try {
			//类Semaphore的参数代表同一时间内，最多允许多少个线程执行--初始化状态值
			Semaphore semaphore = new Semaphore(5);
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			System.out.println(semaphore.availablePermits());
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			System.out.println(semaphore.availablePermits());
			semaphore.release(4);
			System.out.println(semaphore.availablePermits());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
