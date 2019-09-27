package basetest.threadTest;

import toolUtil.ThreadTools;

/**
 * Description: 两种创建线程方式
 * <p>
 * Author: GWL
 * Date: Create in 16:04 2019/9/26
 */
public class ThreadCreationCmp {
    public static void main(String[] args) {
        Thread t;
        CountingTask ct = new CountingTask();
        //获取处理器个数
        final int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("processors:" + processors);
        for (int i = 0; i < 2 * processors; i++) {
            //通过实现接口的实例来创建线程
            t = new Thread(ct);
            t.start();
        }
        for (int i = 0; i < 2 * processors; i++) {
            //以子类的方式创建线程
            t = new CountingThread();
            t.start();
        }
    }

    static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    static class CountingTask implements Runnable {
        Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("CounttingTask:" + Thread.currentThread().getName() + " " + counter.getCount());
        }
        void doSomething(){
            ThreadTools.randomPause(80);
        }
    }

    static class CountingThread extends Thread {
        Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("CounttingThread:" + Thread.currentThread().getName() + " " + counter.getCount());
        }
        void doSomething(){
            ThreadTools.randomPause(80);
        }
    }

}