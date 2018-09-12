/**
 * 
 */
package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.Thread_Consumer;
import concurrenttest.semaphoredemo.pojo.Thread_Producer;
import concurrenttest.semaphoredemo.serviceImp.Semaphore_Repast;

/**
 * 实现生产者与消费者模式 test
 * @author bc
 * @data 2018年9月12日
 */
public class RunTest_Repast {
	
	public static void main(String[] args) {
		Semaphore_Repast service = new Semaphore_Repast();
		Thread_Producer[] arrayP = new Thread_Producer[60];
		Thread_Consumer[] arrayc = new Thread_Consumer[60];
		for (int i = 0; i < 60; i++) {
			arrayP[i] = new Thread_Producer(service);
			arrayc[i] = new Thread_Consumer(service);
		}
		for (int i = 0; i < 60; i++) {
			arrayP[i].start();
			arrayc[i].start();
		}
	}
}
