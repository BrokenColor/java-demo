/**
 *
 */
package concurrenttest.countdownlatch.runtest;

import concurrenttest.countdownlatch.thread.Thread_02;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 类test
 * 允许一个或多个线程等待直到在其他线程中执行的一组操作完成的同步辅助。
 *
 * @author bc
 * @data 2018年9月20日
 */
public class RunTest_02 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch maxRuner = new CountDownLatch(10);
        Thread_02[] tArray = new Thread_02[Integer.parseInt("" + maxRuner.getCount())];
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new Thread_02(maxRuner);
            tArray[i].setName("线程" + (i + 1));
            tArray[i].start();
        }
        maxRuner.await();
        System.out.println("都回来了");
    }

}
