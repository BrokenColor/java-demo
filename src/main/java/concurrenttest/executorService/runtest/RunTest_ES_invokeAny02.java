package concurrenttest.executorService.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrenttest.executorService.threaddemo.CallableA;
import concurrenttest.executorService.threaddemo.CallableB2;

/**
 * 描述：invokeAny(Collection<? extends Callable<T>> tasks)
 * 执行给定的任务，返回一个成功完成的结果（即没有抛出异常），如果有的话。
 * CallableB2中添加if (Thread.currentThread().interrupted())
 * 线程A执行完毕之后，线程池将线程B设置未中断状态，而线程B可以自定义对interrupte状态的处理，
 * 也就是可以决定是否使用Thread.currentThread().interrupted()结合throw new InterruptedException()
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class RunTest_ES_invokeAny02 {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			List list = new ArrayList<>();
			list.add(new CallableA());
			//CallableB2中有if (Thread.currentThread().interrupted())
			list.add(new CallableB2());
			
			ExecutorService es = Executors.newCachedThreadPool();
			//执行给定的任务，返回一个成功完成的结果（即没有抛出异常），如果有的话。
			//取得最先完成任务的结果值
			String result = (String) es.invokeAny(list);
			System.out.println("getvalue:"+result);
			System.out.println("ok");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
