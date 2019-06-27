package concurrenttest.synchronized_demo.threadtest;

/**
 * 描述：synchronized 修饰一个方法<br>
 * 被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象
 *  Synchronized修饰一个方法很简单，就是在方法的前面加synchronized
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadMethod implements Runnable {
	private static int count;

	public SyncThreadMethod() {
		super();
		count = 0;
	}
	
	/**
	 * 在用synchronized修饰方法时要注意以下几点：
	 *  1. synchronized关键字不能继承。 
	 *  2.在定义接口方法时不能使用synchronized关键字。
	 *  3.构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步。 
	 */
	@Override
	public synchronized void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + ":" + (count++));
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
