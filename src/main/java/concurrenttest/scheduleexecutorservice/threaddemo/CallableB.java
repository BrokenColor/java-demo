package concurrenttest.scheduleexecutorservice.threaddemo;

import java.util.concurrent.Callable;

/**
 * 描述：
 * 
 * @author BrokenColor
 * @date 2018年12月25日
 */
public class CallableB implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("B begin "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
		System.out.println("B end "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
		return "ReturnB";
	}

}
