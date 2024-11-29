package com.xter.algorithm.leetcode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class RainTrap {

	public static void main(String[] args) {
//		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//		int height[]  = {4,2,0,3,2,5};
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		int len = height.length;
		int left = 0, right = len - 1, leftMax = height[left], rightMax = height[right];
		int total = 0,max = 0;
		while (left <right ) {
			leftMax = Math.max(height[left], leftMax);
			rightMax = Math.max(height[right], rightMax);
			total = Math.min(leftMax,rightMax) * (right - left);
			max = Math.max(max,total);
			if (leftMax < rightMax) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}

	public static int trap(int[] height) {
		int len = height.length;
		//累计每一列盛水量
		//分别看每一列的左右两侧，当前列左板高度取决于左侧最高，右板则取决于右板最高
		int left = 0, right = len - 1, leftMax = height[left], rightMax = height[right];
		int total = 0;
		while (left < right) {
			leftMax = Math.max(height[left], leftMax);
			rightMax = Math.max(height[right], rightMax);
			if (leftMax < rightMax) {//左侧要漏了，先累计左侧水，并找下一个左侧最高点
				total += rightMax - height[right];
				left++;
			} else {
				total += leftMax - height[left];
				right--;
			}
		}
		return total;
	}
}
