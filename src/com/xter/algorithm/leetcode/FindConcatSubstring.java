package com.xter.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * <p>
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * <p>
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * 示例 2：
 * <p>
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * 示例 3：
 * <p>
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 */
public class FindConcatSubstring {

	public static void main(String[] args) {
//		String s = "barfoofoobarthefoobarman";
//		String s = "wordgoodgoodgoodbestword";
//		String s = "barfoothefoobarman";
		String s = "aaaaaaaaaaaaaa";
//		String[] words = {"bar", "foo", "the"};
//		String[] words = {"word", "good", "best", "word"};
		String[] words = {"aa", "aa"};
//		String[] words = { "foo","bar"};
		System.out.println(findSubstring0(s, words));
		System.out.println(findSubstring(s, words));
	}

	static public List<Integer> findSubstring0(String s, String[] words) {
		List<Integer> list = new ArrayList<>();
		List<String> wordList = Arrays.asList(words);
		Collections.sort(wordList);

		int wordsNum = words.length;
		int wordLen = words[0].length();
		int subLen = wordsNum * wordLen;
		if (s.length() < subLen) {
			return list;
		}
		for (int i = 0; i <= s.length() - subLen; i++) {
			String temp = s.substring(i, i + subLen);
			List<String> tmpList = new ArrayList<>();
			for (int k = 0; k < temp.length(); k = k + wordLen) {
				tmpList.add(temp.substring(k, k + wordLen));
			}
			Collections.sort(tmpList);
			if (tmpList.equals(wordList)) {
				list.add(i);
			}
		}
		return list;
	}

	static public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<>(words.length);
		ArrayList<String> wordList = new ArrayList<>();
		for(String word:words){
			wordList.add(word);
		}
		int wordLen = words[0].length();
		int subLen = wordLen * words.length;
		if (s.length() < subLen) {
			return list;
		}
		int nextIndex = 0, prevIndex = 0;
		String temp = "";
		while (nextIndex + subLen <= s.length()) {
			temp = s.substring(nextIndex, nextIndex + subLen);
			ArrayList<String> wordListTemp = new ArrayList<>(wordList);
			for (int i = 0; i < words.length; i++) {
				String str = temp.substring(i * wordLen, i*wordLen+wordLen);
				if (!wordListTemp.remove(str)) {
					prevIndex = nextIndex;
					nextIndex++;
					break;
				}
			}
			if (wordListTemp.isEmpty()) {
				list.add(nextIndex);
				System.out.println(temp);
				nextIndex++;
			}
		}
		return list;
	}
}
