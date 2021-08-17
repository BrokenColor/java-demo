package basetest.stream;

import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author guwanli
 * @date 2021/8/17 11:10 上午
 */
public class GenerateTest extends StreamDemo{
    /**
     * 生成自己的 Stream 流
     */
    public static void main(String[] args) {
        System.out.println("generateTest");
        // 生成自己的随机数流
        Random random = new Random();
        Stream<Integer> generateRandom = Stream.generate(random::nextInt);
        generateRandom.limit(5).forEach(System.out::println);
        // 生成自己的 UUID 流
        Stream<UUID> generate = Stream.generate(UUID::randomUUID);
        generate.limit(5).forEach(System.out::println);
    }
}