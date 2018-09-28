package concurrenttest.countdownlatch.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 描述: 模拟运动员赛跑
 *
 * @author bc
 * @create 2018-09-28 10:10
 */
public class Thread_1 extends Thread {

    private CountDownLatch comingTag;//裁判等待运动员到来
    private CountDownLatch waitTag;//等待裁判说准备开始
    private CountDownLatch waitRunTag;//等待起跑
    private CountDownLatch beginTag;//起跑
    private CountDownLatch endTag;//到达终点

    public Thread_1(CountDownLatch comingTag, CountDownLatch waitTag, CountDownLatch waitRunTag,
                    CountDownLatch beginTag, CountDownLatch endTag) {
        super();
        this.comingTag = comingTag;
        this.waitTag = waitTag;
        this.waitRunTag = waitRunTag;
        this.beginTag = beginTag;
        this.endTag = endTag;
    }

    @Override
    public void run() {
        try {
            System.out.println("运动员正飞奔而来");
            Thread.sleep((int)(Math.random()*10000));
            System.out.println(Thread.currentThread().getName()+"到起跑点了");
            comingTag.countDown();
            System.out.println("等待裁判说准备");
            waitTag.await();
            System.out.println("各就各位！准备起跑的姿势");
            Thread.sleep((int)(Math.random()*10000));
            waitRunTag.countDown();
            beginTag.await();
            System.out.println(Thread.currentThread().getName()+"疯狂奔跑中");
            Thread.sleep((int)(Math.random()*10000));
            endTag.countDown();
            System.out.println(Thread.currentThread().getName()+"到达终点");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
