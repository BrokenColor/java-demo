package concurrenttest.threadpoolexecutor.threadFactorydemo;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;
import java.util.concurrent.ThreadFactory;

/**
 * 描述：线程工厂 根据需要创建新线程的对象。 
 * 使用线程工厂可以删除new Thread的硬连线 ，使应用程序能够使用特殊的线程子类，优先级等。
 * thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler()
 * @author BrokenColor
 * @date 2018年11月17日
 */
public class ThreadFactoryB implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName("Eason:" + new Date());
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("自定义处理异常"+t.getName()+" "+e.getMessage());
				e.getStackTrace();
			}
		});
		return thread;
	}

}
