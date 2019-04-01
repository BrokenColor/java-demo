package algorithmCode.base;

import java.util.Arrays;

/**
 * 描述：冒泡排序
 * 
 * @author BrokenColor
 * @date 2019年4月1日
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {4,2,8,7,5,2,0,6,3,7,9,4,3};
		BubbleSort bs = new BubbleSort();
		bs.method(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void method(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
