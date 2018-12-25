package concurrenttest.scheduleexecutorservice.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import concurrenttest.scheduleexecutorservice.threaddemo.CallableA;
import concurrenttest.scheduleexecutorservice.threaddemo.CallableB;

/**
 * 描述：schedule(Callable<V> callable, long delay, TimeUnit unit)
 * 创建并执行在给定延迟后启用的ScheduledFuture。
 * 
 * @author BrokenColor
 * @date 2018年12月25日
 */
public class RunTest_SE_callable {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			List<Callable> list = new ArrayList<>();
			list.add(new CallableA());
			list.add(new CallableB());

			ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
			//schedule方法创建具有各种延迟的任务，并返回可用于取消或检查执行的任务对象
			ScheduledFuture<String> futureA = executorService.schedule(list.get(0), 4L, TimeUnit.SECONDS);
			ScheduledFuture<String> futureB = executorService.schedule(list.get(1), 4L, TimeUnit.SECONDS);
			
			System.out.println(" X " + System.currentTimeMillis());
			System.out.println("A返回值：" + futureA.get());
			System.out.println("B返回值：" + futureB.get());
			System.out.println(" Y " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
