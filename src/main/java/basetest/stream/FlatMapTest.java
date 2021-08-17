package basetest.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author guwanli
 * @date 2021/8/17 11:08 上午
 */
public class FlatMapTest extends StreamDemo {
    public static void main(String[] args) {

        /**
         * flatMap
         * 上面的 map 可以把数据进行一对一的映射，而有些时候关系可能不止 1对 1那么简单，可能会有1对多。
         * 这时可以使用 flatMap。
         */
        System.out.println("flatMapTest");
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        List<Integer> collect = inputStream.flatMap(
                (childList) -> childList.stream()).collect(Collectors.toList());
        collect.forEach(number -> System.out.print(number + ","));
        System.out.println();
    }
}
