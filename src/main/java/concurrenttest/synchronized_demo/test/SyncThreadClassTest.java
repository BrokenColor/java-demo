package concurrenttest.synchronized_demo.test;

import concurrenttest.synchronized_demo.threadtest.SyncThreadClass;

/**
 * 描述：synchronized 修饰一个类<br>
 * synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁。
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadClassTest {
		
	public static void main(String[] args) {
		/**
		 * syncThread1和syncThread2是SyncThreadStaticMethod的两个对象，
		 * 但在thread1和thread2并发执行时却保持了线程同步。
		 * 这是因为SyncThreadClass的rsynMethod中synchronized (SyncThreadClass.class)，
		 * 所以syncThread1和syncThread2相当于用了同一把锁
		 */
		SyncThreadClass syncThread1 = new SyncThreadClass();
		SyncThreadClass syncThread2 = new SyncThreadClass();
		Thread thread1 = new Thread(syncThread1, "thread1");
		Thread thread2 = new Thread(syncThread2, "thread2");
		thread1.start();
		thread2.start();
		
	}

}
