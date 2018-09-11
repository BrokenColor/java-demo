package concurrenttest.semaphoredemo.serviceImp;

import concurrenttest.semaphoredemo.service.SemaphoreService;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * tryAcquire() 尝试得获取x许可
 *
 * @author bc
 * @data 2018年9月9日
 */
public class SemaphoreService_6 implements SemaphoreService {

    //类Semaphore的参数代表同一时间内，最多允许多少个线程执行
//    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphore = new Semaphore(3);

    public void testMethod() {
        try {
//          if (semaphore.tryAcquire(3)) {    //尝试得获取x许可
//            if (semaphore.tryAcquire(1, TimeUnit.SECONDS)) {//在指定时间内尝试获取许可，如果获取不到则返回false
            if (semaphore.tryAcquire(3,1, TimeUnit.SECONDS)) {//在指定时间内尝试获取x许可，如果获取不到则返回false
                System.out.println("Name:" + Thread.currentThread().getName() + "首次进入");
                for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
                    String newString = new String();
                    Math.random();
//                System.out.println(Thread.currentThread().getName()+"正在运行中...");
                }
//                semaphore.release();
                  semaphore.release(3);
            } else {
                System.out.println("Name:" + Thread.currentThread().getName() + "未进入");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
