package concurrenttest.phaser.thread;

import java.util.concurrent.Phaser;

/**
 * 描述: phaser.awaitAdvance();
 * 传入的phase值和当前的相位值相同则在屏障出等待，否则继续
 * @author bc
 * @create 2018-10-02 12:35
 */
public class ThreadTest01 extends Thread {

    private Phaser phaser;

    public ThreadTest01(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
//        try {
            System.out.println(Thread.currentThread().getName() + " begin phaser value=" + phaser.getPhase());
//            Thread.sleep(5000);
            //传入的phase值和当前的相位值相同则在屏障出等待，否则继续
            phaser.awaitAdvance(0);
            System.out.println(Thread.currentThread().getName() + " end phaser value=" + phaser.getPhase());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
