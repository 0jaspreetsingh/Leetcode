package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/

public class GroupAnagrams {
	
	class Node implements Comparable<Node>{
		String str;
		int index;
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.str.compareTo(o.str);
		}
		@Override
		public String toString() {
			return "Node [str=" + str + ", index=" + index + "]";
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> result = new ArrayList();
		
		Node[] arrSorted = new Node[strs.length];
		for(int i=0;i<strs.length;i++) {
			arrSorted[i] = new Node();
			arrSorted[i].str = sort(strs[i]);
			arrSorted[i].index = i;
		}
		
		Arrays.sort(arrSorted);
		
		ArrayList<String> list = new ArrayList<String>();
		result.add(list);
		
		list.add(strs[arrSorted[0].index]);
		
		for(int i=1;i<strs.length;i++) {
			if(arrSorted[i-1].str.equals(arrSorted[i].str)) {
				result.get(result.size()-1).add(strs[arrSorted[i].index]);
			}else {
				ArrayList<String> t = new ArrayList<String>();
				t.add(strs[arrSorted[i].index]);
				result.add(t);
			}
		}
		
		
		return result;
	}

	public static String sort(String str) {
		char strArr[] = str.toCharArray();
		Arrays.sort(strArr);
		return new String(strArr);
	}
	

	public static void main(String args[]) {
		GroupAnagrams dc = new GroupAnagrams();
		String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(dc.groupAnagrams(strs));
	}

}
