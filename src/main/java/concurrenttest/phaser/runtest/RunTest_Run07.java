package concurrenttest.phaser.runtest;

import concurrenttest.phaser.thread.ThreadTest01;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.awaitAdvance();
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Run07 {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(3);

        ThreadTest01 a = new ThreadTest01(phaser);
        a.setName("A");
        a.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.interrupt();
        System.out.println("中断了");

    }
}
