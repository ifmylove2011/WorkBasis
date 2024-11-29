package com.xter.algorithm.leetcode;

import java.util.Arrays;

public class ArrayFindDuplicate2 {

	public static void main(String[] args) {
		int[] nums = {3,2,3};
		int s = find(nums);
		System.out.println(s);
		System.out.println(Arrays.toString(nums));
	}


	static int find(int[] nums) {
		int len = nums.length;
		int cur = nums[0];
		int index = 1, count = 1;
		while (index < len) {
			if (count == 0) {
				cur = nums[index];
			}
			if (nums[index] == cur) {
				count++;
			} else {
				count--;
			}
			index++;
		}
		return cur;
	}
}
