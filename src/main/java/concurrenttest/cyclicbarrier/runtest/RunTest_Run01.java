package concurrenttest.cyclicbarrier.runtest;

import java.util.concurrent.CyclicBarrier;

import concurrenttest.cyclicbarrier.service.Service_Run01;
import concurrenttest.cyclicbarrier.thread.Thread_Run01;

/**
 * CyclicBarrier 类测试
 * 
 * getNumberWaiting() 返回目前正在等待障碍的各方的数量。
 * 
 * @author bc
 * @data 2018年9月29日
 */
public class RunTest_Run01 {

	public static void main(String[] args) throws InterruptedException {

		CyclicBarrier cbRef = new CyclicBarrier(2);
		
		Service_Run01 service = new Service_Run01(cbRef);

		Thread_Run01[] threads = new Thread_Run01[4];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread_Run01(service);
			threads[i].start();
		}

	}

}
