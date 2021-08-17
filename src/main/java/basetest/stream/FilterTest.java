package basetest.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guwanli
 * @date 2021/8/17 11:08 上午
 */
public class FilterTest extends StreamDemo {
    public static void main(String[] args) {

        /**
         * 使用 filter 进行数据筛选，挑选出想要的元素
         * filter 数据筛选
         * 筛选出偶数数字
         */
        System.out.println("filterTest");
        List<Integer> collect = numberList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        collect.forEach(number -> System.out.print(number + ","));
        System.out.println();
    }
}