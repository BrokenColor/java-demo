package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.ThreadA;
import concurrenttest.semaphoredemo.pojo.ThreadB;
import concurrenttest.semaphoredemo.pojo.ThreadC;
import concurrenttest.semaphoredemo.serviceImp.SemaphoreService_6;

/**
 * tryAcquire() 尝试得获取x许可
 *
 * @author bc
 * @data 2018年9月10日
 */
public class RunTest_6 {

    public static void main(String[] args) {

        SemaphoreService_6 service = new SemaphoreService_6();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
