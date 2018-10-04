package concurrenttest.phaser.runtest;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.bulkRegister(); 添加给定数量的unririved party到这个移相器。
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Run03 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(10);
        //返回在此移动设备上注册的各方数量。
        System.out.println("getRegisteredParties: " + phaser.getRegisteredParties());
        //添加给定数量的unririved party到这个移相器。
        phaser.bulkRegister(10);
        System.out.println("getRegisteredParties: " + phaser.getRegisteredParties());
        phaser.bulkRegister(10);
        System.out.println("getRegisteredParties: " + phaser.getRegisteredParties());
        phaser.bulkRegister(10);
        System.out.println("getRegisteredParties: " + phaser.getRegisteredParties());
        phaser.bulkRegister(10);
        System.out.println("getRegisteredParties: " + phaser.getRegisteredParties());

    }
}
