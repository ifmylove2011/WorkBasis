package com.xter.algorithm.leetcode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class MinLenSubArray {

	public static void main(String[] args) {
		int target = 15;
		int[] nums = {1, 2, 3, 4, 5};
//		int[] nums = {2, 3, 1, 2, 4, 3};
//		int[] nums = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
//		int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
		System.out.println(minSubArrayLen(target, nums));
	}

	public static int minSubArrayLen(int target, int[] nums) {
		//不能打乱顺序
		int left = 0, sum = 0, count = nums.length + 1;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= target) {
				count = Math.min(count, right - left + 1);
				//重设起点，找下一个最小窗口
				sum -= nums[left++];
			}
		}
		return count > nums.length ? 0 : count;
	}
}
