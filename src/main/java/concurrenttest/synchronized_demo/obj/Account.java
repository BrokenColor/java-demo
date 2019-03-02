package concurrenttest.synchronized_demo.obj;

/**
 * 描述：
 * 
 * @author BrokenColor
 * @date 2019年3月2日
 */
public class Account {
	String name;
	float amount;
	
	/**
	 * @param name
	 * @param amount
	 */
	public Account(String name, float amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	
	/**
	 * 
	 */
	public void deposit(float amt) {
		amount += amt;
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void withdraw(float amt) {
		amount -= amt;
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public float getBalance() {
		return amount;

	}
	
}
