package com.xter.algorithm.leetcode;

import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 */
public class CandyDispatch {

	public static void main(String[] args) {
//		int[] ratings = {1, 0, 2};
		int[] ratings = {1, 0, 2, 3};
//		int[] ratings = {1, 2, 2};
		System.out.println(candy(ratings));
	}

	public static int candy(int[] ratings) {
		int len = ratings.length;
		if (len < 2) {
			return 1;
		}
		int[] candies = new int[len];

		candies[0] = 1;
		for (int i = 1; i < len; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}
		System.out.println(Arrays.toString(candies));
		for (int i = len - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i]) {
				candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
			}
		}
		System.out.println(Arrays.toString(candies));

		int total = 0;
		for (int i : candies) {
			total += i;
		}
		return total;
	}
}
