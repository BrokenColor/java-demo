package algorithmCode.InterestingCode;

/**
 * 26.移除重复元素
 *
 * @author guwanli
 * @date 2022/11/22 16:00
 */
public class LC_26_S_RemoveDuplicates {

    public static void main(String[] args) {
        LC_26_S_RemoveDuplicates solution = new LC_26_S_RemoveDuplicates();
        int[] nums = {2, 2, 3, 4, 5, 6};
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
    }

    /**
     * 快慢指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }
}
