package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class SumThree {

	public static void main(String[] args) {
//		int[] nums = {-1, 0, 1, 2, -1, -4};
//		int[] nums = {0,0,0};
//		int[] nums = {0,0,0,0};
//		int[] nums = {-1, 0, 1, 0};
		int[] nums = {-2,0,1,1,2};
		System.out.println(threeSum0(nums));
	}

	public static List<List<Integer>> threeSum0(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list0 = new ArrayList<>();
		int first = 0;
		int i = 0;
		while (i < nums.length) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				i++;
				continue;
			}
			if ((first = nums[i]) > 0) break;
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (first + nums[j] + nums[k] < 0) {
					//小于0就把第二值往后移，经过排序后j值会越来越大，反之把k值往前移，k值会越来越小
					++j;
				} else if (first + nums[j] + nums[k] > 0) {
					--k;
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					list0.add(list);
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1]) {
						//跳过中间重复的j值
						++j;
					}
					while (j < k && nums[k] == nums[k + 1]) {
						//跳过中间重复的k值
						--k;
					}
				}
			}
			i++;
		}
		return list0;
	}

}
