package com.xter.algorithm.leetcode;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 * <p>
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 * <p>
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 */
public class Palindrome {

	public static void main(String[] args) {
//		String s = "A man, a plan, a ccanal: Panama";
		String s = "0P";
//		String s = "race a car";
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
		System.out.println(s);
		int len = s.length();
		if (len < 2) {
			return true;
		}
		boolean drome = true;
		int start = 0, end = len - 1;
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				drome = false;
				break;
			}
		}
		System.out.println(start + "," + end);
		return drome;
	}
}
