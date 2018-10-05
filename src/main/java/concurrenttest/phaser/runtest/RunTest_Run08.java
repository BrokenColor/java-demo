package concurrenttest.phaser.runtest;

import concurrenttest.phaser.thread.ThreadTest01;
import concurrenttest.phaser.thread.ThreadTestB;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.awaitAdvanceInterruptibly();
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Run08 {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(3);

        ThreadTestB b = new ThreadTestB(phaser);
        b.setName("B");
        b.start();

        try {
            Thread.sleep(5000);
            //如果线程在等待时中断,抛出InterruptedException
//            b.interrupt();
            System.out.println("中断B");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
