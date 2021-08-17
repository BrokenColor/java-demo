package basetest.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guwanli
 * @date 2021/8/17 11:09 上午
 */
public class PartitioningByTest extends StreamDemo {

    public static void main(String[] args) {
        /**
         * 按某个条件分组
         * 给一组年龄，分出成年人和未成年人
         */
        System.out.println("partitioningByTest");
        List<Integer> ageList = Arrays.asList(11, 22, 13, 14, 25, 26);
        Map<Boolean, List<Integer>> ageGrouyByMap = ageList.stream()
                .collect(Collectors.partitioningBy(age -> age > 18));
        System.out.println(ageGrouyByMap.get(false));
        System.out.println(ageGrouyByMap.get(true));
    }
}