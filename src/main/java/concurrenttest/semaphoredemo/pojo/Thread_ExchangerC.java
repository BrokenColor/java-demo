/**
 * 
 */
package concurrenttest.semaphoredemo.pojo;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * 线程 Exchanger C
 * @author bc
 * @data 2018年9月12日
 */
public class Thread_ExchangerC extends Thread{

	private Exchanger<String> exchanger;
	
	public Thread_ExchangerC(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		try {
			//exchange()具有阻塞的特点，如果没有其他线程，则一直阻塞等待
			System.out.println("线程C中得到线程?的值="+exchanger.exchange("外国人"));
			//设置超时参数
//			System.out.println("线程B中得到线程A的值="+exchanger.exchange("中国人B",5,TimeUnit.SECONDS));
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}
