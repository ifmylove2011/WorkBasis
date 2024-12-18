package com.xter.algorithm.leetcode;

import java.util.LinkedHashMap;

public class LRUCache {

	private final LinkedHashMap<Integer, Integer> map;

	private final int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new LinkedHashMap<>(capacity, 0.75f, true);
	}

	public int get(int key) {
		if (map.containsKey(key))
			return map.get(key);
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			map.put(key, value);
			return;
		}
		if (map.size() == this.capacity) {
			for (int firstKey : map.keySet()) {
				map.remove(firstKey);
				break;
			}
		}
		map.put(key, value);
	}
}
