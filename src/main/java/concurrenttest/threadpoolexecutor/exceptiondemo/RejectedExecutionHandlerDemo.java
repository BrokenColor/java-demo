package concurrenttest.threadpoolexecutor.exceptiondemo;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest04;

/**
 * 描述：自定义异常处理 自定义拒绝执行任务的行为
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RejectedExecutionHandlerDemo implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(((RunnableTest04)r).getUsername() + ":被拒绝执行");
	}

}
