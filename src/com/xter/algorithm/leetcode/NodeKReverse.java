package com.xter.algorithm.leetcode;

import com.xter.datastructure.Node;

public class NodeKReverse {

	public static void main(String[] args) {
		ListNode head = ListNode.generateNode(new int[]{1, 2, 3, 4, 5, 6});

		groupReverse(head,4);
		ListNode.printNode(head);
	}


	public static void groupReverse(ListNode head, int k) {
		if (head == null || head.next == null || k < 2) {
			return;
		}
		ListNode start = head.next;
		ListNode result = head;
		ListNode end = null;
		ListNode nextStart = null;
		while (start != null) {
			end = start;
			for (int i = 1; i < k; i++) {
				if (end != null) {
					end = end.next;
				} else {
					return;
				}
			}

			nextStart = end.next;
			end.next = null;
			result.next = reverse(start);
			start.next = nextStart;
			result = start;
			start = nextStart;
		}
	}

	/**
	 * 不带头链表逆序
	 *
	 * @param src 原链表
	 * @return 处理后链表
	 */
	private static ListNode reverse(ListNode src) {
		ListNode last = src;
		ListNode mid = src.next;
		ListNode pre = null;
		last.next = null;
		while (mid != null) {
			pre = mid.next;
			mid.next = last;
			last = mid;
			mid = pre;
		}
		return last;
	}
}

