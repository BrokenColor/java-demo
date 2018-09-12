/**
 * 
 */
package concurrenttest.semaphoredemo.serviceImp;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现生产者与消费者模式 service
 * 
 * @author bc
 * @data 2018年9月12日
 */
public class Semaphore_Repast {

	volatile private Semaphore setSemaphore = new Semaphore(10);// 厨师
	volatile private Semaphore getSemaphore = new Semaphore(20);// 就餐者
	volatile private ReentrantLock lock = new ReentrantLock();// 重入锁
	volatile private Condition setCondition = lock.newCondition();
	volatile private Condition getCondition = lock.newCondition();
	// producePosition变量的含义是最多只有4个盒子存放菜品
	volatile private Object[] producePosition = new Object[4];

	private boolean isEmpty() {
		boolean isEmpty = true;
		for (int i = 0; i < producePosition.length; i++) {
			if (producePosition[i] != null) {
				isEmpty = false;
				break;
			}
		}
		return isEmpty;

	}

	private boolean isFull() {
		boolean isFull = true;
		for (int i = 0; i < producePosition.length; i++) {
			if (producePosition[i] == null) {
				isFull = false;
				break;
			}
		}
		return isFull;
	}

	public void set() {
		try {
			setSemaphore.acquire();// 允许同时最多有10个厨师进行生产
			lock.lock();
			while (isFull()) {
				// 生产者等待
				setCondition.await();
			}
			for (int i = 0; i < producePosition.length; i++) {
				if (producePosition[i] == null) {
					producePosition[i] = "天鹅肉";
					System.out.println(Thread.currentThread().getName() + "生产了：" + producePosition[i]);
					break;
				}
			}
			getCondition.signalAll();// 告诉消费者可以来取餐了
			lock.unlock();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			setSemaphore.release();
		}
	}

	public void get() {
		try {
			getSemaphore.acquire();//
			lock.lock();
			while (isEmpty()) {
				// 消费者等待
				getCondition.await();
			}
			for (int i = 0; i < producePosition.length; i++) {
				if (producePosition[i] != null) {
					System.out.println(Thread.currentThread().getName() + "消费了：" + producePosition[i]);
					producePosition[i] = null;
					break;
				}
			}
			setCondition.signalAll();// 告诉生产者可以来做饭了
			lock.unlock();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			getSemaphore.release();
		}
	}

}
