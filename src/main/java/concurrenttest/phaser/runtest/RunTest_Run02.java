package concurrenttest.phaser.runtest;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.register(); 添加一个新的unririved party到这个移相器。
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Run02 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        //返回在此移动设备上注册的各方数量。
        System.out.println("getRegisteredParties: " + phaser.getRegisteredParties());
        //添加一个新的unririved party到这个移相器。
        phaser.register();
        System.out.println("getRegisteredParties: " + phaser.getRegisteredParties());
        phaser.register();
        System.out.println("getRegisteredParties: " + phaser.getRegisteredParties());
        phaser.register();
        System.out.println("getRegisteredParties: " + phaser.getRegisteredParties());
        phaser.register();
        System.out.println("getRegisteredParties: " + phaser.getRegisteredParties());

    }
}
