package com.xter.algorithm.leetcode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class NodeRangeReverse {

	public static void main(String[] args) {
		ListNode head = ListNode.generateNode(new int[]{1, 2, 3, 4, 5, 6});

//		reverseBetween1(head, 2, 4);
		ListNode.printNode(reverse2(head));
	}

	static public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || head.next == null) {
			return head;
		}
		int count = 0;
		ListNode mid = head.next;
		ListNode pre = head;
		while (++count < left) {
			mid = mid.next;
			pre = pre.next;
		}
//		pre.next = head.next;
		count = right - left;
		ListNode tmp = null;
		while (mid != null && count-- >= 1) {
			//保存下一个结点，否则无法继续 遍历
			tmp = mid.next;
			//当前首结点变成当前结点的下一结点
			mid.next = pre.next;
			pre.next = mid;
			mid = tmp;
		}
		return pre;
	}

	static public ListNode reverseBetween1(ListNode head, int left, int right) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = new ListNode(0, head);
		ListNode pre = newHead;
		for (int i = 1; i < left; i++)
			pre = pre.next;
		ListNode mid = null;
		ListNode tail = pre.next;
		for (int i = 0; i < right - left + 1; i++) {
			ListNode next = tail.next;
			tail.next = mid;
			mid = tail;
			tail = next;
		}
		pre.next.next = tail;
		pre.next = mid;

		return newHead.next;
	}


	public static ListNode reverse2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pev = null;
		ListNode tail = head;
		while (tail != null) {
			ListNode next = tail.next;
			tail.next = pev;
			pev = tail;
			tail = next;
		}
		return pev;
	}
}
