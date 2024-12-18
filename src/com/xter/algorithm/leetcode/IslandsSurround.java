package com.xter.algorithm.leetcode;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 * <p>
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
 * 通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * <p>
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * <p>
 * 解释：
 * <p>
 * <p>
 * 在上图中，底部的区域没有被捕获，因为它在 board 的边缘并且不能被围绕。
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * <p>
 * 输出：[["X"]]
 */
public class IslandsSurround {

	public static void main(String[] args) {

	}


	public void solve(char[][] board) {
		int row = board.length, col = board[0].length;
		for (int i = 0; i < row; i++) {
			if (board[i][0] == 'O') {
				check(board, i, 0);
			}
			if (board[i][col - 1] == 'O') {
				check(board, i, col - 1);
			}
		}
		for (int j = 0; j < col; j++) {
			if (board[0][j] == 'O') {
				check(board, 0, j);
			}
			if (board[row - 1][j] == 'O') {
				check(board, row - 1, j);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == '2') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	/**
	 * 把所有相邻的1都标记以便忽略
	 *
	 * @param grid
	 * @param i
	 * @param j
	 */
	public void check(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length ||
				j < 0 || j >= grid[0].length || grid[i][j] != 'O') {
			return;
		}
		grid[i][j] = '2';
		check(grid, i + 1, j);
		check(grid, i - 1, j);
		check(grid, i, j + 1);
		check(grid, i, j - 1);
	}
}
