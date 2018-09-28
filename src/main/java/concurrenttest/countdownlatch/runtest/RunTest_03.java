package concurrenttest.countdownlatch.runtest;

import concurrenttest.countdownlatch.service.Service_03;
import concurrenttest.countdownlatch.thread.Thread_03;

/**
 * 描述:
 *
 * @author bc
 * @create 2018-09-28 9:43
 */
public class RunTest_03 {

    public static void main(String[] args) throws InterruptedException {

        Service_03 service = new Service_03();

        Thread_03[] arr = new Thread_03[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = new Thread_03(service);
            arr[i].setName("线程" + (i + 1));
            arr[i].start();
        }

        Thread.sleep(5000);
        service.downMethod();
    }
}
