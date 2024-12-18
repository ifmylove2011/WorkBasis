package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
public class MinSubstring {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC", t = "ABC";//
//		String s = "adobecodebanc", t = "abcda";
//		String s = "baba", t = "babb";
//		System.out.println(s.indexOf(t));
//		System.out.println(minWindow(s, t));
		System.out.println(minWindow0(s, t));
//		System.out.println(minWindow1(s, t));

//		String[] src = s.split("");
//		String[] fac = t.split("");
//		List<String> listS = new ArrayList<>();
//		Collections.addAll(listS, src);
//		List<String> listT = new ArrayList<>();
//		Collections.addAll(listT, fac);
//
//		System.out.println(listS.containsAll(listT));
//
//		System.out.println(listT.remove("a"));
//		System.out.println(listT);
	}

	public static String minWindow(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}
		if (s.indexOf(t) > -1) {
			return t;
		}

		String[] src = s.split("");
		String[] fac = t.split("");
		List<String> listS = new ArrayList<>();
		Collections.addAll(listS, src);
		List<String> listT = new ArrayList<>();
		Collections.addAll(listT, fac);
//		System.out.println(listS);
//		System.out.println(listT);
//		System.out.println(listS.containsAll(listT));
		if (!listS.containsAll(listT)) {
			return "";
		}
		String result = "";
		int index = 0, start = src.length, end = 0;

		while (index <= src.length - fac.length) {
			if (index + 1 < src.length && src[index].equals(src[index + 1])) {
				index++;
				continue;
			}
			for (int i = index; i < src.length; i++) {
				if (listT.remove(src[i])) {
					if (start > i && listT.size() + 1 == fac.length) {
						start = i;
					}
					if (listT.size() + 2 == fac.length) {
						index = i;
					}
				}

				if (listT.isEmpty()) {
					String temp = s.substring(start, i + 1);
					if (result.length() == 0 || temp.length() < result.length()) {
						result = temp;
					}
//					results.add(s.substring(start, i+ 1));
					start = src.length;
					Collections.addAll(listT, fac);
					break;
				} else {
					if (i == src.length - 1) {
						listT.clear();
						start = src.length;
						Collections.addAll(listT, fac);
					}
				}
			}
		}

//		System.out.println(results);
		return result;
	}

	static public String minWindow0(String s, String t) {
		int[] count = new int[128];
		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i)]++;
		}
		int start = 0, end = 0, minStart = 0, minEnd = 0, minLen = s.length() + 1, subLen = t.length();
		int nextStart = 0;
		while (end < s.length()) {
			//所有符合的都要减1
			if (count[s.charAt(end++)]-- > 0) {
				subLen--;
			}
			while (subLen == 0) {
				System.out.println(s.substring(start, end));
				if (end - start < minLen) {
					minLen = end - start;
					minStart = start;
					minEnd = end;
				}
				//下一个边界的字符判断
				if (count[s.charAt(start++)]++ == 0)
					subLen++;
			}
		}
		return minLen > s.length() ? "" : s.substring(minStart, minEnd);
	}

	static public String minWindow1(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}
		if (s.contains(t)) {
			return t;
		}

		String[] src = s.split("");
		String[] fac = t.split("");
		List<String> listS = new ArrayList<>();
		Collections.addAll(listS, src);
		List<String> listT = new ArrayList<>();
		List<String> listT0 = new ArrayList<>();
		Collections.addAll(listT, fac);
		Collections.addAll(listT0, fac);

		int start = 0, end = 0, minStart = 0, minEnd = 0, minLen = s.length() + 1, subLen = t.length();

		while (end < s.length()) {
			if (listT.remove(listS.get(end++))) {
				subLen--;
			}
			while (subLen == 0) {
				System.out.println(s.substring(start, end));
				if (end - start < minLen) {
					minLen = end - start;
					minStart = start;
					minEnd = end;
				}
				if (!listT.contains(listS.get(start)) && listT0.contains(listS.get(start))) {
					listT.add(listS.get(start));
					subLen++;
				}
				start++;
			}
		}
		return minLen > s.length() ? "" : s.substring(minStart, minEnd);
	}
}
