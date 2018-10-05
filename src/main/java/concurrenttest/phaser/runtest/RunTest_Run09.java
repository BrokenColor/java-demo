package concurrenttest.phaser.runtest;

import concurrenttest.phaser.thread.ThreadTestB;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.awaitAdvanceInterruptibly();
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Run09 {
    public static void main(String[] args) throws InterruptedException {

        Phaser phaser = new Phaser(2);

        ThreadTestB b = new ThreadTestB(phaser);
        b.setName("B");
        b.start();
        //此处的相位值为0，之后再走过屏障相位值才会+1
        Thread.sleep(1000);
        phaser.arrive();
        Thread.sleep(1000);
        phaser.arrive();
        //给定的时间还未到，提前进行了中断
//        b.interrupt();
        System.out.println(System.currentTimeMillis());

    }
}
