package concurrenttest.completionService.callabledemo;

import java.util.concurrent.Callable;

/**
 * 描述：callableBs
 * 
 * @author BrokenColor
 * @date 2018年12月3日
 */
public class Callable_TestB implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("callableB beging: "+System.currentTimeMillis());
		Thread.sleep(5000);
		int i = 0;
		if (i == 0) {
			System.out.println("抛出异常");
			throw new Exception("抛出异常");
		}
		System.out.println("callableB end: "+System.currentTimeMillis());
		return "returnB";
	}
	
}
