package algorithmCode.base;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 描述：快速排序
 * 
 * @author BrokenColor
 * @date 2019年3月26日
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 1, 8, 7, 9, 5, 6, 4, 7, 2, 5, 3, 7, 5 };
		QuickSort quickSort = new QuickSort();
		quickSort.QuickSortMethod(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	// 找到基准的位置
	public int position(int[] arr, int startIndex, int endIndex) {
		// 取第一个位置的元素作为基准元素
		int pivot = arr[startIndex];
		// 基准的位置，初始等于pivot的位置
		int index = startIndex;
		int right = endIndex;
		int left = startIndex;
		//大循环在左右指针重合或者交错时结束
		while (left <= right) {
			//right指针从右向左进行比较
			while (left <= right) {
				if (pivot >= arr[right]) {
					arr[left] = arr[right];
					index = right;
					left++;
					break;
				}
				right--;
			}
			//left指针从左向右进行比较
			while (left <= right) {
				if (pivot < arr[left]) {
					arr[right] = arr[left];
					index = left;
					right--;
					break;
				}
				left++;
			}
		}
		arr[index] = pivot;
		return index;
	}

	public void QuickSortMethod(int[] arr, int startIndex, int endIndex) {
		//// 递归结束条件：startIndex大等于endIndex的时候
		if (startIndex >= endIndex) {
			return;
		}
		// 得到基准元素位置
		int pivotIndex = position(arr, startIndex, endIndex);
		// 用分治法递归数列的两部分
		QuickSortMethod(arr, pivotIndex + 1, endIndex);
		QuickSortMethod(arr, startIndex , pivotIndex - 1);

	}

}
