package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.ThreadA;
import concurrenttest.semaphoredemo.serviceImp.Semaphore_MoreToOne;

/**
 * 描述:多任务同时处理任务
 *
 * @author bc
 * @create 2018-09-11 15:31
 */
public class RunTest_MoreToOne {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore_MoreToOne service = new Semaphore_MoreToOne();

        ThreadA[] arr = new ThreadA[10];
        for (int i = 0; i < arr.length; i++) {
        	arr[i] = new ThreadA(service);
        	arr[i].start();
        }
    }
}
