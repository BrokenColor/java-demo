package basetest.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: gwl
 * @date: 2024/8/28 16:21
 */
public class StreamPeekTest {
    public static void main(String[] args) {
        List<String> collect = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
        System.out.println(collect);
    }
}
