package concurrenttest.executorService.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import concurrenttest.executorService.threaddemo.CallableA_sleep;
import concurrenttest.executorService.threaddemo.CallableB_sleep;

/**
 * 描述：invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
 * 执行给定的任务，返回持有他们的状态和结果的所有完成的List<Future<T>>列表。
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class RunTest_ES_invokeAll_timeout {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			List list = new ArrayList<>();
			list.add(new CallableA_sleep());
			list.add(new CallableB_sleep());

			ExecutorService es = Executors.newCachedThreadPool();
			// 执行给定的任务，返回持有他们的状态和结果的所有完成的List<Future<T>>列表
			//阻塞
			List<Future<String>> listFuture = es.invokeAll(list, 5, TimeUnit.SECONDS);
			System.out.println("invokeAll end"+System.currentTimeMillis());
			for (int i = 0; i < listFuture.size(); i++) {
				System.out.println("return:" + listFuture.get(i).get() + " " + System.currentTimeMillis());
			}
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
