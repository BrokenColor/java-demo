package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.serviceImp.SemaphoreService_3;

/**
 * 在等待许可的情况下不允许中断
 *
 * @author bc
 * @data 2018年9月10日
 */
public class RunTest_3 {

    public static void main(String[] args) {

        SemaphoreService_3 service = new SemaphoreService_3();

        service.testMethod();
    }
}
