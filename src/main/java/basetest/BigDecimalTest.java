package basetest;

import java.math.BigDecimal;

/**
 * BigDecimal测试
 *
 * @Author: bc
 * @DateTime: 2020/9/2 下午1:57
 * @Description: BigDecimal测试
 * <p>
 * BigDecimal 主要用来操作（大）浮点数，BigInteger 主要用来操作大整数（超过 long 类型）。
 * BigDecimal 的实现利用到了 BigInteger, 所不同的是 BigDecimal 加入了小数位的概念
 * <p>
 * 注意：我们在使用BigDecimal时，为了防止精度丢失，
 * 推荐使用它的 BigDecimal(String) 构造方法来创建对象。
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        testFloat();
        testBigDecimal();
    }

    //精度丢失
    static void testFloat() {
        System.out.println("testFloat");
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999964
        System.out.println(a == b);// false
    }

    //BigDecimal 来定义浮点数的值，再进行浮点数的运算操作
    static void testBigDecimal() {
        System.out.println("testBigDecimal:");
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        BigDecimal x = a.subtract(b);// 0.1
        BigDecimal y = b.subtract(c);// 0.1
        System.out.println(x.equals(y));// true

        System.out.println("compareTo:");
        //a.compareTo(b) : 返回 -1 表示小于，0 表示 等于， 1表示 大于。
        System.out.println(a.compareTo(b));// 1

        //通过 setScale方法设置保留几位小数以及保留规则。
        BigDecimal m = new BigDecimal("1.255433");
        BigDecimal n = m.setScale(3, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(n);// 1.255

    }
}
