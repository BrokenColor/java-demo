package concurrenttest.future_callable.executionHandler;

import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 描述：自定义异常处理 自定义拒绝执行任务的行为
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RejectedExecutionHandlerDemo implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(((FutureTask)r).toString() + ":被拒绝执行");
	}

}
