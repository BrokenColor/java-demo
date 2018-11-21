package concurrenttest.future_callable.callabledemo;

import java.util.concurrent.Callable;

/**
 * 描述：Callable_Test 
 * return "返回值 年龄是：" + age;
 * 
 * @author BrokenColor
 * @date 2018年11月21日
 */
public class Callable_Test implements Callable<String> {

	private int age;

	public Callable_Test(int age) {
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
		Thread.sleep(8000);
		return "返回值 年龄是：" + age;
	}

}
