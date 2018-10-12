package concurrenttest.executors.threaddemo;

import java.util.concurrent.ThreadFactory;

/**
 * 描述：线程工厂 根据需要创建新线程的对象。
 * 使用线程工厂可以删除new Thread的硬连线 ，使应用程序能够使用特殊的线程子类，优先级等。
 * 
 * @author BrokenColor
 * @date 2018年10月12日
 */
public class ThreadFactoryTest implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName(" 定制池中的线程对象的名称：" + Math.random());
		return thread;
	}

}
