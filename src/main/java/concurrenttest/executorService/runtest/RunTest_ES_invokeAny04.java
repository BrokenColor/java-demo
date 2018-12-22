package concurrenttest.executorService.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrenttest.executorService.threaddemo.CallableA;
import concurrenttest.executorService.threaddemo.CallableB3;
import concurrenttest.executorService.threaddemo.CallableB4;

/**
 * 描述：invokeAny与执行的任务异常的处理-都出现异常时
 * 执行给定的任务，返回一个成功完成的结果（即没有抛出异常），如果有的话。
 * 虽然invokeAny方法取到了returnA的值，但是线程B依然在进行，知道运行完毕
 * 线程B中断了，但是抛出的空指针异常没有在控制台打印输出
 * 可以--线程B中通过显示的try-catch捕获异常
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class RunTest_ES_invokeAny04 {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			List list = new ArrayList<>();
			// invokeAny与执行的任务异常（没有try-catch）
			list.add(new CallableB3());
			// invokeAny与执行任务异常（线程中未添加显示try-catch）
			list.add(new CallableB4());

			ExecutorService es = Executors.newCachedThreadPool();
			// 执行给定的任务，返回一个成功完成的结果（即没有抛出异常），如果有的话。
			// 都出异常的时返回最后一个异常并输出
			String result = (String) es.invokeAny(list);
			System.out.println("getvalue:" + result);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("mainB");
			e.printStackTrace();
		}
	}

}
