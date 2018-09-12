/**
 * 
 */
package concurrenttest.semaphoredemo.pojo;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * 线程 Exchanger A
 * @author bc
 * @data 2018年9月12日
 */
public class Thread_ExchangerA extends Thread{

	private Exchanger<String> exchanger;
	
	public Thread_ExchangerA(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		try {
			//exchange()具有阻塞的特点，如果没有其他线程，则一直阻塞等待
			System.out.println("线程A中得到线程B的值="+exchanger.exchange("中国人A"));
			//设置超时参数
//			System.out.println("线程A中得到线程B的值="+exchanger.exchange("中国人A",5,TimeUnit.SECONDS));
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}
