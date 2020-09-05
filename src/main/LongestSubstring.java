package main;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet();
		int i = 0;
		int j = 0;
		int max = 0;
		while (i < s.length() && j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, j - i );
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubstring ls = new LongestSubstring();
		System.out.println(ls.lengthOfLongestSubstring("abababababde"));
	}
}
