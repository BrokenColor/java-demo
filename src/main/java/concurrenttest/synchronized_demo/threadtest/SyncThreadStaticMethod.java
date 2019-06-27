package concurrenttest.synchronized_demo.threadtest;

/**
 * 描述：synchronized 修饰一个静态方法<br>
 * 修改一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象;
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class SyncThreadStaticMethod implements Runnable {
	private static int count;

	public SyncThreadStaticMethod() {
		super();
		count = 0;
	}
	
	//静态方法是属于类的而不属于对象的。同样的，synchronized修饰的静态方法锁定的是这个类的所有对象
	public synchronized static void synMethod() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + ":" + (count++));
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		synMethod();
	}

}
