package basetest.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guwanli
 * @date 2021/8/17 11:04 上午
 */
public class GroupingByTest extends StreamDemo {
    /**
     * 分组聚合功能，和数据库的 Group by 的功能一致。
     * 按年龄分组
     */
    public static void main(String[] args) {
        System.out.println("groupingByTest");
        List<Integer> ageList = Arrays.asList(11, 22, 13, 14, 25, 26);
        Map<String, List<Integer>> ageGrouyByMap = ageList.stream()
                .collect(Collectors.groupingBy(age -> String.valueOf(age / 10)));
        ageGrouyByMap.forEach((k, v) -> {
            System.out.println("年龄" + k + "0多岁的有：" + v);
        });
    }
}
