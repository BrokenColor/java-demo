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
			////执行慢的异常
//			for (int i = 0; i < 223; i++) {
			//执行快的异常
			for (int i = 0; i < 23; i++) {
				Math.random();
				Math.random();
				Math.random();
				System.out.println("callableB4:" + (i + 1));
			}
			if (1 == 1) {
				System.out.println("B4抛出异常");
				throw new NullPointerException();
			}
			System.out.println("B4 end" + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + "通过显示的try-catch捕获异常");
			//需要重新抛出异常，否则主线程将无法获取到异常，从而认为线程正常结束，依然会返回该线程的结果
			//可将此行代码注释进行测试
			throw e;
		}
		return "returnB4";
	}

}
