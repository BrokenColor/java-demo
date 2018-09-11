package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.ThreadA;
import concurrenttest.semaphoredemo.pojo.ThreadB;
import concurrenttest.semaphoredemo.serviceImp.Semaphore_tryAcquire;

/**
 * tryAcquire() 尝试得获取x许可
 *
 * @author bc
 * @data 2018年9月10日
 */
public class RunTest_tryAcquire {

    public static void main(String[] args) {

        Semaphore_tryAcquire service = new Semaphore_tryAcquire();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
