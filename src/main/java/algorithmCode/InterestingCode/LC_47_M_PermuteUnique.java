package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47.全排列II
 * @author guwanli
 * @date 2022/11/29 19:46
 */
public class LC_47_M_PermuteUnique {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    //标记是否被使用
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return res;
        // init false
        used = new boolean[nums.length];
        //排序 把相同的元素放到一起
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        //base case
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //是否被使用过
            if (used[i]) continue;
            //与前一位相同，且被使用过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            //选择
            used[i] = true;
            track.add(nums[i]);
            //处理下一层
            backtrack(nums);
            //回溯
            track.removeLast();
            used[i] = false;
        }
    }
}
