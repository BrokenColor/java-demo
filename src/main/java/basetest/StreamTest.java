package basetest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * jdk8新特性
 * Ｓｔｒｅａｍ　的测试
 * Stream 不同于其他集合框架，它也不是某种数据结构，也不会保存数据，但是它负责相关计算，使用起来更像一个高级的迭代器
 * Stream 和迭代器一样的只能单向处理
 * 数据源（source） -> 数据处理/转换（intermedia） -> 结果处理（terminal ）
 */
public class StreamTest {
    static List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
    static String[] nameArr = {"Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter"};
    static List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void main(String[] args) throws FileNotFoundException {
        streamDemo();
        toUpperCaseDemo();
        //Stream 流获取
        createStream();
        //forEach
        forEachTest();
        //map
        mapTest();
        //flatMap
        flatMapTest();
        //filter
        filterTest();
        //findFirst
        findFirstTest();
        //collect
        collectTest();
    }

    /**
     * 1. 筛选出名字长度为4的
     * 2. 名字前面拼接 This is
     * 3. 遍历输出
     *
     * @return
     */

    public static void streamDemo() {
        System.out.println("streamDemo");
        nameList.stream()
                .filter(name -> name.length() == 4)
                .map(name -> "this is " + name)
                .forEach(name -> System.out.println(name));
    }

    /**
     * 转换成为大写然后收集结果，遍历输出
     *
     * @return
     */

    public static void toUpperCaseDemo() {
        System.out.println("toUpperCaseDemo");
        List upperCaseList = nameList.stream()//数据源
                .map(String::toUpperCase) //数据处理/转换
                .collect(Collectors.toList());//结果处理
        upperCaseList.forEach(name -> System.out.print(name + ","));
        System.out.println();
    }

    /**
     * Stream 流获取
     * 几种获取 Stream 流的使用示例。
     */
    public static void createStream() throws FileNotFoundException {

        // 集合获取 Stream 流
        Stream<String> nameListStream = nameList.stream();
        // 集合获取并行 Stream 流
        Stream<String> nameListStream2 = nameList.parallelStream();
        // 数组获取 Stream 流
        Stream<String> nameArrStream = Stream.of(nameArr);
        // 数组获取 Stream 流
        Stream<String> nameArrStream2 = Arrays.stream(nameArr);
        // 文件流获取 Stream 流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("README.md"));
        Stream<String> linesStream = bufferedReader.lines();
        // 从静态方法获取流操作
        System.out.println("从静态方法获取流操作");
        IntStream rangStream = IntStream.range(0, 10);
        rangStream.limit(10).forEach(num -> System.out.print(num + ","));

        IntStream intStream = IntStream.of(1, 2, 3, 4);
        intStream.forEach(num -> System.out.print(num + ","));
        System.out.println();
    }

    /**
     * forEach 是 Strean 流中的一个重要方法，用于遍历 Stream 流，
     * 它支持传入一个标准的 Lambda 表达式。但是它的遍历不能通过 return/break 进行终止。
     * 同时它也是一个 terminal 操作，执行之后 Stream 流中的数据会被消费掉。
     */
    public static void forEachTest() {
        System.out.println("forEach");
        numberList.stream().forEach(number -> System.out.print(number + ","));
        System.out.println();
    }

    /**
     * 使用 map 把对象一对一映射成另一种对象或者形式。
     */
    public static void mapTest() {
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

    /**
     * flatMap
     * 上面的 map 可以把数据进行一对一的映射，而有些时候关系可能不止 1对 1那么简单，可能会有1对多。
     * 这时可以使用 flatMap。
     */
    public static void flatMapTest() {
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

    /**
     * 使用 filter 进行数据筛选，挑选出想要的元素
     * filter 数据筛选
     * 筛选出偶数数字
     */
    private static void filterTest() {
        System.out.println("filterTest");
        List<Integer> collect = numberList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        collect.forEach(number -> System.out.print(number + ","));
        System.out.println();
    }

    /**
     *findFirst 可以查找出 Stream 流中的第一个元素，它返回的是一个 Optional 类型
     * findFirst 方法在查找到需要的数据之后就会返回不再遍历数据了，
     * 也因此 findFirst 方法可以对有无限数据的 Stream 流进行操作，
     * 也可以说 findFirst 是一个 short-circuiting 操作
     */
    private static void findFirstTest() {
        System.out.println("findFirstTest");
        Optional<Integer> firstNumber = numberList.stream().findFirst();
        System.out.println(firstNumber.orElse(-1));//如果没有值，获取默认值
    }
    /**
     *findFirst 可以查找出 Stream 流中的第一个元素，它返回的是一个 Optional 类型
     */
    public static void collectTest() {
        System.out.println("collectTest");

        System.out.println();
    }
}
