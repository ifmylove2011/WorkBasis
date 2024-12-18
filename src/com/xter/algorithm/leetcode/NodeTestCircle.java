package com.xter.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class NodeTestCircle {

	public static void main(String[] args) {
	}

	static public boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		ListNode cur = head;
		while (cur != null) {
			if (!set.contains(cur)) {
				set.add(cur);
				cur = cur.next;
			} else {
				return true;
			}
		}
		return false;
	}

}
