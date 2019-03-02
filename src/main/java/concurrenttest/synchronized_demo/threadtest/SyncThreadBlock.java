package concurrenttest.synchronized_demo.threadtest;

/**
 * 描述：synchronized 修饰一个代码块<br>
 * 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadBlock implements Runnable {
	private static int count;
	
	public SyncThreadBlock() {
		super();
		count = 0;
	}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName()+":"+(count++));
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
