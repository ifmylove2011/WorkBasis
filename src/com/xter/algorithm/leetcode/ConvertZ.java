package com.xter.algorithm.leetcode;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */
public class ConvertZ {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 5;
		System.out.println(convert1(s, numRows));
		System.out.println(convert(s, numRows));
	}

	public static String convert1(String s, int numRows) {
		int len = s.length();
		char[] result = new char[s.length()];
		int index = 0, row = 1, count = 0;
		//每一轮循环数，如果numRows为4，则123432为一个循环，即6个数
		int circle = 2 * (numRows - 1);
		if (numRows == 1) return s;
		for (int i = 0; i < len; i++) {
			result[i] = s.charAt(index);
			//第一行和最后一行能算出固定值，而中间的每行需要即时算
			if (row != 1 && row != numRows) {
				//每一个循环中下一个相同行数的值偏差值，如4行中的123432，两个第2行的差值为4，两2第3行的差值为2
				int offset = 2 * (numRows - row);
				//当前行数的值在一个循环中有两个，所以需要一次性赋值2次
				if (i + 1 < len && index + offset < s.length())
					result[++i] = s.charAt(index + offset);
			}
			//下一个循环
			index = index + circle;
			if (index >= s.length()) {
				//重置指针到第n行的起始位置
				index = ++count;
				row++;
			}
		}
		return new String(result);
	}

	/**
	 * 为3时，每个字符所在行数为123 212 321，为4时，每个字符所在行数为1234 32123 4321
	 * 12345 432 1234 54321
	 * 2n+n-1+n-2 = 4n-3
	 *
	 * 强行算太容易混乱出错，还是使用行数相对简单
	 *
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		int len = s.length();
		int[] rows = new int[len];
		char[] result = new char[len];
		if (numRows < 2) {
			return s;
		}
		if (len <= numRows) {
			return s;
		}
		int index = 0;
		int circle = 2 * numRows - 2;
		int times = len / circle;
		int mod = len % circle;
		int row = 1;
		while (index < len) {
			rows[index] = row;
			if (row == 1) {
				result[index / circle] = s.charAt(index);
			} else if (row == numRows) {
				result[len - (times - index / circle) - (mod >= numRows ? 1 : 0)] = s.charAt(index);
			} else {
				//index = 2, result.index = times+(mod>=row?1:0)+index/circle*2
//				result[index%circle] = s.charAt(index);
				int t = ((mod > 0 ? 1 : 0) + times) + (times * 2) * (row - 2) + (row - mod) + index / (numRows - 1);
				result[t] = s.charAt(index);
				//Y  索引为11，倒数第三个
			}
			if (index % circle < numRows - 1) {
				row++;
			} else {
				row--;
			}
			index++;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : result) {
			sb.append(c);
		}
		return sb.toString();
	}
}