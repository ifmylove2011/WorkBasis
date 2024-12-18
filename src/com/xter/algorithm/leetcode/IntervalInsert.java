package com.xter.algorithm.leetcode;

import java.util.Arrays;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * <p>
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 返回插入之后的 intervals。
 * <p>
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class IntervalInsert {

	public static void main(String[] args) {
//		int[][] intervals = {{1, 5}};
//		int[] newIntervals = {6, 8};
		int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
		int[] newIntervals = {4, 8};
		int[][] result = insert0(intervals, newIntervals);
		for (int[] array : result) {
			System.out.print(Arrays.toString(array) + ",");
		}
	}

	static public int[][] insert(int[][] intervals, int[] newInterval) {
		int len = intervals.length;
		if (len < 1) {
			int[][] result = new int[1][2];
			result[0] = newInterval;
			return result;
		}
		int startI = 0, endI = len - 1;
		int index = 0;
		while (startI <= endI) {
			int mid = (startI + endI) / 2;
			if (newInterval[0] < intervals[mid][0]) {
				endI = mid - 1;
			} else if (newInterval[0] > intervals[mid][1]) {
				startI = mid + 1;
			} else {
				index = mid;
				break;
			}
		}
		int start = index, end = len - 1;
		while (index <= len - 1) {
			if (newInterval[1] < intervals[index][0]) {
				end = index - 1;
				break;
			}
			index++;
		}
		int[] in = new int[2];
		in[0] = Math.min(intervals[start][0], newInterval[0]);
		in[1] = Math.max(intervals[end][1], newInterval[1]);
//		System.out.println(Arrays.toString(intervals[start]) + "," + Arrays.toString(intervals[end]));

		int[][] result = new int[len - (end - start)][2];
		result[start] = in;
		if (start > 0) {
			System.arraycopy(intervals, 0, result, 0, start);
		}
		if (len - 1 - end > 0) {
			System.arraycopy(intervals, end + 1, result, start + 1, len - 1 - end);
		}
		return result;
	}


	public static int[][] insert0(int[][] intervals, int[] newInterval) {
		int start = binarySearch(intervals, newInterval[0], 1);
		int end = binarySearch(intervals, newInterval[1], 0);
		int len = intervals.length;
		int[][] result = new int[len - end + start + 1][2];
		System.arraycopy(intervals, 0, result, 0, start);
		if (start != end) {
			newInterval[0] = Math.min(intervals[start][0], newInterval[0]);
			newInterval[1] = Math.max(intervals[end-1][1], newInterval[1]);
		}
		result[start] = new int[]{newInterval[0], newInterval[1]};
		System.arraycopy(intervals, end, result, start + 1, len - end);
		return result;
	}

	static int binarySearch(int[][] arr, int target, int i) {
		int low = 0, high = arr.length;
		while (low < high) {
			int mid = (low + high) >>> 1;
			if (arr[mid][i] > target) high = mid;
			else if (arr[mid][i] < target) low = mid + 1;
			else return mid + 1 - i;
		}
		return high;
	}
}


