package basetest.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author guwanli
 * @date 2021/8/17 10:59 上午
 */
public class CreateStream extends StreamDemo{
    public static void main(String[] args) {
        // 集合获取 Stream 流
        Stream<String> nameListStream = nameList.stream();
        // 集合获取并行 Stream 流
        Stream<String> nameListStream2 = nameList.parallelStream();
        // 数组获取 Stream 流
        Stream<String> nameArrStream = Stream.of(nameArr);
        // 数组获取 Stream 流
        Stream<String> nameArrStream2 = Arrays.stream(nameArr);
        // 文件流获取 Stream 流
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("README.md"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Stream<String> linesStream = bufferedReader.lines();
        // 从静态方法获取流操作
        System.out.println("从静态方法获取流操作");
        IntStream rangStream = IntStream.range(0, 10);
        rangStream.limit(10).forEach(num -> System.out.print(num + ","));

        IntStream intStream = IntStream.of(1, 2, 3, 4);
        intStream.forEach(num -> System.out.print(num + ","));
        System.out.println();
    }
}
