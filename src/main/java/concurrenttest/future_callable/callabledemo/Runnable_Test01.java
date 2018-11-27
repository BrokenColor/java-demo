package concurrenttest.future_callable.callabledemo;

/**
 * 描述：string name
 * 
 * @author BrokenColor
 * @date 2018年11月26日
 */
public class Runnable_Test01 implements Runnable {
	private String name;

	/**
	 * @param name
	 */
	public Runnable_Test01(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " running man");
	}

}
