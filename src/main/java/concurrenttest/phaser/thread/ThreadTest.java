package concurrenttest.phaser.thread;

import java.util.concurrent.Phaser;

/**
 * 描述: phaser.getPhase(); 返回当前相位数。
 *
 * @author bc
 * @create 2018-10-02 12:35
 */
public class ThreadTest extends Thread {

    private Phaser phaser;

    public ThreadTest(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " A1 begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " A1 end phaser value=" + phaser.getPhase());

        System.out.println(Thread.currentThread().getName() + " A2 begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " A2 end phaser value=" + phaser.getPhase());

        System.out.println(Thread.currentThread().getName() + " A3 begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " A3 end phaser value=" + phaser.getPhase());
    }
}
