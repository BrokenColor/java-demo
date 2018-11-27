package concurrenttest.future_callable.callabledemo;

import concurrenttest.future_callable.entity.Userinfo;

/**
 * 描述：userinfo对象
 * 
 * @author BrokenColor
 * @date 2018年11月22日
 */
public class Runnable_Test implements Runnable{
	private Userinfo userinfo;
	
	/**
	 * @param userinfo
	 */
	public Runnable_Test(Userinfo userinfo) {
		super();
		this.userinfo = userinfo;
	}


	@Override
	public void run() {
		userinfo.setUsername("username");
		userinfo.setPassword("password");
	}

}
