package com.xter.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 */
public class TreeBuild1 {

	public static void main(String[] args) {
		int[] inorder = {9, 3, 15, 20, 7};
		int[] postorder = {9, 15, 7, 20, 3};
		TreeNode.print(new TreeBuild1().buildTree(postorder, inorder));
	}

	private final Map<Integer, Integer> map = new HashMap<>();
	private int index = 0;

	public TreeNode buildTree(int[] postorder, int[] inorder) {
		index = postorder.length - 1;
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return build(postorder, 0, inorder.length - 1);
	}

	private TreeNode build(int[] postorder, int l, int r) {
		if (r < l) {
			return null;
		}
		int mid = map.get(postorder[index]);
		TreeNode root = new TreeNode(postorder[index--]);
		root.right = build(postorder, mid + 1, r);
		root.left = build(postorder, l, mid - 1);
		return root;
	}

}
