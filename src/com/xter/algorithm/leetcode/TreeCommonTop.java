package com.xter.algorithm.leetcode;

import java.util.Stack;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 */
public class TreeCommonTop {

	public static void main(String[] args) {
		Integer[] p = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(new TreeCommonTop().lowestCommonAncestor(pN, new TreeNode(5), new TreeNode(1)));
	}

	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root; // 其中一个为根 那么无论另外一个多远 二者公共祖先就是根
		TreeNode left = lowestCommonAncestor(root.left, p, q); // 左子树里找到的公共祖先
		TreeNode right = lowestCommonAncestor(root.right, p, q); // 右子树找到的公共祖先
		if (left != null && right != null) return root; // 分属两侧 则根为祖先
		return left == null ? right : left;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Stack<TreeNode> stackP = new Stack<>();
		Stack<TreeNode> stackQ = new Stack<>();
		findTreeNode(root, stackP, p);
		findTreeNode(root, stackQ, q);
		TreeNode tmp = null;
		TreeNode result = null;
		while (!stackP.isEmpty() && !stackQ.isEmpty() && ((tmp = stackP.pop()) == stackQ.pop())) {
			result = tmp;
		}
		return result;
	}

	private boolean findTreeNode(TreeNode root, Stack<TreeNode> stack, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (root.val == p.val || findTreeNode(root.left, stack, p) || findTreeNode(root.right, stack, p)) {
			stack.push(root);
			return true;
		}
		return false;
	}
}
