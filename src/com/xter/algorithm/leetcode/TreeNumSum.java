package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 */
public class TreeNumSum {

	public static void main(String[] args) {
		Integer[] p = {4, 9, 0, 5, 1};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(new TreeNumSum().sumNumbers(pN));
	}

	public int sumNumbers(TreeNode root) {
		int sum = 0;
		findNumbers(root, 0);
		for (int num : list) {
			sum += num;
		}
		return sum;
	}


	List<Integer> list = new ArrayList<>();

	public void findNumbers(TreeNode root, int top) {
		if (root.left == null && root.right == null) {
			list.add(top * 10 + root.val);
		}
		if (root.left != null) {
			findNumbers(root.left, top * 10 + root.val);
		}
		if (root.right != null) {
			findNumbers(root.right, top * 10 + root.val);
		}
	}
}
