package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90.子集II
 *
 * @author guwanli
 * @date 2022/11/26 22:26
 */
public class LC_90_M_SubsetsWithDup {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) continue;

            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
