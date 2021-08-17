package basetest.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 惰性计算
 *
 * @author guwanli
 * @date 2021/8/17 10:56 上午
 */
public class LazyTest extends StreamDemo {

    /**
     * 数据处理/转换（intermedia） 操作 map (mapToInt, flatMap 等)、
     * filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered 等这些操作，
     * 在调用方法时并不会立即调用，而是在真正使用的时候才会生效，这样可以让操作延迟到真正需要使用的时刻。
     * <p>
     * 如果没有 惰性计算，那么很明显会先输出偶数，然后输出 分割线。
     */
    public static void main(String[] args) {
        // 生成自己的随机数流
        List<Integer> numberLIst = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 找出偶数
        Stream<Integer> integerStream = numberLIst.stream()
                .filter(number -> {
                    int temp = number % 2;
                    if (temp == 0) {
                        System.out.println(number);
                    }
                    return temp == 0;
                });

        System.out.println("分割线");
        List<Integer> collect = integerStream.collect(Collectors.toList());
    }
}
