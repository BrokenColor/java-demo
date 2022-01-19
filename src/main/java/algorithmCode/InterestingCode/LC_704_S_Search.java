package algorithmCode.InterestingCode;

/**
 * 704. 二分查找
 *
 * @date 2022/1/16 16:27
 */
public class LC_704_S_Search {
    public static void main(String[] args) {
        LC_704_S_Search solution = new LC_704_S_Search();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(solution.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mind = left + (right - left) / 2;
            if (nums[mind] == target) {
                return mind;
            } else if (nums[mind] > target) {
                right = mind - 1;
            } else if (nums[mind] < target) {
                left = mind + 1;
            }
        }
        return -1;
    }
}
