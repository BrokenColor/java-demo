package concurrenttest.threadpoolexecutor.runtest;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest_Policy;

/**
 * 描述：CallerRunsPolicy 一个被拒绝的任务的处理程序，直接在
 * execute方法的调用线程中运行被拒绝的任务，除非执行程序已被关闭，否则这个任务被丢弃。
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_Policy_CallerRunsPolicy02 {

	public static void main(String[] args) throws InterruptedException {

		RunnableTest_Policy runnable = new RunnableTest_Policy();
		runnable.run();
		System.out.println("main end !");
	}

}
