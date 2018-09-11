package concurrenttest.semaphoredemo.pojo;

import concurrenttest.semaphoredemo.service.SemaphoreService;

/**
 * 线程B类
 * @author bc
 * @data 2018年9月7日
 */
public class ThreadB extends Thread {
	
	private SemaphoreService service;
	
	public ThreadB(SemaphoreService service){
		super();
		this.service = service;
	}

	@Override
	public void run() {
		System.out.println(this.getName()+"启动了");
		service.testMethod();
	}
	
}
