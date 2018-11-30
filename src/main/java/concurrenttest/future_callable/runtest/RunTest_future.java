package concurrenttest.future_callable.runtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.future_callable.callabledemo.Callable_Test00;

/**
 * 描述：Future.get() 阻塞性
 * 
 * @author BrokenColor
 * @date 2018年11月30日
 */
public class RunTest_future {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Callable_Test00 callable1 = new Callable_Test00("user1", 10000);
		Callable_Test00 callable2 = new Callable_Test00("user2", 8000);
		Callable_Test00 callable3 = new Callable_Test00("user3", 6000);
		Callable_Test00 callable4 = new Callable_Test00("user4", 4000);
		Callable_Test00 callable5 = new Callable_Test00("user5", 2000);
		
		List<Callable> callableList = new ArrayList<Callable>();
		callableList.add(callable1);
		callableList.add(callable2);
		callableList.add(callable3);
		callableList.add(callable4);
		callableList.add(callable5);
		
		List<Future> futureList = new ArrayList<Future>();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(9, 9, 999, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		for (int i = 0; i < 5; i++) {
			futureList.add(pool.submit(callableList.get(i)));
		}
		System.out.println("run!!!"+System.currentTimeMillis());
		try {
			for (int i = 0; i < 5; i++) {
				System.err.println(futureList.get(i).get()+" " + System.currentTimeMillis());
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
