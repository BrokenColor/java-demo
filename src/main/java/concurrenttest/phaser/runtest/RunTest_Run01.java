package concurrenttest.phaser.runtest;

import concurrenttest.phaser.serviceImpl.Service_Run01;
import concurrenttest.phaser.thread.ThreadTest;
import concurrenttest.phaser.thread.Thread_Run01;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.onAdvance(); 在即将进行的相位提前执行动作的可覆盖方法，并控制终止。
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Run01 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2){
            //在即将进行的相位提前执行动作的可覆盖方法，并控制终止。
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("onAdvance()被调用");
//                return true;
                return false;
            }
        };
        Service_Run01 service = new Service_Run01(phaser);
        Thread_Run01 A = new Thread_Run01(service);
        A.start();
        Thread_Run01 B = new Thread_Run01(service);
        B.start();

    }
}
