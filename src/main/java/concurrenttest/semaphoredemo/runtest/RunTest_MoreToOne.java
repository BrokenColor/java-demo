package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.ThreadA;
import concurrenttest.semaphoredemo.pojo.ThreadB;
import concurrenttest.semaphoredemo.pojo.ThreadC;
import concurrenttest.semaphoredemo.serviceImp.Semaphore_MoreToOne;

/**
 * 描述:
 *
 * @author bc
 * @create 2018-09-11 15:31
 */
public class RunTest_MoreToOne {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore_MoreToOne service = new Semaphore_MoreToOne();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        ThreadB b = new ThreadB(service);
        b.setName("B");
        ThreadC c = new ThreadC(service);
        c.setName("C");
        a.start();
        b.start();
        c.start();
    }
}
