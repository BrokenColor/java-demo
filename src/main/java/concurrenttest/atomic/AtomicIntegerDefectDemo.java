package concurrenttest.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS ABA问题测试
 */
public class AtomicIntegerDefectDemo {
    public static void main(String[] args) {
        defectOfABA();
    }

    static void defectOfABA() {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        Thread thread1 = new Thread(() -> {
            final int currentValue = atomicInteger.get();
            System.out.println("currentValue:" + currentValue);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean casResult = atomicInteger.compareAndSet(1, 2);
            System.out.println(Thread.currentThread().getName()
                    + " ------ currentValue=" + currentValue
                    + ", finalValue=" + atomicInteger.get()
                    + ", compareAndSet Result=" + casResult);
        });
        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new Thread(() -> {
            int currentValue = atomicInteger.get();
            boolean casResult = atomicInteger.compareAndSet(1, 2);
            System.out.println(Thread.currentThread().getName()
                    + " ------ currentValue=" + currentValue
                    + ", finalValue=" + atomicInteger.get()
                    + ", compareAndSet Result=" + casResult);

            currentValue = atomicInteger.get();
            casResult = atomicInteger.compareAndSet(2, 1);
            System.out.println(Thread.currentThread().getName()
                    + " ------ currentValue=" + currentValue
                    + ", finalValue=" + atomicInteger.get()
                    + ", compareAndSet Result=" + casResult);
        });
        thread2.start();
    }
}
