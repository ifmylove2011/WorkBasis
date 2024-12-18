package com.xter.algorithm.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
public class TreePathSumMax {
	public static void main(String[] args) {
//		Integer[] p = {-10, 9, 20, null, null, 15, 7};
		Integer[] p = {9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6};
//		Integer[] p = {2, -1, -2};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(new TreePathSumMax().maxPathSum(pN));
	}


	public int maxPathSum(TreeNode root) {
		AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
		findMaxPath1(root, max);
		return max.get();
	}

	private int findMaxPath(TreeNode root, AtomicInteger maxValue) {
		if (root == null) return 0;
		int left = Math.max(0, findMaxPath(root.left, maxValue));
		int right = Math.max(0, findMaxPath(root.right, maxValue));
		maxValue.set(Math.max(maxValue.get(), root.val + left + right));
		return Math.max(left, right) + root.val;
	}

	private int findMaxPath1(TreeNode root, AtomicInteger maxValue) {
		if (root == null) {
			return 0;
		}
		int sumLeft = Math.max(0,findMaxPath(root.left, maxValue));
		int sumRight = Math.max(0,findMaxPath(root.right, maxValue));

		int subMax = Math.max(sumLeft, sumRight);

		int rootMax = root.val + sumLeft + sumRight;
		int leftMax = root.val + sumLeft;
		int rightMax = root.val + sumRight;

		int max = Math.max(rootMax, Math.max(leftMax, rightMax));
		if (max > maxValue.get()) {
			maxValue.set(max);
		}
		return root.val + subMax;
	}


}
