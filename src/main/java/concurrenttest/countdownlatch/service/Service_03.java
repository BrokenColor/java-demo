package concurrenttest.countdownlatch.service;

import java.util.concurrent.CountDownLatch;

/**
 * 描述:
 *
 * @author bc
 * @create 2018-09-28 9:35
 */
public class Service_03 {

    CountDownLatch down = new CountDownLatch(1);

    public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "准备");
            down.await();
            System.out.println(Thread.currentThread().getName() + "结束");
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    public void downMethod() {
        System.out.println("开始");
        down.countDown();
    }

}
