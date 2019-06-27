package concurrenttest.synchronized_demo.threadtest;

import concurrenttest.synchronized_demo.obj.Account;

/**
 * 描述：指定要给某个对象加锁
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class AccountOperator implements Runnable {

	private Account account;
	
	public AccountOperator(Account account) {
		super();
		this.account = account;
	}
	
	/**
	 * 
	 */

	@Override
	public void run() {
		//指定要给某个对象加锁
		synchronized (account) {
			account.deposit(450);
			account.withdraw(500);
			System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
		}

	}
	
	/**
	 * 当有一个明确的对象作为锁时，就可以用类似下面这样的方式写程序。
	 */
//	public void method3(SomeObject obj)
//	{
//	   //obj 锁定的对象
//	   synchronized(obj)
//	   {
//	      // todo
//	   }
//	}
	/**
	 * 当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的对象来充当锁
	 */
//	class Test implements Runnable
//	{
//	   private byte[] lock = new byte[0];  // 特殊的instance变量
//	   public void method()
//	   {
//	      synchronized(lock) {
//	         // todo 同步代码块
//	      }
//	   }
//
//	   public void run() {
//
//	   }
//	}
}
