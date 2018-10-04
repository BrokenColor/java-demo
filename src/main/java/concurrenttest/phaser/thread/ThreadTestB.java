package concurrenttest.phaser.thread;

import java.util.concurrent.Phaser;

/**
 * 描述: phaser.awaitAdvanceInterruptibly();
 * 等待该移相器的相位从给定的相位值推进，如果在等待时 InterruptedException则抛出 InterruptedException ，
 * 或者如果当前相位不等于给定相位值，则立即返回，或者该相位器被终止。
 *
 * @author bc
 * @create 2018-10-02 12:35
 */
public class ThreadTestB extends Thread {

    private Phaser phaser;

    public ThreadTestB(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin");
//            Thread.sleep(5000);
            /**
             * 等待该移相器的相位从给定的相位值推进，如果在等待时 InterruptedException则抛出 InterruptedException ，
             * 或者如果当前相位不等于给定相位值，则立即返回，或者该相位器被终止。
             */
            phaser.awaitAdvanceInterruptibly(0);
            System.out.println(Thread.currentThread().getName() + " end phaser value=" + phaser.getPhase());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
