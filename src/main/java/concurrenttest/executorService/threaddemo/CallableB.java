package concurrenttest.executorService.threaddemo;

import java.util.concurrent.Callable;

/**
 * 描述：
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class CallableB implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("B begin" + System.currentTimeMillis());
		for (int i = 0; i < 223; i++) {
			Math.random();
			Math.random();
			Math.random();
			System.out.println("callableB:" + (i + 1));
		}
		System.out.println("B end" + System.currentTimeMillis());
		return "returnB";
	}

}
