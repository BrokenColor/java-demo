package concurrenttest.executorService.threaddemo;

import java.util.concurrent.Callable;

/**
 * 描述：CallableB3 
 *  throw new NullPointerException();
 *  
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class CallableB3 implements Callable<String> {

	@SuppressWarnings("unused")
	@Override
	public String call() throws Exception {
		System.out.println("B3 begin" + System.currentTimeMillis());
		for (int i = 0; i < 223; i++) {
				Math.random();
				Math.random();
				Math.random();
				System.out.println("callableB3:" + (i + 1));
		}
		if(1 == 1) {
			System.out.println("B3抛出异常");
			throw new NullPointerException();
		}
		System.out.println("B3 end" + System.currentTimeMillis());
		return "returnB3";
	}

}
