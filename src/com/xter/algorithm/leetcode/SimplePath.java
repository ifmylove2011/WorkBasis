package com.xter.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
 * <p>
 * 在 Unix 风格的文件系统中规则如下：
 * <p>
 * 一个点 '.' 表示当前目录本身。
 * 此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
 * 任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
 * 任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
 * 返回的 简化路径 必须遵循下述格式：
 * <p>
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：path = "/home/"
 * <p>
 * 输出："/home"
 * <p>
 * 解释：
 * <p>
 * 应删除尾随斜杠。
 * <p>
 * 示例 2：
 * <p>
 * 输入：path = "/home//foo/"
 * <p>
 * 输出："/home/foo"
 * <p>
 * 解释：
 * <p>
 * 多个连续的斜杠被单个斜杠替换。
 * <p>
 * 示例 3：
 * <p>
 * 输入：path = "/home/user/Documents/../Pictures"
 * <p>
 * 输出："/home/user/Pictures"
 * <p>
 * 解释：
 * <p>
 * 两个点 ".." 表示上一级目录（父目录）。
 * <p>
 * 示例 4：
 * <p>
 * 输入：path = "/../"
 * <p>
 * 输出："/"
 * <p>
 * 解释：
 * <p>
 * 不可能从根目录上升一级目录。
 * <p>
 * 示例 5：
 * <p>
 * 输入：path = "/.../a/../b/c/../d/./"
 * <p>
 * 输出："/.../b/d"
 * <p>
 * 解释：
 * <p>
 * "..." 在这个问题中是一个合法的目录名。
 */
public class SimplePath {

	public static void main(String[] args) {
//		String path = "/.../a/../b/c/../d/./";
		String path = "//../";
		System.out.println(path);
		System.out.println(simplifyPath(path));
	}

	static public String simplifyPath(String path) {
		String[] paths = path.split("/");
		Stack<String> stack = new Stack<>();
		System.out.println(Arrays.toString(paths));
		for (String s : paths) {
			if (!(s.equals("") || s.equals(".") || s.equals(".."))) {
				stack.push(s);
			} else if (s.equals("..") && !stack.empty()) {
				stack.pop();
			}
		}
		return "/" + String.join("/", stack);
	}
}
