package concurrenttest.threadpoolexecutor.threaddemo;

/**
 * 描述：线程
 * 
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunnableTest implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" run "+System.currentTimeMillis());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
