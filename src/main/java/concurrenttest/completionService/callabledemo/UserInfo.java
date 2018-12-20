package concurrenttest.completionService.callabledemo;

/**
 * 描述：user实体类
 * 
 * @author BrokenColor
 * @date 2018年12月20日
 */
public class UserInfo {
	private String username;
	private String password;
	
	public UserInfo() {
		super();
	}

	/**
	 * @param username
	 * @param password
	 */
	public UserInfo(String username, String password) {
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
