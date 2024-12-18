package com.xter.algorithm.leetcode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class NodeDelBack {

	public static void main(String[] args) {
		ListNode head = ListNode.generateNode(new int[]{1, 2});
		ListNode.printNode(removeNthFromEnd(head, 2));
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode newHead = new ListNode(-1, head);
		ListNode tail = head;
		ListNode pre = newHead;
		for (int i = 0; i < n; i++) {
			tail = tail.next;
		}
		while (tail != null) {
			tail = tail.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return newHead.next;
	}

	public static ListNode findBack1(ListNode head, int k) {
		ListNode node1 = head.next;
		ListNode node2 = head.next;
		for (int i = 1; i < k; i++) {
			node2 = node2.next;
		}
		while (node2.next != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		return node1;
	}

}
