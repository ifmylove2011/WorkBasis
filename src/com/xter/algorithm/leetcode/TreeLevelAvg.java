package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 */
public class TreeLevelAvg {

	public static void main(String[] args) {
//		Integer[] p = {3, 9, 20, 15, 7};
		Integer[] p = {2147483647,2147483647,2147483647};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		System.out.println(new TreeLevelAvg().averageOfLevels(pN));
	}

	public List<Double> averageOfLevels(TreeNode root) {
		findList(root, 0);
		List<Double> list = new ArrayList<>(map.size());
		for(Map.Entry<Integer,Double> entry:map.entrySet()){
			list.add((double)entry.getValue()/mapC.get(entry.getKey()));
		}
		return list;
	}

	Map<Integer, Double> map = new HashMap<>();
	Map<Integer, Integer> mapC = new HashMap<>();

	public void findList(TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		Double srcV = map.get(depth);
		if (srcV == null) {
			mapC.put(depth, 1);
			map.put(depth++, (double) root.val);
		} else {
			mapC.put(depth, mapC.get(depth) + 1);
			map.put(depth++, srcV + root.val);
		}
		if (root.left != null) {
			findList(root.left, depth);
		}
		if (root.right != null) {
			findList(root.right, depth);
		}
	}
}
