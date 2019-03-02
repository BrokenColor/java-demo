package concurrenttest.synchronized_demo.threadtest;

/**
 * 描述：synchronized 修饰一个代码块<br>
 * 当一个线程访问对象的一个synchronized(this)同步代码块时，
 * 另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。 
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadBlock_2 implements Runnable {
	private static int count;

	public SyncThreadBlock_2() {
		super();
		count = 0;
	}

	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("A")) {
			countAdd();
		} else if (Thread.currentThread().getName().equals("B")) {
			printCount();
		}
	}

	/**
	 * synchronized修饰
	 */
	public void countAdd() {
		synchronized (this) {
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

	public void printCount() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + "count:" + (count));
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
