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
        System.out.println("A begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println("A end phaser value=" + phaser.getPhase());

        System.out.println("B begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println("B end phaser value=" + phaser.getPhase());

        System.out.println("C begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println("C end phaser value=" + phaser.getPhase());
    }
}
