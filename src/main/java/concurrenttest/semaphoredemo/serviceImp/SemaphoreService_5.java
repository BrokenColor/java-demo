package concurrenttest.semaphoredemo.serviceImp;

import concurrenttest.semaphoredemo.service.SemaphoreService;

import java.util.concurrent.Semaphore;

/**
 * 公平信号量得测试
 *
 * @author bc
 * @data 2018年9月9日
 */
public class SemaphoreService_5 implements SemaphoreService {

    private boolean isFair = false;//fair 是否公平信号量
    //类Semaphore的参数代表同一时间内，最多允许多少个线程执行
    private Semaphore semaphore = new Semaphore(1, isFair);

    public void testMethod() {
        try {
            semaphore.acquire();//参数表示每次调用1次此方法，就是用x个许可
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
