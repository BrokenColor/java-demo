package basetest;

/**
 * @author guwanli
 * @date 2021/11/16 20:40
 */
public class longTest {
    public static void main(String[] args) {
        Long now = System.currentTimeMillis();
        Long startTimestamp = 1637067035188L;
        int duration = 90;
        System.out.println(startTimestamp + duration * 60 * 1000);
        if (startTimestamp + duration * 60 * 1000 < now) {
            System.out.println("ok");
        }
    }


}
