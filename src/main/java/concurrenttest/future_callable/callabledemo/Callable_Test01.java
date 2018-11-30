package concurrenttest.future_callable.callabledemo;

import java.util.concurrent.Callable;

import concurrenttest.future_callable.entity.Userinfo;

/**
 * 描述：Callable_Test 
 * return "返回值 年龄是：" + age;
 * 
 * @author BrokenColor
 * @date 2018年11月21日
 */
public class Callable_Test01 implements Callable<String> {

	private Userinfo userinfo;

	public Callable_Test01(Userinfo userinfo) {
		super();
		this.userinfo = userinfo;
	}

	/*
	 * retrun String
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		Thread.sleep(8000);
		return "返回值 是：" + userinfo.getUsername();
	}

}
