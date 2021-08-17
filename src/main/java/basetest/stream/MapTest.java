package basetest.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guwanli
 * @date 2021/8/17 11:07 上午
 */
public class MapTest extends StreamDemo {
    public static void main(String[] args) {

        /**
         * 使用 map 把对象一对一映射成另一种对象或者形式。
         */
        System.out.println("map");
        List<Integer> collect = numberList.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
        collect.forEach(number -> System.out.print(number + ","));
        System.out.println();
        numberList.stream()
                .map(number -> " 数字:" + number)
                .forEach(number -> System.out.print(number));
        System.out.println();
    }
}