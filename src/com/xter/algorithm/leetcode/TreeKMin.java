package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 */
public class TreeKMin {

	public static void main(String[] args) {
		Integer[] p = {5, 3, 6, 2, 4, null, null, 1};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(new TreeKMin().kthSmallest(pN, 3));
	}

	int order = 1;
	List<Integer> list = new ArrayList<>();

	public int kthSmallest1(TreeNode root, int k) {
		find(root);
		return list.get(k - 1);
	}

	public void find(TreeNode root) {
		if (root.left != null) {
			find(root.left);
		}
		list.add(root.val);
		if (root.right != null) {
			find(root.right);
		}
	}

	/**
	 * 查找左子树节点个数为leftN,如果K<=leftN,则所查找节点在左子树上.
	 * 若K=leftN+1,则所查找节点为根节点
	 * 若K>leftN+1,则所查找节点在右子树上,按照同样方法查找右子树第K-leftN个节点
	 *
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest(TreeNode root, int k) {
		int leftN = findChild(root.left);
		if (leftN + 1 == k) return root.val;
		else if (k <= leftN) {
			return kthSmallest(root.left, k);
		} else return kthSmallest(root.right, k - leftN - 1);
	}

	/**
	 * 查找子节点个数
	 *
	 * @param root
	 * @return
	 */
	public int findChild(TreeNode root) {
		if (root == null) return 0;
		return findChild(root.left) + findChild(root.right) + 1;
	}
}
