package concurrenttest.semaphoredemo.serviceImp;

import concurrenttest.semaphoredemo.service.SemaphoreService;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多任务同时处理任务
 *	ReentrantLock(阻塞)
 * @author bc
 * @data 2018年9月9日
 */
public class Semaphore_MoreToOne implements SemaphoreService {

    //类Semaphore的参数代表同一时间内，最多允许多少个线程执行
    private Semaphore semaphore = new Semaphore(3);
    private ReentrantLock lock = new ReentrantLock();//重入锁

    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println("Name:" + Thread.currentThread().getName() + "-准备");
            lock.lock();
            System.out.println("begin: " + System.currentTimeMillis());
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"打印"+(i+1));
            }
            System.out.println("end: " + System.currentTimeMillis());
            lock.unlock();
            semaphore.release();
            System.out.println("Name:" + Thread.currentThread().getName() + "-结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
