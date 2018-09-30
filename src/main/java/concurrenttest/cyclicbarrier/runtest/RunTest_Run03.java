package concurrenttest.cyclicbarrier.runtest;

import concurrenttest.cyclicbarrier.service.Service_Run;
import concurrenttest.cyclicbarrier.serviceimpl.Service_Run03;
import concurrenttest.cyclicbarrier.thread.Thread_Run;

/**
 * CyclicBarrier 类测试
 * 
 * @author bc
 * @data 2018年9月30日
 */
public class RunTest_Run03 {

	public static void main(String[] args) throws InterruptedException {

		Service_Run service = new Service_Run03();

		Thread_Run[] threads = new Thread_Run[2];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread_Run(service);
			threads[i].start();
		}

	}

}
