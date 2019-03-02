package concurrenttest.synchronized_demo.test;

import concurrenttest.synchronized_demo.threadtest.SyncThreadBlock;

/**
 * 描述：synchronized 修饰一个代码块<br>
 * 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadBlockTest_2 {

	public static void main(String[] args) {
		
		/**
		 * synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联
		 * 
		 * 这时创建了两个SyncThread的对象syncThread1和syncThread2，
		 * 线程thread1执行的是syncThread1对象中的synchronized代码(run)，
		 * 而线程thread2执行的是syncThread2对象中的synchronized代码(run)；
		 * 我们知道synchronized锁定的是对象，这时会有两把锁分别锁定syncThread1对象和syncThread2对象，
		 * 而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行
		 */
		Thread thread3 = new Thread(new SyncThreadBlock(), "thread3");
		Thread thread4 = new Thread(new SyncThreadBlock(), "thread4");
		thread3.start();
		thread4.start();

	}

}
