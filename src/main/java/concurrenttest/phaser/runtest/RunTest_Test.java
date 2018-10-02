package concurrenttest.phaser.runtest;

import concurrenttest.phaser.thread.ThreadTest;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.getPhase(); 返回当前相位数。
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Test {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);

        ThreadTest test = new ThreadTest(phaser);
        test.start();

    }
}
