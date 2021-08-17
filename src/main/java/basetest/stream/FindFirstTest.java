package basetest.stream;

import java.util.Optional;

/**
 * @author guwanli
 * @date 2021/8/17 11:09 上午
 */
public class FindFirstTest extends StreamDemo {
    public static void main(String[] args) {
        /**
         * findFirst 可以查找出 Stream 流中的第一个元素，它返回的是一个 Optional 类型
         * findFirst 方法在查找到需要的数据之后就会返回不再遍历数据了，
         * 也因此 findFirst 方法可以对有无限数据的 Stream 流进行操作，
         * 也可以说 findFirst 是一个 short-circuiting 操作
         */
        System.out.println("findFirstTest");
        Optional<Integer> firstNumber = numberList.stream().findFirst();
        System.out.println(firstNumber.orElse(-1));//如果没有值，获取默认值
    }
}
