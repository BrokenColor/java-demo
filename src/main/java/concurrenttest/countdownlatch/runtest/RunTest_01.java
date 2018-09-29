package concurrenttest.countdownlatch.runtest;

import concurrenttest.countdownlatch.service.Service_01;
import concurrenttest.countdownlatch.thread.Thread_01;

/**
 * CountDownLatch 类test
 * 允许一个或多个线程等待直到在其他线程中执行的一组操作完成的同步辅助。
 * @author bc
 * @data 2018年9月20日
 */
public class RunTest_01 {

	public static void main(String[] args) throws InterruptedException {
		Service_01 service = new Service_01();
		Thread_01 thread = new Thread_01(service);
		thread.start();
		Thread.sleep(20000);
		service.downMethod();
	}

}
