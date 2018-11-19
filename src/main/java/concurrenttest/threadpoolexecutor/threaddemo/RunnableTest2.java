package concurrenttest.threadpoolexecutor.threaddemo;

/**
 * 描述：异常的线程
 * 
 * @author BrokenColor
 * @date 2018年11月17日
 */
public class RunnableTest2 implements Runnable {

	@Override
	public void run() {
		System.out.println("begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
		String abc = null;
		abc.indexOf(0);
		System.out.println("end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
	}

}
