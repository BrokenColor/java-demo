package concurrenttest.phaser.thread;

import java.util.concurrent.Phaser;

/**
 * 描述: phaser.arriveAndAwaitAdvance();
 *
 * @author bc
 * @create 2018-10-02 12:35
 */
public class ThreadTestA extends Thread {

    private Phaser phaser;

    public ThreadTestA(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName() + " begin");
            //传入的phase值和当前的相位值相同则在屏障出等待，否则继续
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " end phaser value=" + phaser.getPhase());
    }
}
