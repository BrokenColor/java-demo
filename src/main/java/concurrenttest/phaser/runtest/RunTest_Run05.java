package concurrenttest.phaser.runtest;

import java.util.concurrent.Phaser;

/**
 * 描述:Phaser类测试
 * phaser.onAdvance(); 在即将进行的相位提前执行动作的可覆盖方法，并控制终止。
 *
 * @author bc
 * @create 2018-10-02 12:28
 */
public class RunTest_Run05 {
    
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2) {
            //在即将进行的相位提前执行动作的可覆盖方法，并控制终止。
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("到达了，未通过！phaser=" + phase + " registeredParties=" + registeredParties);
                return super.onAdvance(phase, registeredParties);
            }
        };
        System.out.println("A1 getPhase:" + phaser.getPhase() + //当前相位数
                " getRegisteredParties:" + phaser.getRegisteredParties() +//在此移动设备上注册的各方数量
                " getArrivedParties:" + phaser.getArrivedParties());//在此移相器的当前阶段到达的已注册方的数量
        //抵达这个移相器，而不用等待别人到达。
        phaser.arrive();
        System.out.println("A1 getPhase:" + phaser.getPhase() +
                " getRegisteredParties:" + phaser.getRegisteredParties() +
                " getArrivedParties:" + phaser.getArrivedParties());
        //
        System.out.println("A2 getPhase:" + phaser.getPhase() + //当前相位数
                " getRegisteredParties:" + phaser.getRegisteredParties() +//在此移动设备上注册的各方数量
                " getArrivedParties:" + phaser.getArrivedParties());//在此移相器的当前阶段到达的已注册方的数量
        phaser.arrive();
        System.out.println("A2 getPhase:" + phaser.getPhase() +
                " getRegisteredParties:" + phaser.getRegisteredParties() +
                " getArrivedParties:" + phaser.getArrivedParties());

        System.out.println("B1 getPhase:" + phaser.getPhase() + //当前相位数
                " getRegisteredParties:" + phaser.getRegisteredParties() +//在此移动设备上注册的各方数量
                " getArrivedParties:" + phaser.getArrivedParties());//在此移相器的当前阶段到达的已注册方的数量
        phaser.arrive();
        System.out.println("B1 getPhase:" + phaser.getPhase() +
                " getRegisteredParties:" + phaser.getRegisteredParties() +
                " getArrivedParties:" + phaser.getArrivedParties());
        //
        System.out.println("B2 getPhase:" + phaser.getPhase() + //当前相位数
                " getRegisteredParties:" + phaser.getRegisteredParties() +//在此移动设备上注册的各方数量
                " getArrivedParties:" + phaser.getArrivedParties());//在此移相器的当前阶段到达的已注册方的数量
        phaser.arrive();
        System.out.println("B2 getPhase:" + phaser.getPhase() +
                " getRegisteredParties:" + phaser.getRegisteredParties() +
                " getArrivedParties:" + phaser.getArrivedParties());

        System.out.println("C1 getPhase:" + phaser.getPhase() + //当前相位数
                " getRegisteredParties:" + phaser.getRegisteredParties() +//在此移动设备上注册的各方数量
                " getArrivedParties:" + phaser.getArrivedParties());//在此移相器的当前阶段到达的已注册方的数量
        phaser.arrive();
        System.out.println("C1 getPhase:" + phaser.getPhase() +
                " getRegisteredParties:" + phaser.getRegisteredParties() +
                " getArrivedParties:" + phaser.getArrivedParties());
        //
        System.out.println("C2 getPhase:" + phaser.getPhase() + //当前相位数
                " getRegisteredParties:" + phaser.getRegisteredParties() +//在此移动设备上注册的各方数量
                " getArrivedParties:" + phaser.getArrivedParties());//在此移相器的当前阶段到达的已注册方的数量
        phaser.arrive();
        System.out.println("C2 getPhase:" + phaser.getPhase() +
                " getRegisteredParties:" + phaser.getRegisteredParties() +
                " getArrivedParties:" + phaser.getArrivedParties());
    }
}
