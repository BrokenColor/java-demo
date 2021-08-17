package basetest.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guwanli
 * @date 2021/8/17 11:07 上午
 */
public class ForEachTest extends StreamDemo {
    public static void main(String[] args) {

        /**
         * forEach 是 Strean 流中的一个重要方法，用于遍历 Stream 流，
         * 它支持传入一个标准的 Lambda 表达式。但是它的遍历不能通过 return/break 进行终止。
         * 同时它也是一个 terminal 操作，执行之后 Stream 流中的数据会被消费掉。
         */
        System.out.println("forEach");
        numberList.stream().forEach(number -> System.out.print(number + ","));
        System.out.println();

        //list为空会报错吗
        List<String> list = new ArrayList<>();
        list.forEach(System.out::println);
    }
}
