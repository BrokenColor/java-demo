package concurrenttest.scheduleexecutorservice.threaddemo;

/**
 * 描述：runnable线程B
 * 
 * @author BrokenColor
 * @date 2018年12月25日
 */
public class RunnableB implements Runnable {

	@Override
	public void run() {
		System.out.println("B begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
		System.out.println("B end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
	}

}
