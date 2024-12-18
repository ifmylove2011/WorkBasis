package com.xter.algorithm.leetcode;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出：3
 */
public class IslandsNums {

	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		System.out.println(new IslandsNums().numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		int islandNum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					check(grid, i, j);
					islandNum++;
				}
			}
		}
		return islandNum;
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
				j < 0 || j >= grid[0].length || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '2';
		check(grid, i + 1, j);
		check(grid, i - 1, j);
		check(grid, i, j + 1);
		check(grid, i, j - 1);
	}
}
