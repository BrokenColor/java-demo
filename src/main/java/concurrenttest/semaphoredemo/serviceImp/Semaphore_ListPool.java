package concurrenttest.semaphoredemo.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建pool池
 * 同时有若干个线程可以访问池中的数据，但同时只有一个线程可以取得数据，使用完在放回池中
 * @author bc
 * @data 2018年9月9日
 */
public class Semaphore_ListPool {

    private int poolMaxSize = 3;
    private int semaphorePermits = 5;
    private List<String> list = new ArrayList<String>();
    //类Semaphore的参数代表同一时间内，最多允许多少个线程执行
    private Semaphore semaphore = new Semaphore(semaphorePermits);
    //重入锁
    private ReentrantLock lock = new ReentrantLock();
    //Condition的作用是对锁进行更精确的控制
    private Condition condition  = lock.newCondition();

    public Semaphore_ListPool() {
    	super();
    	for (int i = 0; i < poolMaxSize; i++) {
			list.add("东野圭吾："+(i+1));
		}
    }
    
    public String get() {
    	String getString = null;
    	try {
			semaphore.acquire();
			lock.lock();
			while(list.size() == 0) {
				// 造成当前线程在接到信号或被中断之前一直处于等待状态。
				condition.await();
			}
			getString = list.remove(0);
			lock.unlock();
		} catch (Exception e) {
			e.getStackTrace();
		}
    	return getString;
    }
    
    public void put(String stringValue) {
        lock.lock();
        list.add(stringValue);
        // 唤醒所有等待线程。
        condition.signalAll();
        lock.unlock();
        semaphore.release();
    }
}
