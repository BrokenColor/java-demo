package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.ThreadA;
import concurrenttest.semaphoredemo.serviceImp.Semaphore_isFair;

/**
 * 公平信号量得测试（可能需要多运行几次才能看到）
 *
 * @author bc
 * @data 2018年9月10日
 */
public class RunTest_isFair {

    public static void main(String[] args) {

        Semaphore_isFair service = new Semaphore_isFair();

        ThreadA a = new ThreadA(service);
        a.start();

        ThreadA[] arr = new ThreadA[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = new ThreadA(service);
            arr[i].start();
        }
    }
}
