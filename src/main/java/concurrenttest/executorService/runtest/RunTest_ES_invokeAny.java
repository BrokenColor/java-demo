package concurrenttest.executorService.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrenttest.executorService.threaddemo.CallableA;
import concurrenttest.executorService.threaddemo.CallableB;

/**
 * 描述：invokeAny(Collection<? extends Callable<T>> tasks)
 * 执行给定的任务，返回一个成功完成的结果（即没有抛出异常），如果有的话。
 * 虽然invokeAny方法取到了returnA的值，但是线程B依然在进行，知道运行完毕
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class RunTest_ES_invokeAny {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			List list = new ArrayList<>();
			list.add(new CallableA());
			list.add(new CallableB());
			
			ExecutorService es = Executors.newCachedThreadPool();
			//执行给定的任务，返回一个成功完成的结果（即没有抛出异常），如果有的话。
			//取得最先完成任务的结果值
			String result = (String) es.invokeAny(list);
			System.out.println("getvalue:"+result);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//虽然invokeAny方法取到了returnA的值，但是线程B依然在进行，知道运行完毕
	}

}
