package basetest;

import java.util.HashMap;

/**
 * Description: 验证hashmap 非线程安全的
 * <p>
 * Author: GWL
 * Date: Create in 16:48 2019/9/23
 */
public class HashMapTest {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);
        threadA.start();
        threadB.start();
//        for (int i = 0; i < 5000; i++) {
//            new Thread(() -> {
//                System.out.println("lambda："+System.currentTimeMillis());
//            }).start();
//        }
    }
}

class MyService {
    public HashMap map = new HashMap();
}

class ThreadA extends Thread {
    MyService myService;

    public ThreadA(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            myService.map.put("ThreadA" + (i + 1), "ThreadA" + i + 1);
            System.out.println("ThreadA:" + (i + 1));
        }
    }
}

class ThreadB extends Thread {
    MyService myService;

    public ThreadB(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            myService.map.put("ThreadB" + (i + 1), "ThreadB" + i + 1);
            System.out.println("ThreadB:" + (i + 1));
        }
    }
}