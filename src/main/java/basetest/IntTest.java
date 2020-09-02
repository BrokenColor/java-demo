package basetest;

/**
 * IntTest
 *
 * @Author: bc
 * @DateTime: 2020/9/2 下午1:57
 * @Description: IntTest测试
 */
public class IntTest {
    public static void main(String[] args) {
        testInteger();
    }

    /**
     * 当使用自动装箱方式创建一个Integer对象时，当数值在-128 ~127时，
     * 会将创建的 Integer 对象缓存起来，当下次再出现该数值时，
     * 直接从缓存中取出对应的Integer对象。所以上述代码中，x和y引用的是相同的Integer对象。
     */
    static void testInteger() {
        Integer x = 3;
        Integer y = 3;
        System.out.println(x == y);// true
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true
    }
}
