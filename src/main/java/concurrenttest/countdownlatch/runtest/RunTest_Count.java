/**
 * 
 */
package concurrenttest.countdownlatch.runtest;

import java.util.concurrent.CountDownLatch;

/**
 * getCount()方法 Returns the current count.
 * @author bc
 * @data 2018年9月28日
 */
public class RunTest_Count {

	public static void main(String[] args) {
		CountDownLatch count = new CountDownLatch(3);
		System.out.println("main getCount1="+count.getCount());
		count.countDown();
		System.out.println("main getCount2="+count.getCount());
		count.countDown();
		System.out.println("main getCount3="+count.getCount());
		count.countDown();
		System.out.println("main getCount4="+count.getCount());
		count.countDown();
		System.out.println("main getCount5="+count.getCount());
		count.countDown();
	}
}
