package com.xter.algorithm.leetcode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class NodeTwoSum {

	public static void main(String[] args) {
		ListNode l1 = generateNode(new int[]{2,4,3});
		ListNode l2 = generateNode(new int[]{5,6,4});
		printNode(addTwoNumbers(l1, l2));
	}

	static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode tmp, cur = head;

		int flag = 0;
		while (l1 != null || l2 != null) {
			tmp = new ListNode(0);
			int val;
			if (l1 == null) {
				val = l2.val + flag;
			} else if (l2 == null) {
				val = l1.val + flag;
			} else {
				val = l1.val + l2.val + flag;
			}
			if (val > 9) {
				val = val - 10;
				tmp.val = val;
				flag = 1;
			} else {
				tmp.val = val;
				flag = 0;
			}
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			cur.next = tmp;
			cur = tmp;
		}
		if (flag > 0) {
			tmp = new ListNode(1);
			cur.next = tmp;
		}
		return head.next;
	}

	static void printNode(ListNode node) {
		while (node != null) {
			System.out.print(node.val+",");
			node = node.next;
		}
	}

	static boolean getNode(ListNode l1, ListNode l2) {

		int val = 0;
		if (l1 == null) {
			val = l2.val;

			return false;
		} else if (l2 == null) {
			val = l1.val;
			return false;
		} else {
			val = l1.val + l2.val;
			if (val > 9) {
				l1.val = val;
				l2.val = val;
				return false;
			} else {
				l1.val = val - 10;
				l2.val = val - 10;
				return true;
			}
		}

	}

	public static ListNode generateNode(int[] nums) {
		ListNode head = new ListNode(nums[0]);

		ListNode tmp;
		ListNode cur = head;
		for (int i = 1; i < nums.length; i++) {
			tmp = new ListNode(nums[i]);
			cur.next = tmp;
			cur = tmp;
		}
		return head;
	}
}
