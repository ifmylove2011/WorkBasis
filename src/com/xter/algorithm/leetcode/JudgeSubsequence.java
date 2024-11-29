package com.xter.algorithm.leetcode;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 */
public class JudgeSubsequence {

	public static void main(String[] args) {
//		String s = "abc", t = "ahbgdc";
		String s = "axc", t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
	}

	public static boolean isSubsequence(String s, String t) {
		int len1 = s.length(), len2 = t.length();
		int m = 0, n = 0;
		if (len1 < 1) {
			return true;
		}
		if (len1 > len2) {
			return false;
		}
		while (m < len1 && n < len2) {
			if (s.charAt(m) == t.charAt(n)) {
				m++;
			}
			n++;
		}
		System.out.println(m + "," + n);
		return m == len1;
	}
}
