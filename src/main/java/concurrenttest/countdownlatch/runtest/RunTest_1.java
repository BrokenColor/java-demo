package concurrenttest.countdownlatch.runtest;

import concurrenttest.countdownlatch.thread.Thread_1;

import java.util.concurrent.CountDownLatch;

/**
 * 描述:模拟运动员赛跑DEMO
 *
 * @author bc
 * @create 2018-09-28 10:49
 */
public class RunTest_1 {

    public static void main(String[] args) {
        try {
            CountDownLatch comingTag = new CountDownLatch(10);//裁判等待运动员到来
            CountDownLatch waitTag = new CountDownLatch(1);//等待裁判说准备开始
            CountDownLatch waitRunTag = new CountDownLatch(10);//等待起跑
            CountDownLatch beginTag = new CountDownLatch(1);//起跑
            CountDownLatch endTag = new CountDownLatch(10);//到达终点

            Thread_1[] arr = new Thread_1[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new Thread_1(comingTag, waitTag, waitRunTag, beginTag, endTag);
                arr[i].start();
            }

            System.out.println("裁判等待运动员到来");
            comingTag.await();
            System.out.println("裁判看到所有运动员都来了，巡视一下");
            Thread.sleep(5000);
            waitTag.countDown();
            System.out.println("各就各位！");
            waitRunTag.await();
            Thread.sleep(2000);
            System.out.println("发令枪响！");
            beginTag.countDown();
            endTag.await();
            System.out.println("所有运动员到了，统计结果");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
