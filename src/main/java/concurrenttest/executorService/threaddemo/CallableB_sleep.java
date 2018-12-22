package concurrenttest.executorService.threaddemo;

import java.util.concurrent.Callable;

/**
 * 描述：sleep 8000
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class CallableB_sleep implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("B begin" + System.currentTimeMillis());
		Thread.sleep(8000);
		System.out.println("B end" + System.currentTimeMillis());
		return "returnB";
	}

}
