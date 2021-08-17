package basetest.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * jdk8新特性
 * Stream　的测试
 * Stream 不同于其他集合框架，它也不是某种数据结构，也不会保存数据，但是它负责相关计算，使用起来更像一个高级的迭代器
 * Stream 和迭代器一样的只能单向处理
 * 数据源（source） -> 数据处理/转换（intermedia） -> 结果处理（terminal ）
 */
public class StreamDemo {
    static List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
    static String[] nameArr = {"Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter"};
    static List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    static List<Integer> ageList = Arrays.asList(11, 22, 13, 14, 25, 26);

    public static void main(String[] args) {
        streamDemo();
        toUpperCaseDemo();
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
}
