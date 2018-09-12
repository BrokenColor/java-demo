/**
 * 
 */
package concurrenttest.semaphoredemo.pojo;

import concurrenttest.semaphoredemo.serviceImp.Semaphore_Repast;

/**
 * 生产者
 * @author bc
 * @data 2018年9月12日
 */
public class Thread_Producer extends Thread {

	private Semaphore_Repast service;

	public Thread_Producer(Semaphore_Repast service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.set();
	}	
}
