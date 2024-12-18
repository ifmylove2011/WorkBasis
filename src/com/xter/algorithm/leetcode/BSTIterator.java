package com.xter.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * 输出
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * <p>
 * 解释
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // 返回 3
 * bSTIterator.next();    // 返回 7
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 9
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 15
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 20
 * bSTIterator.hasNext(); // 返回 False
 */
public class BSTIterator {

	public static void main(String[] args) {
		Integer[] p = {7, 3, 15, null, null, 9, 20};
		TreeNode pN = TreeNode.buildTreeFromArray(p);
		BSTIterator BSTIterator = new BSTIterator(pN);
		System.out.println(BSTIterator.next());
		System.out.println(BSTIterator.next());
		System.out.println(BSTIterator.hasNext());
		System.out.println(BSTIterator.next());
		System.out.println(BSTIterator.next());
	}

	private final Queue<Integer> queue = new LinkedList<>();

	public BSTIterator(TreeNode root) {
		build(root);
	}

	public int next() {
		return queue.poll();
	}

	public boolean hasNext() {
		return !queue.isEmpty();
	}

	public void build(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			build(root.left);
		}
		queue.offer(root.val);
		if (root.right != null) {
			build(root.right);
		}
	}

	public void print(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			print(root.left);
		}
		System.out.println(root.val);
		if (root.right != null) {
			print(root.right);
		}
	}
}
