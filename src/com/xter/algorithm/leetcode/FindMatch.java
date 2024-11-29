package com.xter.algorithm.leetcode;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
public class FindMatch {

	public static void main(String[] args) {
		String a = "hello";
		String b = "ll";
		System.out.println(strStr(a, b));
		System.out.println(a.indexOf(b));
	}

	public static int strStr(String haystack, String needle) {
		int valueCount = haystack.length();
		int strCount = needle.length();
		if (valueCount < strCount) {
			return -1;
		}

		char first = needle.charAt(0);
		int max = (valueCount - strCount);

		for (int i = 0; i <= max; i++) {
			if (haystack.charAt(i) != first) {
				while (++i <= max && haystack.charAt(i) != first) ;
			}
			if (i <= max) {
				int j = i + 1;
				int end = j + strCount - 1;
				for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++) ;
				if (j == end) {
					// Found whole string.
					return i;
				}
			}
		}
		return -1;
	}
}
