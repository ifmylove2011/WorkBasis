package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 */
public class Tree2Node {

	public static void main(String[] args) {
		Integer[] p = {1, 2, 5, 3, 4, null, 6};
		TreeNode root = TreeNode.buildTreeFromArray(p);
		flatten(root);
		TreeNode.print(root);
	}

	static public void flatten(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<>();
		preOrder(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			list.get(i).left = null;
			list.get(i).right = list.get(i + 1);
		}
	}

	static public void preOrder(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			return;
		}
		list.add(root);
		preOrder(root.left, list);
		preOrder(root.right, list);
	}

	public void flatten1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()){
			while (root != null){
				stack.push(root);
				root = root.left;
			}

			if (!stack.isEmpty()){
				TreeNode cur = stack.pop();
				TreeNode tmp = cur.right;
				cur.right = cur.left;
				cur.left = null;

				while(cur.right != null) cur = cur.right;
				cur.right = tmp;
				root = tmp;
			}
		}
	}

	public void flatten2(TreeNode root) {
		TreeNode node = root;
		while (node != null) {
			if (node.left != null) {
				TreeNode temp = node.left;
				TreeNode pre = temp;
				while (pre.right != null) {
					pre = pre.right;
				}
				pre.right = node.right;
				node.right = temp;
				node.left = null;
			}
			node =  node.right;
		}
	}
}
