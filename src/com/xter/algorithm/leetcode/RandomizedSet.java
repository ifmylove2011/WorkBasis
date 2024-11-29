package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class RandomizedSet {
	private final List<Integer> nums;
	private final Map<Integer, Integer> indices;
	private final Random random;

	public RandomizedSet() {
		nums = new ArrayList<>();
		indices = new HashMap<>();
		random = new Random();
	}

	public boolean insert(int val) {
		if (indices.containsKey(val)) {
			return false;
		}
		nums.add(val);
		indices.put(val, nums.size() - 1);
		return true;
	}

	public boolean remove(int val) {
		if (!indices.containsKey(val)) {
			return false;
		}
		int index = indices.get(val);
		int tail = nums.get(nums.size() - 1);
		nums.set(index, tail);
		indices.put(tail, index);
		indices.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}

	public int getRandom() {
		return nums.get(random.nextInt(nums.size()));
	}
}
