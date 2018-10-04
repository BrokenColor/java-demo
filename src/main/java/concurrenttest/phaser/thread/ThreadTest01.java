package concurrenttest.phaser.thread;

import java.util.concurrent.Phaser;

/**
 * 描述: phaser.awaitAdvance();
 * 等待该相位器的相位从给定相位值前进，如果当前相位不等于给定相位值，则立即返回，或者该相位器被终止。
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
            //等待该相位器的相位从给定相位值前进，如果当前相位不等于给定相位值，则立即返回，或者该相位器被终止。
            phaser.awaitAdvance(0);
            System.out.println(Thread.currentThread().getName() + " end phaser value=" + phaser.getPhase());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
