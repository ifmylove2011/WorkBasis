package com.xter.algorithm.leetcode;

import java.util.Arrays;

public class ArrayFindDuplicate1 {

	public static void main(String[] args) {
		int[] nums = {0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5};
		int s = find1(nums);
		System.out.println(s);
		System.out.println(Arrays.toString(nums));
	}

	static int find1(int[] nums) {
		int len = nums.length;
		if (len <= 2) {
			return len;
		}
		int cur = nums[0];
		int index = 1, expect = 1, repeat = 0;
		while (index < len) {
			if (cur < nums[index]) {
				cur = nums[index];
				nums[expect] = cur;
				expect++;
				repeat = 0;
			} else {
				repeat++;
				if (repeat < 2) {
					nums[expect++] = cur;
				}
			}
			index++;
		}
		return expect;
	}

	static int find(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return len;
		}
		int cur = nums[0];
		int index = 1, expect = 1;
		while (index < len) {
			if (cur < nums[index]) {
				cur = nums[index];
				nums[expect] = cur;
				expect++;
			} else {
				index++;
			}
		}
		return expect;
	}
}
