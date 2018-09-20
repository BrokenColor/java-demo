/**
 * 
 */
package concurrenttest.countdownlatch.service;

import java.util.concurrent.CountDownLatch;

/**
 * 允许一个或多个线程等待直到在其他线程中执行的一组操作完成的同步辅助。
 * @author bc
 * @data 2018年9月20日
 */
public class Service_01 {
	
	private CountDownLatch down = new CountDownLatch(1);
	
	public void testMethod() {
		try {
			System.out.println("await()方法前");
			down.await();
			System.out.println("await()方法后");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void downMethod() {
		System.out.println("执行countDown()方法");
		down.countDown();
	}
	
	
}
