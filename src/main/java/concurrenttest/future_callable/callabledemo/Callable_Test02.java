package concurrenttest.future_callable.callabledemo;

import java.util.concurrent.Callable;

/**
 * 描述：Callable_Test return "返回值 年龄是：" + age;
 * 
 * @author BrokenColor
 * @date 2018年11月21日
 */
public class Callable_Test02 implements Callable<String> {

	private int age;

	public Callable_Test02(int age) {
		super();
		this.age = age;
	}

	/*
	 * retrun String
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		int i = 0;
		while (i == 0) {
			if (Thread.currentThread().isInterrupted()) {
				throw new InterruptedException();
			}
			System.out.println("正在运行");
		}
		return "返回值 年龄是：" + age;
	}

}
