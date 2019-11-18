package basetest.threadTest;

/**
 * Description:简易倒计时
 * <p>
 * Author: GWL
 * Date: Create in 17:11 2019/10/10
 */
public class SimpleTimer {
    public static int count;

    public static void main(String[] args) {
        count = args.length >= 1 ? Integer.valueOf(args[0]) : 60;
        int remaining;
        while (true) {
            remaining = countDown();
            if (remaining == 0) {
                break;
            } else {
                System.out.println("remaining:" + remaining + " second");
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("done.");
    }

    public static int countDown() {
        return count--;
    }
}
