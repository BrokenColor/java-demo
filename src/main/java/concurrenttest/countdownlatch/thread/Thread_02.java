/**
 * 
 */
package concurrenttest.countdownlatch.thread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 类测试
 * @author bc
 * @data 2018年9月20日
 */
public class Thread_02 extends Thread{

	private CountDownLatch maxRuner;

	public Thread_02(CountDownLatch maxRuner) {
		super();
		this.maxRuner = maxRuner;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			maxRuner.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
