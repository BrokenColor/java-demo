package concurrenttest.phaser.thread;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
             * 等待该移相器的相位从给定的相位值推进，如果在等待时 中断则抛出 InterruptedException ，
             * 或者如果当前相位不等于给定相位值，则立即返回，或者该相位器被终止。
             */
//            phaser.awaitAdvanceInterruptibly(0);
            //如果当前相位不等于给定相位值，则继续执行下面的代码
//            phaser.awaitAdvanceInterruptibly(10);
            //如果在指定时间相位值未变化，则抛出异常
            phaser.awaitAdvanceInterruptibly(0,5,TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + " end phaser value=" + phaser.getPhase());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
