package com.xter.algorithm.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class CommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"flower","f","flight"};
		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();
		int len = strs.length;
		String common = strs[0];
		int commLen = common.length();
		for (int i = 0; i < commLen; i++) {
			char c = common.charAt(i);
			for (int j = 1; j < len; j++) {
				if (strs[j].length() < i + 1) {
					return sb.toString();
				}
				if (c != strs[j].charAt(i)) {
					return sb.toString();
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
