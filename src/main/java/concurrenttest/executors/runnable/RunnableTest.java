package concurrenttest.executors.runnable;

/**
 * 描述：创建一个线程
 * 
 * @author BrokenColor
 * @date 2018年10月9日
 */
public class RunnableTest implements Runnable {
	private String userName;

	public RunnableTest(String userName) {
		this.userName = userName;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " userName:" + this.userName + " begin "
					+ System.currentTimeMillis());
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " userName:" + this.userName + " end "
					+ System.currentTimeMillis());
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}

}
