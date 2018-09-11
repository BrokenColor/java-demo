package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.serviceImp.Semaphore_DrainPermits;

/**
 * 在等待许可的情况下不允许中断
 *
 * @author bc
 * @data 2018年9月10日
 */
public class RunTest_DrainPermits {

    public static void main(String[] args) {

        Semaphore_DrainPermits service = new Semaphore_DrainPermits();

        service.testMethod();
    }
}
