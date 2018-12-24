package concurrenttest.executorService.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import concurrenttest.executorService.threaddemo.CallableA;
import concurrenttest.executorService.threaddemo.CallableB3;

/**
 * 描述：invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
 * 执行给定的任务，返回持有他们的状态和结果的所有完成的List<Future<T>>列表。
 * 执行快的正常,慢的异常
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class RunTest_ES_invokeAll02_timeout {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			List list = new ArrayList<>();
			//执行快的正常,慢的异常
			list.add(new CallableA());
			list.add(new CallableB3());

			ExecutorService es = Executors.newCachedThreadPool();
			// 执行给定的任务，返回持有他们的状态和结果的所有完成的List<Future<T>>列表
			//阻塞
			List<Future<String>> listFuture = es.invokeAll(list, 2, TimeUnit.SECONDS);
			System.out.println("invokeAll end"+System.currentTimeMillis());
			for (int i = 0; i < listFuture.size(); i++) {
				System.out.println("return:" + listFuture.get(i).get() + " " + System.currentTimeMillis());
			}
			//invokeAll方法对callable抛出的异常可以处理
			//直接进入catch中所以未被打印
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
