package concurrenttest.executorService.threaddemo;

import java.util.concurrent.Callable;

/**
 * 描述：CallableB4 
 *  throw new NullPointerException();
 *  通过显示的try-catch捕获异常
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class CallableB4 implements Callable<String> {

	@SuppressWarnings("unused")
	@Override
	public String call() throws Exception {
		try {
			System.out.println("B4 begin" + System.currentTimeMillis());
			for (int i = 0; i < 223; i++) {
					Math.random();
					Math.random();
					Math.random();
					System.out.println("callableB4:" + (i + 1));
			}
			if(1 == 1) {
				System.out.println("B4抛出异常");
				throw new NullPointerException();
			}
			System.out.println("B4 end" + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+"通过显示的try-catch捕获异常");
			throw e;
		}
		return "returnB4";
	}

}
