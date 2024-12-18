package com.xter.algorithm.leetcode;

import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */
public class TreeValidBST {
	public static void main(String[] args) {
		Integer[] p = {5, 1, 4, null, null, 3, 6};
//		Integer[] p = {2, 1, 3};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(new TreeValidBST().isValidBST(pN));
	}

	public boolean isValidBST(TreeNode root) {
		return order(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean order(TreeNode root, long left, long right) {
		if (root == null) {
			return true;
		}
		if (root.val <= left || root.val >= right) {
			return false;
		}
		return order(root.left, left, root.val) && order(root.right, root.val, right);
	}

	/**
	 * 不递归写法
	 *
	 * @param root
	 * @return
	 */
	public boolean isValidBST1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tmp = root;
		int pre = Integer.MIN_VALUE;
		while (tmp != null || !stack.empty()) {
			if (tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			} else {
				tmp = stack.peek();
				if (tmp.val <= pre) {
					return false;
				}
				stack.pop();
				pre = tmp.val;
				tmp = tmp.right;
			}
		}
		return true;
	}
}

