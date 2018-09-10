package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.ThreadA;
import concurrenttest.semaphoredemo.serviceImp.SemaphoreService_4;

/**
 *  getQueueLength() 取得等待许可线程个数
 *  hasQueuedThreads() 是否有线程在等待这个许可
 *
 * @author bc
 * @data 2018年9月10日
 */
public class RunTest_4 {

    public static void main(String[] args) {

        SemaphoreService_4 service = new SemaphoreService_4();

        ThreadA a = new ThreadA(service);
        a.start();

        ThreadA[] arr = new ThreadA[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = new ThreadA(service);
            arr[i].start();
        }
    }
}
