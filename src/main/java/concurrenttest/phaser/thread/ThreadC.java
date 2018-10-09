package concurrenttest.phaser.thread;

import concurrenttest.phaser.service.PrintTools;

/**
 * 描述:
 *
 * @author bc
 * @create 2018-10-02 12:35
 */
public class ThreadC extends Thread {
    private PrintTools service;

    public ThreadC(PrintTools service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodB();
    }
}
