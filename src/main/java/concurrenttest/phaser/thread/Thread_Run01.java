package concurrenttest.phaser.thread;

import concurrenttest.phaser.service.PrintTools;
import concurrenttest.phaser.serviceImpl.Service_Run01;

import java.util.concurrent.Phaser;

/**
 * 描述:
 *
 * @author bc
 * @create 2018-10-02 12:35
 */
public class Thread_Run01 extends Thread {

    private Service_Run01 service;

    public Thread_Run01(Service_Run01 service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodTest();
    }
}
