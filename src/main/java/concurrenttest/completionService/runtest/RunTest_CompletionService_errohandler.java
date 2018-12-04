package concurrenttest.completionService.runtest;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

import concurrenttest.completionService.callabledemo.Callable_TestA;
import concurrenttest.completionService.callabledemo.Callable_TestB;

/**
 * 描述：CompletionService类异常处理
 * 
 * @author BrokenColor
 * @date 2018年12月3日
 */
public class RunTest_CompletionService_errohandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Callable_TestA callableA = new Callable_TestA();
			Callable_TestB callableB = new Callable_TestB();
			
			Executor executor = Executors.newSingleThreadExecutor();
			CompletionService cs = new ExecutorCompletionService<>(executor);
			cs.submit(callableA);
			cs.submit(callableB);
			//B虽然出现异常，但是没有调用FutureTask类的get()方法，所以未出现异常
			for (int i = 0; i < 2; i++) {
				System.out.println("cs.take().get():"+cs.take().get());
//				System.out.println("cs.take():"+cs.take());
			}
			System.out.println("mian end"+System.currentTimeMillis());
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
