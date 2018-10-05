package concurrenttest.phaser.runtest;

import concurrenttest.phaser.thread.ThreadTestA;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * 逻辑上控制phaser类的运行时机
 *
 * @author bc
 * @create 2018-10-05 12:28
 */
public class RunTest_Run11 {
    public static void main(String[] args) throws InterruptedException {

        Phaser phaser = new Phaser(3);
        //添加一个新的unririved party到这个移相器。
        phaser.register();
        for (int i = 0; i < 3; i++) {
            ThreadTestA a = new ThreadTestA(phaser);
            a.start();
        }
        Thread.sleep(5000);
        //到达这个移相器并从其中注销，而无需等待别人到达。
        phaser.arriveAndDeregister();
    }
}
