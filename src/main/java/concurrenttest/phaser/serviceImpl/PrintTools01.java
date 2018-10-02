package concurrenttest.phaser.serviceImpl;

import concurrenttest.phaser.service.PrintTools;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.arriveAndDeregister();到达这个移相器并从其中注销，而无需等待别人到达。
 *
 * @author bc
 * @create 2018-10-02 12:36
 */
public class PrintTools01 implements PrintTools {

    public Phaser phaser;

    public PrintTools01(Phaser phaser) {
        this.phaser = phaser;
    }

    public void methodA() {
        System.out.println(Thread.currentThread().getName() + " begin A1=" + System.currentTimeMillis());
        //到达这个移相器，等待其他人。
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " end A1=" + System.currentTimeMillis());

        System.out.println(Thread.currentThread().getName() + " begin A2=" + System.currentTimeMillis());
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " end A2=" + System.currentTimeMillis());
    }

    public void methodB() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin B1:" + System.currentTimeMillis());
            Thread.sleep(5000);
            //返回在此移动设备上注册的各方数量。
            System.out.println("phaser.getRegisteredParties():" + phaser.getRegisteredParties());
            //到达这个移相器并从其中注销，而无需等待别人到达。
            phaser.arriveAndDeregister();
            System.out.println("phaser.getRegisteredParties():" + phaser.getRegisteredParties());
            System.out.println(Thread.currentThread().getName() + " end B1:" + System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
