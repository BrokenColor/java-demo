package basetest.stream;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author guwanli
 * @date 2021/12/3 10:35
 */
public class StreamOrder {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.stream(nums).sorted().forEach(System.out::print);
        System.out.println();
        new ArrayList<>(Arrays.asList(new Integer[]{1, 2}));
    }
}
