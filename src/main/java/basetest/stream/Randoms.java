package basetest.stream;

import java.util.Random;

/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 16:22 2020/7/24
 */
public class Randoms {
    public static void main(String[] args) {
        /**
         * Random 对象一个种子（以便程序再次运行时产生相同的输出）
         * ints() 方法产生一个流并且 ints() 方法有多种方式的重载 — 两个参数限定了数值产生的边界。
         * distinct() 来获取它们的非重复值
         * limit() 方法获取前 7 个元素
         * sorted() 方法排序
         * forEach() 方法遍历输出
         */
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
    }
}
