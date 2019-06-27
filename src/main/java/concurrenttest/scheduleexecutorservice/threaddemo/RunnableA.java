package concurrenttest.scheduleexecutorservice.threaddemo;

/**
 * 描述：runnable线程A sleep 3秒
 * 
 * @author BrokenColor
 * @date 2018年12月25日
 */
public class RunnableA implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("A begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
			Thread.sleep(3000);
			System.out.println("A end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
