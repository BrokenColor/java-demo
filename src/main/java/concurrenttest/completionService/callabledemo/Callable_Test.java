package concurrenttest.completionService.callabledemo;

import java.util.concurrent.Callable;

/**
 * 描述：Callable_Test return "返回值 年龄是：" + age;
 * 
 * @author BrokenColor
 * @date 2018年11月21日
 */
public class Callable_Test implements Callable<String> {

	private String name;
	private long sleepValue;

	public Callable_Test(String name, long sleepValue) {
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
		Thread.sleep(sleepValue);
		System.out.println("sleep " + sleepValue);
		return "返回值 年龄是：" + name;
	}

}
