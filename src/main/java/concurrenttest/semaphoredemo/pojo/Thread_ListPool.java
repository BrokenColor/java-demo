package concurrenttest.semaphoredemo.pojo;

import concurrenttest.semaphoredemo.serviceImp.Semaphore_ListPool;

/**
 * 线程Thread_ListPool类
 * @author bc	
 * @data 2018年9月7日
 */
public class Thread_ListPool extends Thread {
	
	private Semaphore_ListPool service;
	
	public Thread_ListPool(Semaphore_ListPool service){
		super();
		this.service = service;
	}

	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String stringValue = service.get();
			System.out.println(Thread.currentThread().getName()+"取值："+stringValue);
			service.put(stringValue);
		}
	}
	
}
