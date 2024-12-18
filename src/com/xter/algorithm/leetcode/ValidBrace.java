package com.xter.algorithm.leetcode;


import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * <p>
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * <p>
 * 输出：true
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * <p>
 * 输出：false
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "([])"
 * <p>
 * 输出：true
 */
public class ValidBrace {

	public static void main(String[] args) {
//		String s = "()[]{}";
//		String s = "([)]";
		String s = "(){}}{";
		System.out.println(isValid(s));
	}

	static public boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> braces = new Stack<>();
		braces.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (!braces.empty() && s.charAt(i) - braces.peek() < 3 && s.charAt(i) - braces.peek() > 0) {
				braces.pop();
			} else {
				braces.push(s.charAt(i));
			}
		}
		return braces.empty();
	}


}
