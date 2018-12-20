package concurrenttest.completionService.callabledemo;

/**
 * 描述：Runnable - userinfo实体
 * 
 * @author BrokenColor
 * @date 2018年12月20日
 */
public class Runable_TestUserinfo implements Runnable {
	private UserInfo userinfo;
	
	/**
	 * @param userinfo
	 */
	public Runable_TestUserinfo(UserInfo userinfo) {
		super();
		this.userinfo = userinfo;
	}

	@Override
	public void run() {
		userinfo.setUsername("username");
		userinfo.setPassword("password");
		System.out.println("run 运行了");
	}

}
