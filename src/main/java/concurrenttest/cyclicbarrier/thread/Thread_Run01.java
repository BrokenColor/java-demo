package concurrenttest.cyclicbarrier.thread;

import concurrenttest.cyclicbarrier.service.Service_Run01;

/**
 * CyclicBarrier 类TEST 模拟赛跑
 * 
 * @author bc
 * @data 2018年9月29日
 */
public class Thread_Run01 extends Thread {

	private Service_Run01 service;

	public Thread_Run01(Service_Run01 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.beginRun();
	}
}
