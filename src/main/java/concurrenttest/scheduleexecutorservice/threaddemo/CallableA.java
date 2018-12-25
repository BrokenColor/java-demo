package concurrenttest.scheduleexecutorservice.threaddemo;

import java.util.concurrent.Callable;

/**
 * 描述：线程A sleep 3秒
 * 
 * @author BrokenColor
 * @date 2018年12月25日
 */
public class CallableA implements Callable<String> {

	@Override
	public String call() throws Exception {
		try {
			System.out.println("A begin "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
			Thread.sleep(3000);
			System.out.println("A end "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ReturnA";
	}

}
