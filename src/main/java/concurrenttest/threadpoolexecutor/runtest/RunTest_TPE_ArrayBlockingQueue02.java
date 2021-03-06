package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest;

/**
 * 描述：ArrayBlockingQueue
 * 一个有限的blocking queue由数组支持。 这个队列排列元素FIFO（先进先出）
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_ArrayBlockingQueue02 {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableTest runnable = new RunnableTest();
		//初始化大小
		//队列容量不够，有一个任务出现异常
		ArrayBlockingQueue array = new ArrayBlockingQueue(2);
		System.out.println(array.size());
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, array);
		executor.execute(runnable);//1
		executor.execute(runnable);//2
		executor.execute(runnable);//3
		executor.execute(runnable);//4
		executor.execute(runnable);//5
		executor.execute(runnable);//6
		System.out.println(executor.getPoolSize()+" "+array.size());
		//
	}

}
