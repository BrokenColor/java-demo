package basetest.stream;

/**
 * @author guwanli
 * @date 2021/8/17 11:02 上午
 */
public class LimitOrSkipTest extends StreamDemo {
    /**
     * limitOrSkipTest
     */
    public static void main(String[] args) {
        System.out.println("limitOrSkipTest");
        ageList.stream().limit(3).forEach(age -> System.out.print(age + ","));
        System.out.println();
        ageList.stream().skip(3).forEach(age -> System.out.print(age + ","));
        System.out.println();

    }
}
