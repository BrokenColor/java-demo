package concurrenttest.completionService.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.completionService.callabledemo.Callable_Test;

/**
 * 描述：CompletionService 类测试
 * 	CompletionService可以解决Future阻塞的问题
 * 
 * @author BrokenColor
 * @date 2018年12月1日
 */
public class RunTest_completionService {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Callable_Test callable1 = new Callable_Test("user1", 10000);
		Callable_Test callable2 = new Callable_Test("user2", 8000);
		Callable_Test callable3 = new Callable_Test("user3", 6000);
		Callable_Test callable4 = new Callable_Test("user4", 4000);
		Callable_Test callable5 = new Callable_Test("user5", 2000);

		List<Callable> callableList = new ArrayList<Callable>();
		callableList.add(callable1);
		callableList.add(callable2);
		callableList.add(callable3);
		callableList.add(callable4);
		callableList.add(callable5);

		List<Future> futureList = new ArrayList<Future>();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(9, 9, 999, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		//CompletionService可以解决Future阻塞的问题
		CompletionService<Object> csRef = new ExecutorCompletionService<>(pool);
		for (int i = 0; i < 5; i++) {
			futureList.add(csRef.submit(callableList.get(i)));
		}
		System.out.println("run!!!" + System.currentTimeMillis());
		try {
			for (int i = 0; i < 5; i++) {
//			for (int i = 0; i < 6; i++) {//当前如果有任务没被执行完，csRef.take().get()方法还是回阻塞
				System.out.println("等待第" + (i + 1) + "个返回值");
				//csRef.take() 检索并删除代表下一个完成任务的未来，等待是否还没有任务。
				System.err.println(csRef.take().get() + " " + System.currentTimeMillis());
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
