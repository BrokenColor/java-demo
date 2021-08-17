package basetest.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @author guwanli
 * @date 2021/8/17 11:03 上午
 */
public class MathTest extends StreamDemo {
    /**
     * 数学统计功能，求一组数组的最大值、最小值、个数、数据和、平均数等
     */
    public static void main(String[] args) {

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
}
