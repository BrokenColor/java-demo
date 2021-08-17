package basetest.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author guwanli
 * @date 2021/8/17 11:01 上午
 */
public class CollectTest extends StreamDemo{
    /**
     * Stream 流可以轻松的转换为其他结构
     */
    public static void main(String[] args) {
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
}
