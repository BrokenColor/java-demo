package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.ThreadA;
import concurrenttest.semaphoredemo.pojo.ThreadB;
import concurrenttest.semaphoredemo.pojo.ThreadC;
import concurrenttest.semaphoredemo.serviceImp.SemaphoreService_0;

/**
 * test类
 * @author bc
 * @data 2018年9月7日
 */
public class RunTest_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SemaphoreService_0 service = new SemaphoreService_0();
		
		ThreadA a = new ThreadA(service);
		a.setName("A");
		ThreadB b = new ThreadB(service);
		b.setName("B");
		ThreadC c = new ThreadC(service);
		c.setName("C");
		a.start();
		b.start();
		c.start();
	}

}
