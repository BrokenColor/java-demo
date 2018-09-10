package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.ThreadA;
import concurrenttest.semaphoredemo.serviceImp.SemaphoreService_1;

/**
 * test类
 *
 * @author bc
 * @data 2018年9月8日
 */
public class RunTest_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SemaphoreService_1 service = new SemaphoreService_1();

        ThreadA[] a = new ThreadA[10];
        for (int i = 0; i < 10; i++) {
            a[i] = new ThreadA(service);
            a[i].start();
        }
    }

}
