package basetest.threadTest;

/**
 * @Author: bc
 * @DateTime: 2019/12/12 下午5:37
 * @Description: DeadLock Demo
 * 互斥条件：该资源任意一个时刻只由一个线程占用。
 * 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
 * 不剥夺条件:线程已获得的资源在末使用完之前不能被其他线程强行剥夺，只有自己使用完毕后才释放资源。
 * 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        },"线程一").start();
        new Thread(()->{
            synchronized (resource2){
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        },"线程二").start();
    }
}
