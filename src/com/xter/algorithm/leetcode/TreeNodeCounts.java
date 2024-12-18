package com.xter.algorithm.leetcode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 */
public class TreeNodeCounts {


	public static void main(String[] args) {
		Integer[] p = {1, 2, 3, 4, 5, 6};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(countNodes(pN));
	}

	static public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
}
