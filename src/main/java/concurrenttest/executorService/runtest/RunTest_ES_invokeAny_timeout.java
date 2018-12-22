package concurrenttest.executorService.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import concurrenttest.executorService.threaddemo.CallableA;
import concurrenttest.executorService.threaddemo.CallableB2;

/**
 * 描述：invokeAny超时测试
 * 
 * @author BrokenColor
 * @date 2018年12月21日
 */
public class RunTest_ES_invokeAny_timeout {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			List list = new ArrayList<>();
//			list.add(new CallableA());
			//超时中断线程
			list.add(new CallableB2());

			ExecutorService es = Executors.newCachedThreadPool();
			// 在指定时间内执行给定的任务，返回一个成功完成的结果（即没有抛出异常），如果有的话。
			String result = (String) es.invokeAny(list,1,TimeUnit.MILLISECONDS);
			System.out.println("getvalue:" + result);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("mainB");
			e.printStackTrace();
		}
	}

}
