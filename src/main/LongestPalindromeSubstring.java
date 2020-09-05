package main;

import java.util.Scanner;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromeSubstring {

	public static void ShowArray(boolean arr[][], String str) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(str.charAt(i) + " ");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static String longestPalindrome(String str) {
		
		int length = str.length();
		
		if(length==0) {
			return "";
		}
		
		boolean dp[][] = new boolean[length][length];

		for (int i = 0; i < length; i++) {
			dp[i][i] = true;
		}

		int start = 0;
		int end = 0;

		int maxLen = 0;

		for (int i = 0; i < length - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				dp[i][i + 1] = true;
				start = i;
				end = i + 1;
				maxLen = 2;
			}
		}

		for (int k = 3; k <= length; k++) {
			for (int i = 0; i <= length - k; i++) {
				if (dp[i + 1][i + k - 2] && str.charAt(i) == str.charAt(i + k - 1)) {
					dp[i][i + k - 1] = true;
					if (k > maxLen) {
						start = i;
						end = i + k - 1;
					}
				}
			}
		}
		//ShowArray(dp, str);

		return str.substring(start, end + 1);
	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);

		String str = s.nextLine();

		System.out.println(longestPalindrome(str));
	}

}
