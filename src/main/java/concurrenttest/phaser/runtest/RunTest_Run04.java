package concurrenttest.phaser.runtest;

import concurrenttest.phaser.thread.ThreadTest;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.getArrivedParties(); 返回在此移相器的当前阶段到达的已注册方的数量
 * phaser.getUnarrivedParties(); 返回尚未到达此移相器当前阶段的已注册方的数量。
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Run04 {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(7);
        //返回在此移动设备上注册的各方数量。
        System.out.println("Parties: " + phaser.getRegisteredParties());

        ThreadTest[] threads = new ThreadTest[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadTest(phaser);
            threads[i].start();
        }
        Thread.sleep(5000);
        //返回在此移相器的当前阶段到达的已注册方的数量
        System.out.println("到达了：" + phaser.getArrivedParties());
        //返回尚未到达此移相器当前阶段的已注册方的数量。
        System.out.println("未到达：" + phaser.getUnarrivedParties());

    }
}
