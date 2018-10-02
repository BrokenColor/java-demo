package concurrenttest.phaser.serviceImpl;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 *  phaser.arriveAndAwaitAdvance();到达这个移相器，等待其他人。
 * @author bc
 * @create 2018-10-02 12:36
 */
public class PrintTools {
    public static Phaser phaser;

    public static void methodA() {
        System.out.println(Thread.currentThread().getName() + " begin A1:" + System.currentTimeMillis());
        //到达这个移相器，等待其他人。
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " end A1:" + System.currentTimeMillis());

        System.out.println(Thread.currentThread().getName() + " begin A2:" + System.currentTimeMillis());
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " end A2:" + System.currentTimeMillis());
    }

    public static void methodB() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin B1:" + System.currentTimeMillis());
            Thread.sleep(5000);
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " end B1:" + System.currentTimeMillis());

            System.out.println(Thread.currentThread().getName() + " begin B2:" + System.currentTimeMillis());
            Thread.sleep(5000);
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " end B2:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
