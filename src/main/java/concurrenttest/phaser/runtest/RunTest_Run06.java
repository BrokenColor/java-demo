package concurrenttest.phaser.runtest;

import concurrenttest.phaser.serviceImpl.PrintTools01;
import concurrenttest.phaser.serviceImpl.Service_Run06;
import concurrenttest.phaser.thread.ThreadA;
import concurrenttest.phaser.thread.ThreadB;
import concurrenttest.phaser.thread.ThreadC;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.arrive();
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Run06 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(4);
        //PrintTools01PrintTools测试arriveAndDeregister();方法
        Service_Run06 service  = new Service_Run06(phaser);

        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        threadB.start();

        ThreadC threadC = new ThreadC(service);
        threadC.setName("C");
        threadC.start();
    }
}
