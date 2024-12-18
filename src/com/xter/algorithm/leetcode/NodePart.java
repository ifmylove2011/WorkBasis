package com.xter.algorithm.leetcode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class NodePart {
	public static void main(String[] args) {
		ListNode head = ListNode.generateNode(new int[]{1, 4, 3, 2, 5, 2});
		ListNode.printNode(partition(head, 3));
	}

	static public ListNode partition(ListNode head, int x) {
		ListNode pre = new ListNode(-1);
		ListNode pre1 = pre;
		ListNode tail = new ListNode(-1);
		ListNode tail1 = tail;
		for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
			if (tmp.val < x) {
				pre1.next = tmp;
				pre1 = pre1.next;
			} else {
				tail1.next = tmp;
				tail1 = tail1.next;
			}
		}
		pre1.next = tail.next;
		tail1.next = null;
		return pre.next;
	}
}
