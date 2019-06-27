package concurrenttest.completionService.callabledemo;

import java.util.concurrent.Callable;

/**
 * 描述：callableA
 * 
 * @author BrokenColor
 * @date 2018年12月3日
 */
public class Callable_TestA implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("callableA beging: "+System.currentTimeMillis());
		Thread.sleep(1000);
		System.out.println("callableA end: "+System.currentTimeMillis());
		return "returnA";
	}
	
}
