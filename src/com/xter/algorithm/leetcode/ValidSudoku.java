package com.xter.algorithm.leetcode;


import java.util.Arrays;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 */
public class ValidSudoku {

	public static void main(String[] args) {
		char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
				, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
				, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
				, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
				, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
				, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
				, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
				, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
				, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		System.out.println(isValidSudoku(board));
	}

	static public boolean isValidSudoku(char[][] board) {
		int len = 9;
		int[] countH = new int[9];
		int[] countV = new int[9];
		int[][] countO = new int[3][9];
		for (int h = 0; h < len; h++) {
			if (h % 3 == 0) {
				for (int[] ints : countO) {
					Arrays.fill(ints, 0);
				}
			}
			for (int v = 0; v < len; v++) {
				if (board[h][v] == '.') {
					continue;
				}
				if (countO[v / 3][board[h][v] - '1']++ > 0) {
					return false;
				}
				if (countH[board[h][v] - '1']++ > 0) {
					System.out.println(board[h][v]);
					return false;
				}
			}
			Arrays.fill(countH, 0);
		}
		for (int v = 0; v < len; v++) {
			for (int h = 0; h < len; h++) {
				if (board[h][v] == '.') {
					continue;
				}
				if (countV[board[h][v] - '1']++ > 0) {
					System.out.println(board[h][v]);
					return false;
				}
			}
			Arrays.fill(countV, 0);
		}
		return true;
	}
}
