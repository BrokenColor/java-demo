/**
 * 
 */
package concurrenttest.semaphoredemo.pojo;

import concurrenttest.semaphoredemo.serviceImp.Semaphore_Repast;

/**
 * 消费者
 * @author bc
 * @data 2018年9月12日
 */
public class Thread_Consumer extends Thread {

	private Semaphore_Repast service;
	
	public Thread_Consumer(Semaphore_Repast service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.get();
	}
}
