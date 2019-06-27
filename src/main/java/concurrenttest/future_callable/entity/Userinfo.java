package concurrenttest.future_callable.entity;

/**
 * 描述：测试实体类
 * 
 * @author BrokenColor
 * @date 2018年11月22日
 */
public class Userinfo {
	private String username;
	private String password;

	public Userinfo() {
		super();
	}

	/**
	 * @param username
	 * @param password
	 */
	public Userinfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
