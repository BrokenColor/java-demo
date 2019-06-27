package concurrenttest.executorService.threaddemo;

import java.util.concurrent.Callable;

/**
 * 描述：
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class CallableA implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("A begin" + System.currentTimeMillis());
		for (int i = 0; i < 123; i++) {
			Math.random();
			Math.random();
			Math.random();
			System.out.println("callableA:" + (i + 1));
		}
		System.out.println("A end" + System.currentTimeMillis());
		return "---------returnA";
	}

}
