package toolUtil;

import java.util.Random;

/**
 * Description:线程工具类
 * <p>
 * Author: GWL
 * Date: Create in 16:44 2019/9/26
 */
public class ThreadTools {
    public static void randomPause(int x) {
        Random random = new Random();
        int y = random.nextInt(x);
        try {
            Thread.sleep(y);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
