package concurrenttest.phaser.runtest;

import concurrenttest.phaser.serviceImpl.PrintTools;
import concurrenttest.phaser.thread.ThreadA;
import concurrenttest.phaser.thread.ThreadB;
import concurrenttest.phaser.thread.ThreadC;

import java.util.concurrent.Phaser;

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
        PrintTools.phaser = phaser;

        ThreadA threadA = new ThreadA(phaser);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(phaser);
        threadB.setName("B");
        threadB.start();

        ThreadC threadC = new ThreadC(phaser);
        threadC.setName("C");
        threadC.start();
    }
}
