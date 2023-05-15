package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 45.跳跃游戏 II
 *
 * @Author bc
 * @Date 2023/5/15 22:32
 * @Description: TODO
 */
public class LC_45_M_Jump {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        LC_45_M_Jump solution = new LC_45_M_Jump();
        System.out.println(solution.jump(nums));
    }

    public int jump(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < length; i++) {
            int temp = i + nums[i];
            if (temp > length - 1) {
                temp = length - 1;
            }
            for (int j = 0; j <= temp; j++) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }

        }
        return dp[length - 1];
    }
}
