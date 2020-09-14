package basetest;

/**
 * @Author: bc
 * @DateTime: 2020/9/12 下午4:26
 * @Description: TODO
 */
public class CpuLoop {
    public static void main(String[] args) {
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            num = 0;
        }
    }
}
