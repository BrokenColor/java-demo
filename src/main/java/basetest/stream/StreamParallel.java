package basetest.stream;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 并行计算
 *
 * @author guwanli
 * @date 2021/8/17 10:54 上午
 */
public class StreamParallel extends StreamDemo {

    /**
     * 并行计算
     * 获取 Stream 流时可以使用 parallelStream 方法代替 stream 方法以获取并行处理流，
     * 并行处理可以充分的发挥多核优势，而且不增加编码的复杂性。
     */
    public static void main(String[] args) {
        // 生成自己的随机数流，取一千万个随机数
        Random random = new Random();
        Stream<Integer> generateRandom = Stream.generate(random::nextInt);
        List<Integer> numberList = generateRandom.limit(10000000).collect(Collectors.toList());

        // 串行 - 把一千万个随机数，每个随机数 * 2 ，然后求和
        long start = System.currentTimeMillis();
        int sum = numberList.stream()
                .map(number -> number * 2)
                .mapToInt(x -> x)
                .sum();
        long end = System.currentTimeMillis();
        System.out.println("串行耗时：" + (end - start) + "ms " + "sum:" + sum);

        // 并行 - 把一千万个随机数，每个随机数 * 2 ，然后求和
        start = System.currentTimeMillis();
        sum = numberList.parallelStream()
                .map(number -> number * 2)
                .mapToInt(x -> x)
                .sum();
        end = System.currentTimeMillis();
        System.out.println("并行耗时：" + (end - start) + "ms " + "sum:" + sum);
    }
}
