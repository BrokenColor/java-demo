package concurrenttest.phaser.serviceImpl;

import concurrenttest.phaser.service.PrintTools;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.arrive();
 *
 * @author bc
 * @create 2018-10-02 12:36
 */
public class Service_Run06 implements PrintTools {

    public Phaser phaser;

    public Service_Run06(Phaser phaser) {
        this.phaser = phaser;
    }

    public void methodA() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin A1=" + System.currentTimeMillis());
            Thread.sleep(5000);
            //返回在此移相器的当前阶段到达的已注册方的数量。
            System.out.println(Thread.currentThread().getName() + " A1 getArrivedParties:" + phaser.getArrivedParties());
            //到达这个移相器，等待其他人。
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " end A1=" + System.currentTimeMillis());

            System.out.println(Thread.currentThread().getName() + " begin A2=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " A2 getArrivedParties:" + phaser.getArrivedParties());
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " end A2=" + System.currentTimeMillis());

            System.out.println(Thread.currentThread().getName() + " begin A3=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " A3 getArrivedParties:" + phaser.getArrivedParties());
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " end A3=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {

        System.out.println(Thread.currentThread().getName() + " begin B1:" + System.currentTimeMillis());
        //返回在此移相器的当前阶段到达的已注册方的数量。
        System.out.println(Thread.currentThread().getName() + " B1 getArrivedParties:" + phaser.getArrivedParties());
        //抵达这个移相器，而不用等待别人到达。
        phaser.arrive();
        System.out.println(Thread.currentThread().getName() + " end B1:" + System.currentTimeMillis());

        System.out.println(Thread.currentThread().getName() + " begin B2:" + System.currentTimeMillis());
        //返回在此移相器的当前阶段到达的已注册方的数量。
        System.out.println(Thread.currentThread().getName() + " B2 getArrivedParties:" + phaser.getArrivedParties());
        //抵达这个移相器，而不用等待别人到达。
        phaser.arrive();
        System.out.println(Thread.currentThread().getName() + " end B2:" + System.currentTimeMillis());

        System.out.println(Thread.currentThread().getName() + " begin B3:" + System.currentTimeMillis());
        //返回在此移相器的当前阶段到达的已注册方的数量。
        System.out.println(Thread.currentThread().getName() + " B3 getArrivedParties:" + phaser.getArrivedParties());
        //抵达这个移相器，而不用等待别人到达。
        phaser.arrive();
        System.out.println(Thread.currentThread().getName() + " end B3:" + System.currentTimeMillis());
    }
}
