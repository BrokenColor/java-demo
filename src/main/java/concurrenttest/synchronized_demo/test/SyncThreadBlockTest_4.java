package concurrenttest.synchronized_demo.test;

import concurrenttest.synchronized_demo.obj.Account;
import concurrenttest.synchronized_demo.threadtest.AccountOperator;

/**
 * 描述：synchronized 修饰一个代码块<br>
 * 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadBlockTest_4 {

	public static void main(String[] args) {

		/**
		 * synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联
		 * 
		 * 在AccountOperator 类中的run方法里，我们用synchronized 给account对象加了锁。
		 * 这时，当一个线程访问account对象时，其他试图访问account对象的线程将会阻塞，
		 * 直到该线程访问account对象结束。也就是说谁拿到那个锁谁就可以运行它所控制的那段代码。
		 */
		Account account = new Account("张三", 1000.0f);
		AccountOperator accountOperator = new AccountOperator(account);

		final int THREAD_NUM = 5;
		Thread[] threads = new Thread[THREAD_NUM];
		for (int i = 0; i < THREAD_NUM; i++) {
			threads[i] = new Thread(accountOperator, "Thread-" + i);
			threads[i].start();
		}
	}

}
