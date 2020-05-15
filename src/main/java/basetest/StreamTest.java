package basetest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
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
    static List<Integer> ageList = Arrays.asList(11, 22, 13, 14, 25, 26);

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
        //limit skip
        limitOrSkipTest();
        //math
        mathTest();
        //groupingBy
        groupingByTest();
        //partitioningBy
        partitioningByTest();
        //generate
        generateTest();
        //惰性计算
        lazyTest();
        //并行计算
        main();

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
     * findFirst 可以查找出 Stream 流中的第一个元素，它返回的是一个 Optional 类型
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
     * Stream 流可以轻松的转换为其他结构
     */
    public static void collectTest() {
        System.out.println("collectTest");
        //to Arraay
        Integer[] toArray = numberList.stream().toArray(Integer[]::new);
        System.out.println(toArray.toString());
        //to List
        List<Integer> integerList = numberList.stream()
                .collect(Collectors.toList());
        System.out.println(integerList.toString());
        //to Set
        Set<Integer> integersSet = numberList.stream()
                .collect(Collectors.toSet());
        System.out.println(integersSet);
        //to String
        String toString = numberList.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining());
        System.out.println(toString);
        //to String split by ','
        String toStringByJoin = numberList.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(","));
        System.out.println(toStringByJoin);
        System.out.println();
    }

    /**
     * limitOrSkipTest
     */
    public static void limitOrSkipTest() {
        System.out.println("limitOrSkipTest");
        ageList.stream().limit(3).forEach(age -> System.out.print(age + ","));
        System.out.println();
        ageList.stream().skip(3).forEach(age -> System.out.print(age + ","));
        System.out.println();
    }

    /**
     * 数学统计功能，求一组数组的最大值、最小值、个数、数据和、平均数等
     */
    public static void mathTest() {
        System.out.println("mathTest");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        IntSummaryStatistics intSummaryStatistics = list.stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println("最大值：" + intSummaryStatistics.getMax());
        System.out.println("最小值：" + intSummaryStatistics.getMin());
        System.out.println("个数：" + intSummaryStatistics.getCount());
        System.out.println("求和：" + intSummaryStatistics.getSum());
        System.out.println("平均值：" + intSummaryStatistics.getAverage());
        System.out.println();
    }

    /**
     * 分组聚合功能，和数据库的 Group by 的功能一致。
     * 按年龄分组
     */
    public static void groupingByTest() {
        System.out.println("groupingByTest");
        List<Integer> ageList = Arrays.asList(11, 22, 13, 14, 25, 26);
        Map<String, List<Integer>> ageGrouyByMap = ageList.stream()
                .collect(Collectors.groupingBy(age -> String.valueOf(age / 10)));
        ageGrouyByMap.forEach((k, v) -> {
            System.out.println("年龄" + k + "0多岁的有：" + v);
        });
    }

    /**
     * 按某个条件分组
     * 给一组年龄，分出成年人和未成年人
     */
    public static void partitioningByTest() {
        System.out.println("partitioningByTest");
        List<Integer> ageList = Arrays.asList(11, 22, 13, 14, 25, 26);
        Map<Boolean, List<Integer>> ageGrouyByMap = ageList.stream()
                .collect(Collectors.partitioningBy(age -> age > 18));
        System.out.println(ageGrouyByMap.get(false));
        System.out.println(ageGrouyByMap.get(true));
    }

    /**
     * 生成自己的 Stream 流
     */
    public static void generateTest() {
        System.out.println("generateTest");
        // 生成自己的随机数流
        Random random = new Random();
        Stream<Integer> generateRandom = Stream.generate(random::nextInt);
        generateRandom.limit(5).forEach(System.out::println);
        // 生成自己的 UUID 流
        Stream<UUID> generate = Stream.generate(UUID::randomUUID);
        generate.limit(5).forEach(System.out::println);
    }


    /**
     * 数据处理/转换（intermedia） 操作 map (mapToInt, flatMap 等)、
     * filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered 等这些操作，
     * 在调用方法时并不会立即调用，而是在真正使用的时候才会生效，这样可以让操作延迟到真正需要使用的时刻。
     * <p>
     * 如果没有 惰性计算，那么很明显会先输出偶数，然后输出 分割线。
     */
    public static void lazyTest() {
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

    /**
     * 并行计算
     * 获取 Stream 流时可以使用 parallelStream 方法代替 stream 方法以获取并行处理流，
     * 并行处理可以充分的发挥多核优势，而且不增加编码的复杂性。
     */
    public static void main() {
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
                .map(number->number*2)
                .mapToInt(x->x)
                .sum();
        end = System.currentTimeMillis();
        System.out.println("并行耗时：" + (end - start) + "ms " + "sum:" + sum);
    }
}
