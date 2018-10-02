package concurrenttest.phaser.thread;

import concurrenttest.phaser.serviceImpl.PrintTools;

import java.util.concurrent.Phaser;

/**
 * 描述:
 *
 * @author bc
 * @create 2018-10-02 12:35
 */
public class ThreadB extends Thread {
    private Phaser phaser;

    public ThreadB(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        PrintTools.methodA();
    }
}
