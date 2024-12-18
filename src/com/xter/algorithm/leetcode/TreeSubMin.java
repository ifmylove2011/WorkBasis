package com.xter.algorithm.leetcode;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 */
public class TreeSubMin {

	public static void main(String[] args) {
		Integer[] p = {236,104,701,null,227,null,911};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(new TreeSubMin().getMinimumDifference(pN));
//		new TreeSubMin().find1(pN);
	}

	int subMin = Integer.MAX_VALUE;
	int pre = -100000;
	public int getMinimumDifference(TreeNode root) {
		if (root.left != null){
			getMinimumDifference(root.left);
		}
		subMin = Math.min(root.val - pre, subMin);
		pre = root.val;
		if (root.right != null){
			getMinimumDifference(root.right);
		}
		return subMin;
	}
}
