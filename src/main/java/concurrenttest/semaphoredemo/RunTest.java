package concurrenttest.semaphoredemo;
/**
 * test类
 * @author bc
 * @data 2018年9月7日
 */
public class RunTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SemaphoreService service = new SemaphoreService();
		
		ThreadA a = new ThreadA(service);
		a.setName("A");
		ThreadB b = new ThreadB(service);
		b.setName("B");
		ThreadC c = new ThreadC(service);
		c.setName("C");
		a.start();
		b.start();
		c.start();
	}

}
