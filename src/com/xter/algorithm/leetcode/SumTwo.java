package com.xter.algorithm.leetcode;

import java.util.Arrays;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 */
public class SumTwo {

	public static void main(String[] args) {
//		int[] numbers = {2,3,4};
		int[] numbers = {-12, -6, 2, 3, 8, 12};
//		int[] numbers = {2, 7, 11, 15};
//		int target = 9;
		int target = 6;
		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		int m = 0, n = numbers.length - 1;
		while (m < n && n > 0) {
			if (numbers[n] + numbers[m] < target) {
				m++;
			} else if (numbers[n] + numbers[m] > target) {
				n--;
			} else {
				break;
			}
		}
		System.out.println(numbers[m] + "," + numbers[n]);
		result[0] = m + 1;
		result[1] = n + 1;
		return result;
	}
}
