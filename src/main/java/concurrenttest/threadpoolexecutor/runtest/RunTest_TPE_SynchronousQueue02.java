package concurrenttest.threadpoolexecutor.runtest;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrenttest.threadpoolexecutor.threaddemo.RunnableTest;

/**
 * 描述：SynchronousQueue A blocking queue其中每个插入操作必须等待另一个线程相应的删除操作，反之亦然。
 * 同步队列没有任何内部容量，甚至没有一个容量。 你不能peek在同步队列，因为一个元素，当您尝试删除它才存在;
 * 您无法插入元素（使用任何方法），除非另有线程正在尝试删除它; 你不能迭代，因为没有什么可以迭代。 队列的头部是第一个排队的插入线程尝试添加到队列中的元素;
 * 如果没有这样排队的线程，那么没有元素可用于删除，并且poll()将返回null 。 为了其他Collection方法（例如contains ）的目的，
 * SynchronousQueue充当空集合。 此队列不允许null元素。
 * 
 * @author BrokenColor
 * @date 2018年11月19日
 */
public class RunTest_TPE_SynchronousQueue02 {

	public static void main(String[] args) throws InterruptedException {

		RunnableTest runnable = new RunnableTest();
		// 任务超出
		SynchronousQueue syn = new SynchronousQueue();
		System.out.println(syn.size());
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, syn);
		executor.execute(runnable);// 1
		executor.execute(runnable);// 2
		executor.execute(runnable);// 3
		executor.execute(runnable);// 4
		System.out.println(executor.getPoolSize() + " " + syn.size());
		// 直接执行3个任务
		// 一个任务拒绝执行
	}

}
