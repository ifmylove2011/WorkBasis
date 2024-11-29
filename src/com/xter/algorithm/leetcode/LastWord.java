package com.xter.algorithm.leetcode;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大
 * 子字符串
 * 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为 5。
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为 4。
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为 6 的“joyboy”。
 */
public class LastWord {

	public static void main(String[] args) {
		String word = "Hellow World";
//		String word = "   fly me   to   the moon  ";
		System.out.println(lengthOfLastWord(word));
	}

	static public int lengthOfLastWord(String s) {
		if (s == null) {
			return 0;
		}
		if (s.length() < 1) {
			return 0;
		}
		s = s.trim();
		int lastIndex = s.lastIndexOf(" ");
		return s.length() - lastIndex - 1;
	}
}
