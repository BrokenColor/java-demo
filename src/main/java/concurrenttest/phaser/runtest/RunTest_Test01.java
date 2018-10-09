package concurrenttest.phaser.runtest;

import java.util.concurrent.Phaser;

import concurrenttest.phaser.thread.ThreadTest01;
import concurrenttest.phaser.thread.ThreadTestA;

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

        ThreadTestA a = new ThreadTestA(phaser);
        a.setName("A");
        a.start();

        ThreadTestA b = new ThreadTestA(phaser);
        b.setName("B");
        b.start();

        ThreadTest01 c = new ThreadTest01(phaser);
        c.setName("C");
        c.start();

        ThreadTestA d = new ThreadTestA(phaser);
        d.setName("D");
        d.start();

    }
}
