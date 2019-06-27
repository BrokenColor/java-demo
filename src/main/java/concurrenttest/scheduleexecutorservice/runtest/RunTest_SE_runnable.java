package concurrenttest.scheduleexecutorservice.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import concurrenttest.scheduleexecutorservice.threaddemo.RunnableA;
import concurrenttest.scheduleexecutorservice.threaddemo.RunnableB;

/**
 * 描述：schedule(Runnable command, long delay, TimeUnit unit)
 * 创建并执行在给定延迟后启用的单次操作。
 * 将定时任务与线程池功能结合使用
 * 
 * @author BrokenColor
 * @date 2018年12月25日
 */
public class RunTest_SE_runnable {

	public static void main(String[] args) {
		List<Runnable> list = new ArrayList<>();
		list.add(new RunnableA());
		list.add(new RunnableB());
		// 单任务
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

		System.out.println(" X " + System.currentTimeMillis());
		//创建并执行在给定延迟后启用的单次操作。
		executorService.schedule(list.get(0), 0L, TimeUnit.SECONDS);
		executorService.schedule(list.get(1), 0L, TimeUnit.SECONDS);
		System.out.println(" Y " + System.currentTimeMillis());
	}

}
