package concurrenttest.phaser.runtest;

import concurrenttest.phaser.thread.ThreadTest;
import concurrenttest.phaser.thread.ThreadTest01;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.awaitAdvance();
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Test01 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);

        ThreadTest a = new ThreadTest(phaser);
        a.setName("A");
        a.start();

        ThreadTest b = new ThreadTest(phaser);
        b.setName("B");
        b.start();

        ThreadTest01 c = new ThreadTest01(phaser);
        c.setName("C");
        c.start();

        ThreadTest d = new ThreadTest(phaser);
        d.setName("D");
        d.start();

    }
}
