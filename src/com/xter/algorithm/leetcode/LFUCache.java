package com.xter.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {
	private int capacity = 0;
	private LinkedHashMap<Integer, LFUNode> cache = null;
	private TreeMap<Integer, LinkedList<Integer>> lfuListMap =  new TreeMap<>();

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new LinkedHashMap<Integer, LFUNode>() {
			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return capacity < this.size();
			}
		};
	}

	public int get(int key) {
		LFUNode node = cache.get(key);
		if (null == node) return -1;
		updateNode(key, node);
		return node.value;
	}

	public void put(int key, int value) {
		LFUNode node = cache.get(key);
		if (null == node) {
			if (cache.size() >= capacity) {
				if (capacity == 0) return;
				List<Integer> lfuList = lfuListMap.get(lfuListMap.firstKey());
				Integer oldKey = lfuList.remove(0);
				cache.remove(oldKey);
				if (lfuList.isEmpty())
					lfuListMap.remove(lfuListMap.firstKey());
			}
			lfuListMap.computeIfAbsent(1, k -> new LinkedList<Integer>());
			lfuListMap.get(1).add(key);
			cache.put(key, new LFUNode(value));
		} else {
			updateNode(key, node);
			node.value = value;
		}
	}

	private void updateNode(int key, LFUNode node){
		List<Integer> lfuList = lfuListMap.get(node.freq);
		lfuList.remove((Integer) key);
		if (lfuList.isEmpty()) lfuListMap.remove(node.freq);
		node.freq = node.freq + 1;
		lfuListMap.computeIfAbsent(node.freq, k -> new LinkedList<Integer>());
		lfuListMap.get(node.freq).add(key);
	}

	static class LFUNode {
		int value;
		int freq = 1;
		LFUNode(int value) {
			this.value = value;
		}
	}
}