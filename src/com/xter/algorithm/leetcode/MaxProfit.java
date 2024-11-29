package com.xter.algorithm.leetcode;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class MaxProfit {
	public static void main(String[] args) {
		int[] prices = {7, 2, 1, 3, 6, 4};
//		int[] prices = {7, 6,5,4,3,2,1};
//		int[] prices = {2, 1, 4};
//		int[] prices = {1,2,4};
//		int[] prices = {3,2,6,5,0,3};
//		System.out.println(maxProfit(prices));
		System.out.println(maxP(prices));
	}

	static int sumP(int[] prices) {
		int len = prices.length;
		int temp = 0, profit = 0, index = 1;
		while (index < len) {
			temp = prices[index] - prices[index - 1];
			if (temp > 0) {
				profit += temp;
			}
			index++;
		}
		return profit;
	}

	static int maxP(int[] prices) {
		int len = prices.length;
		if (len < 2) {
			return 0;
		}
		int temp = 0, profit = 0, index = 1;
		while (index < len) {
			temp += prices[index] - prices[index - 1];
			if (temp < 0) {
				temp = 0;
			}
			if (temp > 0 && temp > profit) {
				profit = temp;
			}
			index++;
		}
		return profit;
	}

	static int maxProfit(int[] prices) {
		int len = prices.length;
		if (len < 2) {
			return 0;
		}
		int min = prices[0], max = 0, index = 1;
		while (index < len) {
			int profit = prices[index] - min;
			if (profit > max) {
				max = profit;
			}
			if (prices[index] < min) {
				min = prices[index];
			}
			index++;
		}
		return max;
	}
}
