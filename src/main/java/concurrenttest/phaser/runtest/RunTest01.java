package concurrenttest.phaser.runtest;

import java.util.concurrent.Phaser;

import concurrenttest.phaser.serviceImpl.PrintTools01;
import concurrenttest.phaser.thread.ThreadA;
import concurrenttest.phaser.thread.ThreadB;
import concurrenttest.phaser.thread.ThreadC;

/**
 * 描述:Phaser类测试
 * phaser.arriveAndAwaitAdvance();
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest01 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        //PrintTools01PrintTools测试arriveAndDeregister();方法
        PrintTools01 printTools01  = new PrintTools01(phaser);

        ThreadA threadA = new ThreadA(printTools01);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(printTools01);
        threadB.setName("B");
        threadB.start();

        ThreadC threadC = new ThreadC(printTools01);
        threadC.setName("C");
        threadC.start();
    }
}
