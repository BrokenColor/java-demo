package concurrenttest.semaphoredemo;
/**
 * 线程C类
 * @author bc
 * @data 2018年9月7日
 */
public class ThreadC extends Thread {
	
	private SemaphoreService service;
	
	public ThreadC(SemaphoreService service){
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		service.testMethod();
	}
	
}
