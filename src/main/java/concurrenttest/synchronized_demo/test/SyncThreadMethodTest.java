package concurrenttest.synchronized_demo.test;

import concurrenttest.synchronized_demo.threadtest.SyncThreadMethod;

/**
 * 描述：synchronized 修饰一个方法<br>
 * 一个线程访问一个对象中的synchronized同步方法时，其他试图访问该对象的线程将被阻塞
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadMethodTest {
		
	public static void main(String[] args) {
		/**
		 * 当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized同步方法时，
		 * 在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个同步方法以后才能执行该同步方法。
		 * Thread1和thread2是互斥的，因为在执行synchronized同步方法时会锁定当前的对象，只有执行完同步方法才能释放该对象锁，
		 * 下一个线程才能执行并锁定该对象。
		 */
		SyncThreadMethod syncThread = new SyncThreadMethod();
		Thread thread1 = new Thread(syncThread, "thread1");
		Thread thread2 = new Thread(syncThread, "thread2");
		thread1.start();
		thread2.start();
		
	}

}
