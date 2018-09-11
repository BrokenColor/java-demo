package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.ThreadA;
import concurrenttest.semaphoredemo.serviceImp.Semaphore_Acquire;

/**
 * test类
 *
 * @author bc
 * @data 2018年9月8日
 */
public class RunTest_Acquire {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore_Acquire service = new Semaphore_Acquire();

        ThreadA[] a = new ThreadA[10];
        for (int i = 0; i < 10; i++) {
            a[i] = new ThreadA(service);
            a[i].start();
        }
    }

}
