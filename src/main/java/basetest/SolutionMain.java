package basetest;

/**
 * 描述：算法练习
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * @author BrokenColor
 * @date 2019年2月15日
 */
public class SolutionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		int target = 2;
		SolutionMain mianClass = new SolutionMain();
		int[] solution = mianClass.twoSum(nums, target);
		
		for (int i = 0; i < solution.length; i++) {
			System.out.println("index:" + solution[i]);
		}
	}

	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int num = nums[i] + nums[j];
				if (num == target) {
					int[] returnInts = { i, j };
					return returnInts;
				}
			}
		}
		return null;
	}
}