package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 */
public class TreeLevelOrder {

	public static void main(String[] args) {
		Integer[] p = {3, 9, 20, 1, 4, 15, 7};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(new TreeLevelOrder().levelOrder1(pN));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();//依靠队列先进先出的特点实现输出顺序的控制
		List<List<Integer>> res = new ArrayList<>();//存储结果集
		if (root != null) queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();//存储每行的结果集
			for (int i = queue.size(); i > 0; i--) {//queue.size()其实就是每行的元素数
				TreeNode current = queue.poll();
				tmp.add(current.val);
				if (current.left != null) queue.add(current.left);
				if (current.right != null) queue.add(current.right);
			}
			res.add(tmp);
		}
		return res;
	}

	/**
	 * 便于理解
	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder1(TreeNode root) {
		findList(root, 0);
		return new ArrayList<>(map.values());
	}

	Map<Integer, List<Integer>> map = new HashMap<>();

	public void findList(TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		List<Integer> list = map.get(depth);
		if (list == null) {
			list = new ArrayList<>();
		}
		list.add(root.val);
		map.put(depth++, list);

		if (root.left != null) {
			findList(root.left, depth);
		}
		if (root.right != null) {
			findList(root.right, depth);
		}
	}
}
