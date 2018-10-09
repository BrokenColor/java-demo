package concurrenttest.phaser.serviceImpl;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.arriveAndDeregister();到达这个移相器并从其中注销，而无需等待别人到达。
 *
 * @author bc
 * @create 2018-10-02 12:36
 */
public class Service_Run01 {

    public Phaser phaser;

    public Service_Run01(Phaser phaser) {
        this.phaser = phaser;
    }

    public void methodTest() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin A1:" + System.currentTimeMillis());
            if (Thread.currentThread().getName().equals("Thread-1")){
                Thread.sleep(5000);
            }
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " end A1:" + System.currentTimeMillis());
            //--
            System.out.println(Thread.currentThread().getName() + " begin B1:" + System.currentTimeMillis());
            if (Thread.currentThread().getName().equals("Thread-1")){
                Thread.sleep(5000);
            }
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " end B1:" + System.currentTimeMillis());
            //--
            System.out.println(Thread.currentThread().getName() + " begin C1:" + System.currentTimeMillis());
            if (Thread.currentThread().getName().equals("Thread-1")){
                Thread.sleep(5000);
            }
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " end C1:" + System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
