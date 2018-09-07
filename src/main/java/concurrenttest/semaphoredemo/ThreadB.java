package concurrenttest.semaphoredemo;
/**
 * 线程B类
 * @author bc
 * @data 2018年9月7日
 */
public class ThreadB extends Thread {
	
	private SemaphoreService service;
	
	public ThreadB(SemaphoreService service){
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		service.testMethod();
	}
	
}
