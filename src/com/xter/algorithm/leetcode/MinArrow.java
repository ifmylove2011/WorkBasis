package com.xter.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * <p>
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * 示例 3：
 * <p>
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 */
public class MinArrow {

	public static void main(String[] args) {
		int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
		System.out.println(findMinArrowShots(points));
	}

	public static int findMinArrowShots(int[][] points) {
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		for (int[] array : points) {
			System.out.print(Arrays.toString(array) + ",");
		}
		System.out.println();
		int index = 0, count = 1, len = points.length;
		if (len < 2) {
			return 1;
		}
		int[] range = points[index];
		while (index < len - 1) {
			if (points[index + 1][0] <= range[1]) {
				range[0] = Math.max(range[0],points[index+1][0]);
				range[1] = Math.min(range[1], points[index+1][1]);
				System.out.println(Arrays.toString(range));
			} else {
				count++;
				range = points[index+1];
			}
			index++;
		}
		return count;
	}
}
