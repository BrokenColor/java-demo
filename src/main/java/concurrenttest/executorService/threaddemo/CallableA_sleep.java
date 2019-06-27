package concurrenttest.executorService.threaddemo;

import java.util.concurrent.Callable;

/**
 * 描述：sleep 5000
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class CallableA_sleep implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("A begin" + System.currentTimeMillis());
		Thread.sleep(5000);
		System.out.println("A end" + System.currentTimeMillis());
		return "---------returnA";
	}

}
