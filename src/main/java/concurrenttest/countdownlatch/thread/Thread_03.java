package concurrenttest.countdownlatch.thread;

import concurrenttest.countdownlatch.service.Service_03;

/**
 * 描述:
 *
 * @author bc
 * @create 2018-09-28 9:40
 */
public class Thread_03 extends Thread {
    private Service_03 service;

    public Thread_03(Service_03 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
