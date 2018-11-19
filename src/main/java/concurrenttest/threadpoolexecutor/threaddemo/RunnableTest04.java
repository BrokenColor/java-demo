package concurrenttest.threadpoolexecutor.threaddemo;

/**
 * 描述：线程
 * 
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunnableTest04 implements Runnable {

	private String username;

	public RunnableTest04(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void run() {
		System.out.println(username+":"+Thread.currentThread().getName()+" run "+System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
