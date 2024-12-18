package com.xter.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 */
public class TreeBuild {

	public static void main(String[] args) {
		int[] preorder = {3, 9, 20, 15, 7};
		int[] inorder = {9, 3, 15, 20, 7};
		int[] postorder = {9, 15, 7, 20, 3};
		TreeNode.print(new TreeBuild().buildTree(preorder, inorder));
	}

	static public TreeNode buildTree1(int[] preorder, int[] inorder) {
		if (preorder.length == 0) return null;
		TreeNode root = new TreeNode(preorder[0]);
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] != preorder[0]) continue;
			index = i;
			break;
		}
		if (index != 0) {
			root.left = buildTree1(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
		}
		if (index != inorder.length - 1) {
			root.right = buildTree1(Arrays.copyOfRange(preorder, index + 1, inorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
		}
		return root;
	}

	private final Map<Integer, Integer> map = new HashMap<>();
	private int index = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return build(preorder, 0, inorder.length - 1);
	}

	private TreeNode build(int[] preorder, int l, int r) {
		if (r < l) {
			return null;
		}
		int mid = map.get(preorder[index]);
		TreeNode root = new TreeNode(preorder[index++]);
		root.left = build(preorder, l, mid - 1);
		root.right = build(preorder, mid + 1, r);
		return root;
	}
}
