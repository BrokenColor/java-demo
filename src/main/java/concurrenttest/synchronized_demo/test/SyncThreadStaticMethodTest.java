package concurrenttest.synchronized_demo.test;

import concurrenttest.synchronized_demo.threadtest.SyncThreadStaticMethod;

/**
 * 描述：synchronized 修饰一个静态方法<br>
 * 
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadStaticMethodTest {
		
	public static void main(String[] args) {
		/**
		 * syncThread1和syncThread2是SyncThreadStaticMethod的两个对象，
		 * 但在thread1和thread2并发执行时却保持了线程同步。
		 * 这是因为SyncThreadStaticMethod的run中调用了静态方法synMethod，而静态方法是属于类的，
		 * 所以syncThread1和syncThread2相当于用了同一把锁
		 */
		SyncThreadStaticMethod syncThread1 = new SyncThreadStaticMethod();
		SyncThreadStaticMethod syncThread2 = new SyncThreadStaticMethod();
		Thread thread1 = new Thread(syncThread1, "thread1");
		Thread thread2 = new Thread(syncThread2, "thread2");
		thread1.start();
		thread2.start();
		
	}

}
