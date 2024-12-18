package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 */
public class TreeLevelZZZOrder {

	public static void main(String[] args) {
		Integer[] p = {3, 9, 20, 1, 4, 15, 7};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(new TreeLevelZZZOrder().zigzagLevelOrder(pN));
	}


	/**
	 * 便于理解
	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		findList(root, 1);
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
		if (depth % 2 == 0) {
			list.add(0, root.val);
		} else {
			list.add(root.val);
		}
		map.put(depth++, list);
		if (root.left != null) {
			findList(root.left, depth);
		}
		if (root.right != null) {
			findList(root.right, depth);
		}
	}
}
