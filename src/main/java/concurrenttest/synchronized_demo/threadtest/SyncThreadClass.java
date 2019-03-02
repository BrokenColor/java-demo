package concurrenttest.synchronized_demo.threadtest;

/**
 * 描述：synchronized 修饰一个类<br>
 * 其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadClass implements Runnable {
	private static int count;

	public SyncThreadClass() {
		super();
		count = 0;
	}
	
	//synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁。
	public void synMethod() {
		synchronized (SyncThreadClass.class) {
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
	
	@Override
	public void run() {
		synMethod();
	}

}
