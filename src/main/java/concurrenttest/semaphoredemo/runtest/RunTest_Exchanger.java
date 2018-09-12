/**
 * 
 */
package concurrenttest.semaphoredemo.runtest;

import java.util.concurrent.Exchanger;

import concurrenttest.semaphoredemo.pojo.Thread_ExchangerA;
import concurrenttest.semaphoredemo.pojo.Thread_ExchangerB;


/**
 * 线程 Exchanger test
 * exchange()具有阻塞的特点，如果没有其他线程，则一直阻塞等待
 * @author bc
 * @data 2018年9月12日
 */
public class RunTest_Exchanger {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		
		Thread_ExchangerA threadA = new Thread_ExchangerA(exchanger);
		threadA.start();
		Thread_ExchangerB threadB = new Thread_ExchangerB(exchanger);
		threadB.start();
		
		System.out.println("main end");
	}

}
