package concurrenttest.phaser.runtest;

import concurrenttest.phaser.thread.ThreadTestA;
import concurrenttest.phaser.thread.ThreadTestB;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.forceTermination();
 *
 * @author bc
 * @create 2018-10-05 12:28
 */
public class RunTest_Run10 {
    public static void main(String[] args) throws InterruptedException {

        Phaser phaser = new Phaser(3);

        ThreadTestA a = new ThreadTestA(phaser);
        a.setName("A");
        a.start();
        ThreadTestA b = new ThreadTestA(phaser);
        b.setName("B");
        b.start();

        Thread.sleep(1000);
        //原本parties未达到3个，A,B线程需呈阻塞状态
        //forceTermination()方法使Phaser对象的屏障失效
        phaser.forceTermination();
        //判断Phaser对象是否已被注销
        System.out.println("isTerminated:"+phaser.isTerminated());
        //测试phaser对象是否可用
        Thread.sleep(10000);
        ThreadTestA c = new ThreadTestA(phaser);
        c.setName("C");
        c.start();

    }
}
