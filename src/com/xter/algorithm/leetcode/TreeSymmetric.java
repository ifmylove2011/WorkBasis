package com.xter.algorithm.leetcode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class TreeSymmetric {

	public static void main(String[] args) {
		Integer[] p = {1, 2, 2, 3, 4, 2, 3};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(isSymmetric(pN));
	}

	static public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetricSub(root.left, root.right);
	}

	static public boolean isSymmetricSub(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return left.val == right.val && isSymmetricSub(left.left, right.right) && isSymmetricSub(left.right, right.left);
	}
}
