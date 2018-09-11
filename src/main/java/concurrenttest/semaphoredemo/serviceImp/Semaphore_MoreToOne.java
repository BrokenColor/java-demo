package concurrenttest.semaphoredemo.serviceImp;

import concurrenttest.semaphoredemo.service.SemaphoreService;

import java.util.concurrent.Semaphore;

/**
 * tryAcquire() 尝试得获取x许可
 *
 * @author bc
 * @data 2018年9月9日
 */
public class Semaphore_MoreToOne implements SemaphoreService {

    //类Semaphore的参数代表同一时间内，最多允许多少个线程执行
//    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphore = new Semaphore(3);

    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println("Name:" + Thread.currentThread().getName() + "首次进入");
            for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
                String newString = new String();
                Math.random();
//                System.out.println(Thread.currentThread().getName()+"正在运行中...");
            }
//                semaphore.release();
            semaphore.release(3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
