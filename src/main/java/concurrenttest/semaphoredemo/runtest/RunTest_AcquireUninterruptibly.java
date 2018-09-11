package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.ThreadA;
import concurrenttest.semaphoredemo.pojo.ThreadB;
import concurrenttest.semaphoredemo.serviceImp.Semaphore_AcquireUninterruptibly;

/**
 * 在等待许可的情况下不允许中断
 *
 * @author bc
 * @data 2018年9月10日
 */
public class RunTest_AcquireUninterruptibly {

    public static void main(String[] args) throws InterruptedException{

        Semaphore_AcquireUninterruptibly service = new Semaphore_AcquireUninterruptibly();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(1000);
        b.interrupt();
        System.out.println("main中断了b");
    }
}
