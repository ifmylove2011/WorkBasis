package com.xter.algorithm.leetcode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class NodeRotate {

	public static void main(String[] args) {
		ListNode head = ListNode.generateNode(new int[]{1, 2, 3});
		ListNode.printNode(rotateRight1(head, 2));
	}

	static public ListNode rotateRight1(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		int count = 1;
		ListNode tmp = head;
		while (tmp.next != null) {
			count++;
			tmp = tmp.next;
		}
		k %= count;
		if (k == 0) {
			return head;
		}
		//先拼成环
		tmp.next = head;
		//再从中截断
		for (int i = 0; i < count - k; i++) {
			tmp = tmp.next;
		}
		ListNode newHead = tmp.next;
		tmp.next = null;
		return newHead;
	}

	static public ListNode rotateRight(ListNode head, int k) {
		ListNode pre = new ListNode(-1, head);
		ListNode tail = head;
		while (tail != null && k-- > 0) {
			tail = tail.next;
		}
		while (tail != null) {
			tail = tail.next;
			pre = pre.next;
		}
		ListNode result = new ListNode(-1, pre.next);
		pre.next = null;
		ListNode tmp = result;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = head;
		return result.next;
	}
}
