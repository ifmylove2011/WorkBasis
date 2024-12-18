package com.xter.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode buildTreeFromArray(Integer[] arr) {
		//遍历数组 层序遍历生成树
		if (arr == null || arr.length == 0) { //非空判断
			return null;
		}
		// 创建根节点和辅助生成树的队列,先让根节点入队
		TreeNode root = new TreeNode(arr[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		//定义一个index变量作为数组当前下标
		int index = 1;
		//队列非空且索引没有越界,就层序遍历生成树
		while (!queue.isEmpty() && index < arr.length) {
			//队列出队的元素是当前树的节点
			TreeNode current = queue.poll();

			//构建左子树
			if (arr[index] != null) {
				current.left = new TreeNode(arr[index]);
				queue.offer(current.left);
			}
			index++;
			//构建右子树
			if (index < arr.length && arr[index] != null) {
				current.right = new TreeNode(arr[index]);
				queue.offer(current.right);
			}
			index++;
		}
		//返回这颗树的根节点
		return root;
	}

	public static void print(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			print(node.left);
		}
		System.out.print(node.val + " ");
		if (node.right != null) {
			print(node.right);
		}
	}

	@Override
	public String toString() {
		return "TreeNode{" +
				"val=" + val +
				'}';
	}
}

