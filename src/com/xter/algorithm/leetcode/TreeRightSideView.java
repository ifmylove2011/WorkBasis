package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,null,5,null,4]
 * <p>
 * 输出：[1,3,4]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3,4,null,null,null,5]
 * <p>
 * 输出：[1,3,4,5]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1,null,3]
 * <p>
 * 输出：[1,3]
 * <p>
 * 示例 4：
 * <p>
 * 输入：root = []
 * <p>
 * 输出：[]
 */
public class TreeRightSideView {

	public static void main(String[] args) {
//		Integer[] p = {1, 2, 3, null, 5, null, 4};
		Integer[] p = {1,2,3,4,null,null,null,5};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(new TreeRightSideView().rightSideView(pN));
	}

	public List<Integer> rightSideView(TreeNode root) {
		findList(root,0);
		return new ArrayList<Integer>(map.values());
	}

	Map<Integer,Integer> map = new HashMap<>();
	public void findList(TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		System.out.println(root+","+(depth));
		map.put(depth++,root.val);
		if (root.left != null) {
			findList(root.left, depth);
		}
		if (root.right != null) {
			findList(root.right, depth);
		}
	}

	public List<Integer> rightSideView1(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = que.poll();
				if (i == size - 1) {
					result.add(node.val);
				}
				if (node.left != null) {
					que.offer(node.left);
				}
				if (node.right != null) {
					que.offer(node.right);
				}
			}
		}
		return result;
	}
}
