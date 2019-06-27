package concurrenttest.future_callable.callabledemo;

import java.util.concurrent.Callable;

/**
 * 描述：Callable_Test return "返回值 年龄是：" + name;
 * 
 * @author BrokenColor
 * @date 2018年11月21日
 */
public class Callable_Test00 implements Callable<String> {

	private String name;
	private long sleepValue;

	public Callable_Test00(String name, long sleepValue) {
		super();
		this.name = name;
		this.sleepValue = sleepValue;
	}

	/*
	 * retrun String
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		System.out.println("sleep " + sleepValue);
		Thread.sleep(sleepValue);
		return "返回值 年龄是：" + name;
	}

}
