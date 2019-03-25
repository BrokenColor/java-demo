package algorithmCode.InterestingCode;

/**
 * 描述：
 * 
 * @author BrokenColor
 * @date 2019年3月22日
 */
public class Mode {

	public static void main(String[] args) {
		int[] nums = {2,1,2,1,1,2,1,2,2};
		Mode mode = new Mode();
		System.out.println(mode.majorityElement(nums));
	}

	public int majorityElement(int[] nums) {
		int count = 1;
		int num = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (num == nums[i]) {
				count++;
			} else {
				count--;
				if (count == 0) {
					num = nums[i + 1];
				}
			}
		}
		return num;
	}
}
