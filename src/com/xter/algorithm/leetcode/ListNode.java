package com.xter.algorithm.leetcode;

public class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
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

	static void printNode(ListNode node) {
		while (node != null) {
			System.out.print(node.val+",");
			node = node.next;
		}
	}
}
