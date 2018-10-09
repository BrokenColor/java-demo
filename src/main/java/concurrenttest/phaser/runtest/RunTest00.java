package concurrenttest.phaser.runtest;

import java.util.concurrent.Phaser;

import concurrenttest.phaser.serviceImpl.PrintTools00;
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
public class RunTest00 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        //PrintTools测试arriveAndAwaitAdvance();方法
        PrintTools00 printTools00  = new PrintTools00(phaser);

        ThreadA threadA = new ThreadA(printTools00);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(printTools00);
        threadB.setName("B");
        threadB.start();

        ThreadC threadC = new ThreadC(printTools00);
        threadC.setName("C");
        threadC.start();
    }
}
