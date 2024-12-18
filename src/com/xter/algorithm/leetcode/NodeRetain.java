package com.xter.algorithm.leetcode;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 */
public class NodeRetain {

	public static void main(String[] args) {
		ListNode head = ListNode.generateNode(new int[]{1, 1, 2});
//		ListNode.printNode(deleteDuplicates(head));
		ListNode.printNode(retain1(head));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode newHead = new ListNode(0, head);
		ListNode tail = head;
		ListNode pre = newHead;
		while (tail != null && tail.next != null) {
			if (tail.val == tail.next.val) {
				int x = tail.val;
				while (tail != null && tail.val == x) {
					tail = tail.next;
				}
				pre.next = tail;
			} else {
				tail = tail.next;
				pre = pre.next;
			}
		}
		return newHead.next;
	}

	public static ListNode retain1(ListNode head) {
		ListNode newHead = new ListNode(-1, head);
		ListNode tail = newHead;

		while (tail.next != null && tail.next.next != null) {
			if (tail.next.val == tail.next.next.val) {
				tail.next = tail.next.next;
			} else {
				tail = tail.next;
			}
		}
		return newHead.next;
	}


	public static ListNode retain(ListNode head) {
		ListNode repeatPre = null;
		ListNode repeat = null;
		for (ListNode cur = head.next; cur != null; cur = cur.next) {
			repeat = cur.next;
			repeatPre = cur;
			while (repeat != null) {
				if (repeat.val == cur.val) {
					repeatPre.next = repeat.next;
				} else {
					repeatPre = repeat;
				}
				repeat = repeat.next;
			}
		}
		return head;
	}
}
