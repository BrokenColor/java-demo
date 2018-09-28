package concurrenttest.countdownlatch.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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
            System.out.println(Thread.currentThread().getName() + "准备 "+System.currentTimeMillis());
            down.await();
//          down.await(3,TimeUnit.SECONDS);//指定最大时间单位内进入WAITING状态，超过则自动唤醒
            System.out.println(Thread.currentThread().getName() + "结束 "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    public void downMethod() {
        System.out.println("开始");
        down.countDown();
    }

}
