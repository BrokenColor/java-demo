package concurrenttest.executorService.threaddemo;

import java.util.concurrent.Callable;

/**
 * 描述：CallableB2 
 *  有if (Thread.currentThread().interrupted())
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class CallableB2 implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("B2 begin" + System.currentTimeMillis());
		for (int i = 0; i < 223; i++) {
			if (Thread.currentThread().interrupted()) {
				Math.random();
				Math.random();
				Math.random();
				System.out.println("callableB2:" + (i + 1));
			}else {
				System.out.println("B2抛出异常");
				throw new InterruptedException();
			}
		}
		System.out.println("B2 end" + System.currentTimeMillis());
		return "returnB2";
	}

}
