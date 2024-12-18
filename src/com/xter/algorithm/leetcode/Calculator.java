package com.xter.algorithm.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 */
public class Calculator {


	public static void main(String[] args) {
		String s = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(s));
	}

	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int operator = 1, result = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int curNum = c - '0';
				while (i + 1 < len && Character.isDigit(s.charAt(i + 1)))
					curNum = curNum * 10 + s.charAt(++i) - '0';
				result = result + operator * curNum;
			} else if (c == '+') {
				operator = 1;
			} else if (c == '-') {
				operator = -1;
			} else if (c == '(') {
				stack.push(result);
				result = 0;
				stack.push(operator);
				operator = 1;
			} else if (c == ')') {
				result = stack.pop() * result + stack.pop();
			}
		}
		return result;
	}

	Map<Character, Integer> map = new HashMap<>();

	public Calculator() {
		map.put('-', 1);
		map.put('+', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('%', 2);
		map.put('^', 3);
	}

	// 存放所有的数字
	Deque<Integer> numStack = new LinkedList<>();
	// 存放所有「非数字以外」的操作
	Deque<Character> opStack = new LinkedList<>();

	public int calculate1(String s) {
		// 将所有的空格去掉
		s = s.replaceAll(" ", "");
		int n = s.length();
		char[] charArray = s.toCharArray();

		for (int i = 0; i < n; i++) {
			char ch = charArray[i];
			if (ch == '(') {
				opStack.push(ch);
			} else if (ch == ')') {
				// 计算到最近一个左括号为止
				while (opStack.peek() != '(') {
					calc();
				}
				opStack.pop();
			} else if (Character.isDigit(ch)) { // 数字
				int num = 0;
				int j = i;
				// 将从 i 位置开始后面的连续数字整体取出，加入 nums
				while (j < n && Character.isDigit(charArray[j])) {
					num = num * 10 + (charArray[j++] - '0');
				}
				numStack.push(num);
				i = j - 1;
			} else {  // 操作符
				// i==0&&ch=='-'  应对的一个数是负数的情况：-2+1
				// i > 0&&charArray[i - 1]=='(' 应对的是这种情况：1-(-2)
				if (i == 0 && ch == '-' || i > 0 && charArray[i - 1] == '(') {
					numStack.push(0);
				}
				// 有一个新操作要入栈时，先把栈内可以算的都算了
				// 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
				while (!opStack.isEmpty() && opStack.peek() != '(') {
					char prevOp = opStack.peek();
					if (map.get(prevOp) >= map.get(ch)) {
						calc();
					} else {
						break;
					}
				}
				opStack.push(ch);
			}
		}
		// 将剩余的计算完
		while (!opStack.isEmpty()) {
			calc();
		}
		return numStack.peek();
	}

	// 计算两个操作数的结果
	public void calc() {
		if (numStack.size() < 2 || opStack.size() < 1) {
			return;
		}
		int b = numStack.pop(), a = numStack.pop();
		char op = opStack.pop();
		int res = 0;
		if (op == '+')
			res = a + b;
		else if (op == '-')
			res = a - b;
		else if (op == '*')
			res = a * b;
		else if (op == '/')
			res = a / b;
		else if (op == '^')
			res = (int) Math.pow(a, b);
		else if (op == '%')
			res = a % b;
		numStack.push(res);
	}
}
