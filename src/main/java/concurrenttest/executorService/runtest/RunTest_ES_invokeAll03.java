package concurrenttest.executorService.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import concurrenttest.executorService.threaddemo.CallableA;
import concurrenttest.executorService.threaddemo.CallableB4;

/**
 * 描述：invokeAll(Collection<? extends Callable<T>> tasks)
 * 执行给定的任务，返回持有他们的状态和结果的所有完成的List<Future<T>>列表。
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class RunTest_ES_invokeAll03 {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			List list = new ArrayList<>();
			//执行慢的正常,快的异常
			//添加顺序与运行结果有联系
			list.add(new CallableB4());
			list.add(new CallableA());

			ExecutorService es = Executors.newCachedThreadPool();
			// 执行给定的任务，返回持有他们的状态和结果的所有完成的List<Future<T>>列表
			//阻塞
			List<Future<String>> listFuture = es.invokeAll(list);
			System.out.println("invokeAll end:"+System.currentTimeMillis());
			//第一次出现异常 不再继续执行第二次循环,进入catch块中
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
