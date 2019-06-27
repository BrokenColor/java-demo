package concurrenttest.synchronized_demo.test;

import concurrenttest.synchronized_demo.threadtest.SyncThreadBlock_2;

/**
 * 描述：synchronized 修饰一个代码块<br>
 * 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadBlockTest_3 {

	public static void main(String[] args) {
		
		/**
		 * synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联
		 * 
		 * SyncThreadBlock_2中countAdd是一个synchronized的，printCount是非synchronized的。
		 * 从结果中可以看出一个线程访问一个对象的synchronized代码块时，
		 * 别的线程可以访问该对象的非synchronized代码块而不受阻塞。
		 */
		SyncThreadBlock_2 block_2 = new SyncThreadBlock_2();
		Thread threadA = new Thread(block_2, "A");
		Thread threadB = new Thread(block_2, "B");
		threadA.start();
		threadB.start();

	}

}
