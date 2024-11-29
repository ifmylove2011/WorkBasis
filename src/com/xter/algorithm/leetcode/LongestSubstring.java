package com.xter.algorithm.leetcode;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 * 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstring {

	public static void main(String[] args) {
//		String s = "pwwkew";
//		String s = "nnnn";
//		String s = "abcabcbbefg";
		String s = "dvdf";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		int len = s.length();
		if (len < 2) {
			return len;
		}
		StringBuilder sb = new StringBuilder();
		String longestStr = "";
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			int repeat = sb.indexOf("" + c);
			if (repeat < 0) {
				sb.append(c);
			} else {
				sb.delete(0, repeat+1);
				sb.append(c);
			}
			if (sb.length() >= longestStr.length()) {
				longestStr = sb.toString();
			}
		}
		System.out.println(longestStr);
		return longestStr.length();
	}
}
