/**
 * 
 */
package concurrenttest.countdownlatch.thread;

import concurrenttest.countdownlatch.service.Service_01;

/**
 * CountDownLatch 类测试
 * @author bc
 * @data 2018年9月20日
 */
public class Thread_01 extends Thread{

	private Service_01 service;
	
	public Thread_01(Service_01 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}
}
